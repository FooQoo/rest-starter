package com.dxjunkyard.reststarter.infrastructure.db.repository.sql;

import com.dxjunkyard.reststarter.domain.model.CompanyPosition;
import com.dxjunkyard.reststarter.domain.model.Member;
import com.dxjunkyard.reststarter.domain.model.search.MemberSearchCondition;
import io.r2dbc.spi.Row;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

@RequiredArgsConstructor
public class MemberSearchSqlHelper {

    private final MemberSearchCondition condition;

    @NonNull
    public String generateSelectQuery() {
        final StringBuilder queryBuilder = new StringBuilder("SELECT ")
                .append(Column.getSelectColumns())
                .append(getLeftJoin());

        // 検索条件がwhere句を設定せずに返す
        if (!condition.hasCondition()) {
            return queryBuilder.toString();
        }

        final var conditions = new ArrayList<String>();

        condition.getName().ifPresent(name -> {
            conditions.add(getWhereCondition(Column.MEMBER_NAME));
        });

        condition.getCompanyPositionId().ifPresent(companyPositionId -> {
            conditions.add(getWhereCondition(Column.MEMBER_COMPANY_POSITION_ID));
        });

        queryBuilder.append("WHERE " + String.join(" AND ", conditions));

        return queryBuilder.toString();
    }

    @NonNull
    public Map<String, Object> generateParamMap() {
        final Map<String, Object> paramMap = new HashMap<>();

        condition.getName().ifPresent(name -> {
            paramMap.put(Column.MEMBER_NAME.getBindAlias(), name);
        });

        condition.getCompanyPositionId().ifPresent(companyPositionId -> {
            paramMap.put(Column.MEMBER_COMPANY_POSITION_ID.getBindAlias(), companyPositionId);
        });

        return Collections.unmodifiableMap(paramMap);
    }

    public Member mapRow(final Row row) {

        final var companyPosition = CompanyPosition.builder()
                .companyPositionId(
                        row.get(Column.MEMBER_COMPANY_POSITION_ID.getAlias(), Integer.class))
                .name(row.get(Column.COMPANY_POSITION_NAME.getAlias(), String.class))
                .build();

        return Member.builder()
                .memberId(row.get(Column.MEMBER_ID.getAlias(), Integer.class))
                .name(row.get(Column.MEMBER_NAME.getAlias(), String.class))
                .companyPosition(companyPosition)
                .build();
    }

    private String getWhereCondition(final Column columnName) {
        return columnName.getFullColumnName() + " = :" + columnName.getBindAlias();
    }

    private String getLeftJoin() {
        return " FROM " + Table.MEMBER.getValue() + " LEFT JOIN "
                + Table.COMPANY_POSITION.getValue() + " ON "
                + Column.MEMBER_COMPANY_POSITION_ID.getFullColumnName() + " = "
                + Column.COMPANY_COMPANY_POSITION_ID.getFullColumnName()
                + " ";
    }

    @RequiredArgsConstructor
    @Getter
    private enum Column {
        MEMBER_ID(Table.MEMBER, "member_id", "member_id"),
        MEMBER_NAME(Table.MEMBER, "name", "member_name"),
        MEMBER_COMPANY_POSITION_ID(Table.MEMBER, "company_position_id", "company_position_id"),
        COMPANY_COMPANY_POSITION_ID(Table.COMPANY_POSITION, "company_position_id",
                "company_position_id"),
        COMPANY_POSITION_NAME(Table.COMPANY_POSITION, "name", "company_position_name"),
        ;

        private final Table table;

        private final String columnName;

        private final String alias;

        @NonNull
        private static String getSelectColumns() {
            return Arrays.stream(Column.values())
                    .map(column -> column.getFullColumnName() + " AS " + column.getAlias())
                    .collect(Collectors.joining(", "));
        }

        @NonNull
        private String getFullColumnName() {
            return table.getValue() + "." + columnName;
        }

        @NonNull
        private String getBindAlias() {
            return table.getValue() + "_" + columnName;
        }
    }

    @RequiredArgsConstructor
    @Getter
    private enum Table {
        MEMBER("member"),
        COMPANY_POSITION("company_position"),
        ;

        private final String value;
    }
}

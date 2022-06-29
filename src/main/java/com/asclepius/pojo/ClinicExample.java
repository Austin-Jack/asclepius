package com.asclepius.pojo;

import java.util.ArrayList;
import java.util.List;

public class ClinicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClinicExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCliIdIsNull() {
            addCriterion("cli_id is null");
            return (Criteria) this;
        }

        public Criteria andCliIdIsNotNull() {
            addCriterion("cli_id is not null");
            return (Criteria) this;
        }

        public Criteria andCliIdEqualTo(Integer value) {
            addCriterion("cli_id =", value, "cliId");
            return (Criteria) this;
        }

        public Criteria andCliIdNotEqualTo(Integer value) {
            addCriterion("cli_id <>", value, "cliId");
            return (Criteria) this;
        }

        public Criteria andCliIdGreaterThan(Integer value) {
            addCriterion("cli_id >", value, "cliId");
            return (Criteria) this;
        }

        public Criteria andCliIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cli_id >=", value, "cliId");
            return (Criteria) this;
        }

        public Criteria andCliIdLessThan(Integer value) {
            addCriterion("cli_id <", value, "cliId");
            return (Criteria) this;
        }

        public Criteria andCliIdLessThanOrEqualTo(Integer value) {
            addCriterion("cli_id <=", value, "cliId");
            return (Criteria) this;
        }

        public Criteria andCliIdIn(List<Integer> values) {
            addCriterion("cli_id in", values, "cliId");
            return (Criteria) this;
        }

        public Criteria andCliIdNotIn(List<Integer> values) {
            addCriterion("cli_id not in", values, "cliId");
            return (Criteria) this;
        }

        public Criteria andCliIdBetween(Integer value1, Integer value2) {
            addCriterion("cli_id between", value1, value2, "cliId");
            return (Criteria) this;
        }

        public Criteria andCliIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cli_id not between", value1, value2, "cliId");
            return (Criteria) this;
        }

        public Criteria andCliNameIsNull() {
            addCriterion("cli_name is null");
            return (Criteria) this;
        }

        public Criteria andCliNameIsNotNull() {
            addCriterion("cli_name is not null");
            return (Criteria) this;
        }

        public Criteria andCliNameEqualTo(String value) {
            addCriterion("cli_name =", value, "cliName");
            return (Criteria) this;
        }

        public Criteria andCliNameNotEqualTo(String value) {
            addCriterion("cli_name <>", value, "cliName");
            return (Criteria) this;
        }

        public Criteria andCliNameGreaterThan(String value) {
            addCriterion("cli_name >", value, "cliName");
            return (Criteria) this;
        }

        public Criteria andCliNameGreaterThanOrEqualTo(String value) {
            addCriterion("cli_name >=", value, "cliName");
            return (Criteria) this;
        }

        public Criteria andCliNameLessThan(String value) {
            addCriterion("cli_name <", value, "cliName");
            return (Criteria) this;
        }

        public Criteria andCliNameLessThanOrEqualTo(String value) {
            addCriterion("cli_name <=", value, "cliName");
            return (Criteria) this;
        }

        public Criteria andCliNameLike(String value) {
            addCriterion("cli_name like", value, "cliName");
            return (Criteria) this;
        }

        public Criteria andCliNameNotLike(String value) {
            addCriterion("cli_name not like", value, "cliName");
            return (Criteria) this;
        }

        public Criteria andCliNameIn(List<String> values) {
            addCriterion("cli_name in", values, "cliName");
            return (Criteria) this;
        }

        public Criteria andCliNameNotIn(List<String> values) {
            addCriterion("cli_name not in", values, "cliName");
            return (Criteria) this;
        }

        public Criteria andCliNameBetween(String value1, String value2) {
            addCriterion("cli_name between", value1, value2, "cliName");
            return (Criteria) this;
        }

        public Criteria andCliNameNotBetween(String value1, String value2) {
            addCriterion("cli_name not between", value1, value2, "cliName");
            return (Criteria) this;
        }

        public Criteria andCliLevelIsNull() {
            addCriterion("cli_level is null");
            return (Criteria) this;
        }

        public Criteria andCliLevelIsNotNull() {
            addCriterion("cli_level is not null");
            return (Criteria) this;
        }

        public Criteria andCliLevelEqualTo(Integer value) {
            addCriterion("cli_level =", value, "cliLevel");
            return (Criteria) this;
        }

        public Criteria andCliLevelNotEqualTo(Integer value) {
            addCriterion("cli_level <>", value, "cliLevel");
            return (Criteria) this;
        }

        public Criteria andCliLevelGreaterThan(Integer value) {
            addCriterion("cli_level >", value, "cliLevel");
            return (Criteria) this;
        }

        public Criteria andCliLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("cli_level >=", value, "cliLevel");
            return (Criteria) this;
        }

        public Criteria andCliLevelLessThan(Integer value) {
            addCriterion("cli_level <", value, "cliLevel");
            return (Criteria) this;
        }

        public Criteria andCliLevelLessThanOrEqualTo(Integer value) {
            addCriterion("cli_level <=", value, "cliLevel");
            return (Criteria) this;
        }

        public Criteria andCliLevelIn(List<Integer> values) {
            addCriterion("cli_level in", values, "cliLevel");
            return (Criteria) this;
        }

        public Criteria andCliLevelNotIn(List<Integer> values) {
            addCriterion("cli_level not in", values, "cliLevel");
            return (Criteria) this;
        }

        public Criteria andCliLevelBetween(Integer value1, Integer value2) {
            addCriterion("cli_level between", value1, value2, "cliLevel");
            return (Criteria) this;
        }

        public Criteria andCliLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("cli_level not between", value1, value2, "cliLevel");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
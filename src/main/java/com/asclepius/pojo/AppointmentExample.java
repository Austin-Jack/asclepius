package com.asclepius.pojo;

import java.util.ArrayList;
import java.util.List;

public class AppointmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppointmentExample() {
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

        public Criteria andApIdIsNull() {
            addCriterion("ap_id is null");
            return (Criteria) this;
        }

        public Criteria andApIdIsNotNull() {
            addCriterion("ap_id is not null");
            return (Criteria) this;
        }

        public Criteria andApIdEqualTo(Integer value) {
            addCriterion("ap_id =", value, "apId");
            return (Criteria) this;
        }

        public Criteria andApIdNotEqualTo(Integer value) {
            addCriterion("ap_id <>", value, "apId");
            return (Criteria) this;
        }

        public Criteria andApIdGreaterThan(Integer value) {
            addCriterion("ap_id >", value, "apId");
            return (Criteria) this;
        }

        public Criteria andApIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ap_id >=", value, "apId");
            return (Criteria) this;
        }

        public Criteria andApIdLessThan(Integer value) {
            addCriterion("ap_id <", value, "apId");
            return (Criteria) this;
        }

        public Criteria andApIdLessThanOrEqualTo(Integer value) {
            addCriterion("ap_id <=", value, "apId");
            return (Criteria) this;
        }

        public Criteria andApIdIn(List<Integer> values) {
            addCriterion("ap_id in", values, "apId");
            return (Criteria) this;
        }

        public Criteria andApIdNotIn(List<Integer> values) {
            addCriterion("ap_id not in", values, "apId");
            return (Criteria) this;
        }

        public Criteria andApIdBetween(Integer value1, Integer value2) {
            addCriterion("ap_id between", value1, value2, "apId");
            return (Criteria) this;
        }

        public Criteria andApIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ap_id not between", value1, value2, "apId");
            return (Criteria) this;
        }

        public Criteria andCIdIsNull() {
            addCriterion("c_id is null");
            return (Criteria) this;
        }

        public Criteria andCIdIsNotNull() {
            addCriterion("c_id is not null");
            return (Criteria) this;
        }

        public Criteria andCIdEqualTo(Integer value) {
            addCriterion("c_id =", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotEqualTo(Integer value) {
            addCriterion("c_id <>", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThan(Integer value) {
            addCriterion("c_id >", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_id >=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThan(Integer value) {
            addCriterion("c_id <", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThanOrEqualTo(Integer value) {
            addCriterion("c_id <=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdIn(List<Integer> values) {
            addCriterion("c_id in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotIn(List<Integer> values) {
            addCriterion("c_id not in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdBetween(Integer value1, Integer value2) {
            addCriterion("c_id between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotBetween(Integer value1, Integer value2) {
            addCriterion("c_id not between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andApNumIsNull() {
            addCriterion("ap_num is null");
            return (Criteria) this;
        }

        public Criteria andApNumIsNotNull() {
            addCriterion("ap_num is not null");
            return (Criteria) this;
        }

        public Criteria andApNumEqualTo(Integer value) {
            addCriterion("ap_num =", value, "apNum");
            return (Criteria) this;
        }

        public Criteria andApNumNotEqualTo(Integer value) {
            addCriterion("ap_num <>", value, "apNum");
            return (Criteria) this;
        }

        public Criteria andApNumGreaterThan(Integer value) {
            addCriterion("ap_num >", value, "apNum");
            return (Criteria) this;
        }

        public Criteria andApNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("ap_num >=", value, "apNum");
            return (Criteria) this;
        }

        public Criteria andApNumLessThan(Integer value) {
            addCriterion("ap_num <", value, "apNum");
            return (Criteria) this;
        }

        public Criteria andApNumLessThanOrEqualTo(Integer value) {
            addCriterion("ap_num <=", value, "apNum");
            return (Criteria) this;
        }

        public Criteria andApNumIn(List<Integer> values) {
            addCriterion("ap_num in", values, "apNum");
            return (Criteria) this;
        }

        public Criteria andApNumNotIn(List<Integer> values) {
            addCriterion("ap_num not in", values, "apNum");
            return (Criteria) this;
        }

        public Criteria andApNumBetween(Integer value1, Integer value2) {
            addCriterion("ap_num between", value1, value2, "apNum");
            return (Criteria) this;
        }

        public Criteria andApNumNotBetween(Integer value1, Integer value2) {
            addCriterion("ap_num not between", value1, value2, "apNum");
            return (Criteria) this;
        }

        public Criteria andApTimeIsNull() {
            addCriterion("ap_time is null");
            return (Criteria) this;
        }

        public Criteria andApTimeIsNotNull() {
            addCriterion("ap_time is not null");
            return (Criteria) this;
        }

        public Criteria andApTimeEqualTo(Long value) {
            addCriterion("ap_time =", value, "apTime");
            return (Criteria) this;
        }

        public Criteria andApTimeNotEqualTo(Long value) {
            addCriterion("ap_time <>", value, "apTime");
            return (Criteria) this;
        }

        public Criteria andApTimeGreaterThan(Long value) {
            addCriterion("ap_time >", value, "apTime");
            return (Criteria) this;
        }

        public Criteria andApTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("ap_time >=", value, "apTime");
            return (Criteria) this;
        }

        public Criteria andApTimeLessThan(Long value) {
            addCriterion("ap_time <", value, "apTime");
            return (Criteria) this;
        }

        public Criteria andApTimeLessThanOrEqualTo(Long value) {
            addCriterion("ap_time <=", value, "apTime");
            return (Criteria) this;
        }

        public Criteria andApTimeIn(List<Long> values) {
            addCriterion("ap_time in", values, "apTime");
            return (Criteria) this;
        }

        public Criteria andApTimeNotIn(List<Long> values) {
            addCriterion("ap_time not in", values, "apTime");
            return (Criteria) this;
        }

        public Criteria andApTimeBetween(Long value1, Long value2) {
            addCriterion("ap_time between", value1, value2, "apTime");
            return (Criteria) this;
        }

        public Criteria andApTimeNotBetween(Long value1, Long value2) {
            addCriterion("ap_time not between", value1, value2, "apTime");
            return (Criteria) this;
        }

        public Criteria andDocNameIsNull() {
            addCriterion("doc_name is null");
            return (Criteria) this;
        }

        public Criteria andDocNameIsNotNull() {
            addCriterion("doc_name is not null");
            return (Criteria) this;
        }

        public Criteria andDocNameEqualTo(String value) {
            addCriterion("doc_name =", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameNotEqualTo(String value) {
            addCriterion("doc_name <>", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameGreaterThan(String value) {
            addCriterion("doc_name >", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameGreaterThanOrEqualTo(String value) {
            addCriterion("doc_name >=", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameLessThan(String value) {
            addCriterion("doc_name <", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameLessThanOrEqualTo(String value) {
            addCriterion("doc_name <=", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameLike(String value) {
            addCriterion("doc_name like", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameNotLike(String value) {
            addCriterion("doc_name not like", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameIn(List<String> values) {
            addCriterion("doc_name in", values, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameNotIn(List<String> values) {
            addCriterion("doc_name not in", values, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameBetween(String value1, String value2) {
            addCriterion("doc_name between", value1, value2, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameNotBetween(String value1, String value2) {
            addCriterion("doc_name not between", value1, value2, "docName");
            return (Criteria) this;
        }

        public Criteria andDNameIsNull() {
            addCriterion("d_name is null");
            return (Criteria) this;
        }

        public Criteria andDNameIsNotNull() {
            addCriterion("d_name is not null");
            return (Criteria) this;
        }

        public Criteria andDNameEqualTo(String value) {
            addCriterion("d_name =", value, "dName");
            return (Criteria) this;
        }

        public Criteria andDNameNotEqualTo(String value) {
            addCriterion("d_name <>", value, "dName");
            return (Criteria) this;
        }

        public Criteria andDNameGreaterThan(String value) {
            addCriterion("d_name >", value, "dName");
            return (Criteria) this;
        }

        public Criteria andDNameGreaterThanOrEqualTo(String value) {
            addCriterion("d_name >=", value, "dName");
            return (Criteria) this;
        }

        public Criteria andDNameLessThan(String value) {
            addCriterion("d_name <", value, "dName");
            return (Criteria) this;
        }

        public Criteria andDNameLessThanOrEqualTo(String value) {
            addCriterion("d_name <=", value, "dName");
            return (Criteria) this;
        }

        public Criteria andDNameLike(String value) {
            addCriterion("d_name like", value, "dName");
            return (Criteria) this;
        }

        public Criteria andDNameNotLike(String value) {
            addCriterion("d_name not like", value, "dName");
            return (Criteria) this;
        }

        public Criteria andDNameIn(List<String> values) {
            addCriterion("d_name in", values, "dName");
            return (Criteria) this;
        }

        public Criteria andDNameNotIn(List<String> values) {
            addCriterion("d_name not in", values, "dName");
            return (Criteria) this;
        }

        public Criteria andDNameBetween(String value1, String value2) {
            addCriterion("d_name between", value1, value2, "dName");
            return (Criteria) this;
        }

        public Criteria andDNameNotBetween(String value1, String value2) {
            addCriterion("d_name not between", value1, value2, "dName");
            return (Criteria) this;
        }

        public Criteria andCNameIsNull() {
            addCriterion("c_name is null");
            return (Criteria) this;
        }

        public Criteria andCNameIsNotNull() {
            addCriterion("c_name is not null");
            return (Criteria) this;
        }

        public Criteria andCNameEqualTo(String value) {
            addCriterion("c_name =", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotEqualTo(String value) {
            addCriterion("c_name <>", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameGreaterThan(String value) {
            addCriterion("c_name >", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameGreaterThanOrEqualTo(String value) {
            addCriterion("c_name >=", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLessThan(String value) {
            addCriterion("c_name <", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLessThanOrEqualTo(String value) {
            addCriterion("c_name <=", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLike(String value) {
            addCriterion("c_name like", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotLike(String value) {
            addCriterion("c_name not like", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameIn(List<String> values) {
            addCriterion("c_name in", values, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotIn(List<String> values) {
            addCriterion("c_name not in", values, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameBetween(String value1, String value2) {
            addCriterion("c_name between", value1, value2, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotBetween(String value1, String value2) {
            addCriterion("c_name not between", value1, value2, "cName");
            return (Criteria) this;
        }

        public Criteria andApCostIsNull() {
            addCriterion("ap_cost is null");
            return (Criteria) this;
        }

        public Criteria andApCostIsNotNull() {
            addCriterion("ap_cost is not null");
            return (Criteria) this;
        }

        public Criteria andApCostEqualTo(Float value) {
            addCriterion("ap_cost =", value, "apCost");
            return (Criteria) this;
        }

        public Criteria andApCostNotEqualTo(Float value) {
            addCriterion("ap_cost <>", value, "apCost");
            return (Criteria) this;
        }

        public Criteria andApCostGreaterThan(Float value) {
            addCriterion("ap_cost >", value, "apCost");
            return (Criteria) this;
        }

        public Criteria andApCostGreaterThanOrEqualTo(Float value) {
            addCriterion("ap_cost >=", value, "apCost");
            return (Criteria) this;
        }

        public Criteria andApCostLessThan(Float value) {
            addCriterion("ap_cost <", value, "apCost");
            return (Criteria) this;
        }

        public Criteria andApCostLessThanOrEqualTo(Float value) {
            addCriterion("ap_cost <=", value, "apCost");
            return (Criteria) this;
        }

        public Criteria andApCostIn(List<Float> values) {
            addCriterion("ap_cost in", values, "apCost");
            return (Criteria) this;
        }

        public Criteria andApCostNotIn(List<Float> values) {
            addCriterion("ap_cost not in", values, "apCost");
            return (Criteria) this;
        }

        public Criteria andApCostBetween(Float value1, Float value2) {
            addCriterion("ap_cost between", value1, value2, "apCost");
            return (Criteria) this;
        }

        public Criteria andApCostNotBetween(Float value1, Float value2) {
            addCriterion("ap_cost not between", value1, value2, "apCost");
            return (Criteria) this;
        }

        public Criteria andApStatusIsNull() {
            addCriterion("ap_status is null");
            return (Criteria) this;
        }

        public Criteria andApStatusIsNotNull() {
            addCriterion("ap_status is not null");
            return (Criteria) this;
        }

        public Criteria andApStatusEqualTo(Integer value) {
            addCriterion("ap_status =", value, "apStatus");
            return (Criteria) this;
        }

        public Criteria andApStatusNotEqualTo(Integer value) {
            addCriterion("ap_status <>", value, "apStatus");
            return (Criteria) this;
        }

        public Criteria andApStatusGreaterThan(Integer value) {
            addCriterion("ap_status >", value, "apStatus");
            return (Criteria) this;
        }

        public Criteria andApStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("ap_status >=", value, "apStatus");
            return (Criteria) this;
        }

        public Criteria andApStatusLessThan(Integer value) {
            addCriterion("ap_status <", value, "apStatus");
            return (Criteria) this;
        }

        public Criteria andApStatusLessThanOrEqualTo(Integer value) {
            addCriterion("ap_status <=", value, "apStatus");
            return (Criteria) this;
        }

        public Criteria andApStatusIn(List<Integer> values) {
            addCriterion("ap_status in", values, "apStatus");
            return (Criteria) this;
        }

        public Criteria andApStatusNotIn(List<Integer> values) {
            addCriterion("ap_status not in", values, "apStatus");
            return (Criteria) this;
        }

        public Criteria andApStatusBetween(Integer value1, Integer value2) {
            addCriterion("ap_status between", value1, value2, "apStatus");
            return (Criteria) this;
        }

        public Criteria andApStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("ap_status not between", value1, value2, "apStatus");
            return (Criteria) this;
        }

        public Criteria andSIdIsNull() {
            addCriterion("s_id is null");
            return (Criteria) this;
        }

        public Criteria andSIdIsNotNull() {
            addCriterion("s_id is not null");
            return (Criteria) this;
        }

        public Criteria andSIdEqualTo(Integer value) {
            addCriterion("s_id =", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotEqualTo(Integer value) {
            addCriterion("s_id <>", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThan(Integer value) {
            addCriterion("s_id >", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_id >=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThan(Integer value) {
            addCriterion("s_id <", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThanOrEqualTo(Integer value) {
            addCriterion("s_id <=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdIn(List<Integer> values) {
            addCriterion("s_id in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotIn(List<Integer> values) {
            addCriterion("s_id not in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdBetween(Integer value1, Integer value2) {
            addCriterion("s_id between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotBetween(Integer value1, Integer value2) {
            addCriterion("s_id not between", value1, value2, "sId");
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
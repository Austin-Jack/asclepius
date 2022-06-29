package com.asclepius.pojo;

import java.util.ArrayList;
import java.util.List;

public class PrescriptionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrescriptionExample() {
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

        public Criteria andPreIdIsNull() {
            addCriterion("pre_id is null");
            return (Criteria) this;
        }

        public Criteria andPreIdIsNotNull() {
            addCriterion("pre_id is not null");
            return (Criteria) this;
        }

        public Criteria andPreIdEqualTo(Integer value) {
            addCriterion("pre_id =", value, "preId");
            return (Criteria) this;
        }

        public Criteria andPreIdNotEqualTo(Integer value) {
            addCriterion("pre_id <>", value, "preId");
            return (Criteria) this;
        }

        public Criteria andPreIdGreaterThan(Integer value) {
            addCriterion("pre_id >", value, "preId");
            return (Criteria) this;
        }

        public Criteria andPreIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pre_id >=", value, "preId");
            return (Criteria) this;
        }

        public Criteria andPreIdLessThan(Integer value) {
            addCriterion("pre_id <", value, "preId");
            return (Criteria) this;
        }

        public Criteria andPreIdLessThanOrEqualTo(Integer value) {
            addCriterion("pre_id <=", value, "preId");
            return (Criteria) this;
        }

        public Criteria andPreIdIn(List<Integer> values) {
            addCriterion("pre_id in", values, "preId");
            return (Criteria) this;
        }

        public Criteria andPreIdNotIn(List<Integer> values) {
            addCriterion("pre_id not in", values, "preId");
            return (Criteria) this;
        }

        public Criteria andPreIdBetween(Integer value1, Integer value2) {
            addCriterion("pre_id between", value1, value2, "preId");
            return (Criteria) this;
        }

        public Criteria andPreIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pre_id not between", value1, value2, "preId");
            return (Criteria) this;
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

        public Criteria andPreCommentIsNull() {
            addCriterion("pre_comment is null");
            return (Criteria) this;
        }

        public Criteria andPreCommentIsNotNull() {
            addCriterion("pre_comment is not null");
            return (Criteria) this;
        }

        public Criteria andPreCommentEqualTo(String value) {
            addCriterion("pre_comment =", value, "preComment");
            return (Criteria) this;
        }

        public Criteria andPreCommentNotEqualTo(String value) {
            addCriterion("pre_comment <>", value, "preComment");
            return (Criteria) this;
        }

        public Criteria andPreCommentGreaterThan(String value) {
            addCriterion("pre_comment >", value, "preComment");
            return (Criteria) this;
        }

        public Criteria andPreCommentGreaterThanOrEqualTo(String value) {
            addCriterion("pre_comment >=", value, "preComment");
            return (Criteria) this;
        }

        public Criteria andPreCommentLessThan(String value) {
            addCriterion("pre_comment <", value, "preComment");
            return (Criteria) this;
        }

        public Criteria andPreCommentLessThanOrEqualTo(String value) {
            addCriterion("pre_comment <=", value, "preComment");
            return (Criteria) this;
        }

        public Criteria andPreCommentLike(String value) {
            addCriterion("pre_comment like", value, "preComment");
            return (Criteria) this;
        }

        public Criteria andPreCommentNotLike(String value) {
            addCriterion("pre_comment not like", value, "preComment");
            return (Criteria) this;
        }

        public Criteria andPreCommentIn(List<String> values) {
            addCriterion("pre_comment in", values, "preComment");
            return (Criteria) this;
        }

        public Criteria andPreCommentNotIn(List<String> values) {
            addCriterion("pre_comment not in", values, "preComment");
            return (Criteria) this;
        }

        public Criteria andPreCommentBetween(String value1, String value2) {
            addCriterion("pre_comment between", value1, value2, "preComment");
            return (Criteria) this;
        }

        public Criteria andPreCommentNotBetween(String value1, String value2) {
            addCriterion("pre_comment not between", value1, value2, "preComment");
            return (Criteria) this;
        }

        public Criteria andPreCostIsNull() {
            addCriterion("pre_cost is null");
            return (Criteria) this;
        }

        public Criteria andPreCostIsNotNull() {
            addCriterion("pre_cost is not null");
            return (Criteria) this;
        }

        public Criteria andPreCostEqualTo(Float value) {
            addCriterion("pre_cost =", value, "preCost");
            return (Criteria) this;
        }

        public Criteria andPreCostNotEqualTo(Float value) {
            addCriterion("pre_cost <>", value, "preCost");
            return (Criteria) this;
        }

        public Criteria andPreCostGreaterThan(Float value) {
            addCriterion("pre_cost >", value, "preCost");
            return (Criteria) this;
        }

        public Criteria andPreCostGreaterThanOrEqualTo(Float value) {
            addCriterion("pre_cost >=", value, "preCost");
            return (Criteria) this;
        }

        public Criteria andPreCostLessThan(Float value) {
            addCriterion("pre_cost <", value, "preCost");
            return (Criteria) this;
        }

        public Criteria andPreCostLessThanOrEqualTo(Float value) {
            addCriterion("pre_cost <=", value, "preCost");
            return (Criteria) this;
        }

        public Criteria andPreCostIn(List<Float> values) {
            addCriterion("pre_cost in", values, "preCost");
            return (Criteria) this;
        }

        public Criteria andPreCostNotIn(List<Float> values) {
            addCriterion("pre_cost not in", values, "preCost");
            return (Criteria) this;
        }

        public Criteria andPreCostBetween(Float value1, Float value2) {
            addCriterion("pre_cost between", value1, value2, "preCost");
            return (Criteria) this;
        }

        public Criteria andPreCostNotBetween(Float value1, Float value2) {
            addCriterion("pre_cost not between", value1, value2, "preCost");
            return (Criteria) this;
        }

        public Criteria andPreStatusIsNull() {
            addCriterion("pre_status is null");
            return (Criteria) this;
        }

        public Criteria andPreStatusIsNotNull() {
            addCriterion("pre_status is not null");
            return (Criteria) this;
        }

        public Criteria andPreStatusEqualTo(Integer value) {
            addCriterion("pre_status =", value, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPreStatusNotEqualTo(Integer value) {
            addCriterion("pre_status <>", value, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPreStatusGreaterThan(Integer value) {
            addCriterion("pre_status >", value, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPreStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("pre_status >=", value, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPreStatusLessThan(Integer value) {
            addCriterion("pre_status <", value, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPreStatusLessThanOrEqualTo(Integer value) {
            addCriterion("pre_status <=", value, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPreStatusIn(List<Integer> values) {
            addCriterion("pre_status in", values, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPreStatusNotIn(List<Integer> values) {
            addCriterion("pre_status not in", values, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPreStatusBetween(Integer value1, Integer value2) {
            addCriterion("pre_status between", value1, value2, "preStatus");
            return (Criteria) this;
        }

        public Criteria andPreStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("pre_status not between", value1, value2, "preStatus");
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
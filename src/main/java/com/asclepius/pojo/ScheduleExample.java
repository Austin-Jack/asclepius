package com.asclepius.pojo;

import java.util.ArrayList;
import java.util.List;

public class ScheduleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScheduleExample() {
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

        public Criteria andDocIdIsNull() {
            addCriterion("doc_id is null");
            return (Criteria) this;
        }

        public Criteria andDocIdIsNotNull() {
            addCriterion("doc_id is not null");
            return (Criteria) this;
        }

        public Criteria andDocIdEqualTo(Integer value) {
            addCriterion("doc_id =", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdNotEqualTo(Integer value) {
            addCriterion("doc_id <>", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdGreaterThan(Integer value) {
            addCriterion("doc_id >", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("doc_id >=", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdLessThan(Integer value) {
            addCriterion("doc_id <", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdLessThanOrEqualTo(Integer value) {
            addCriterion("doc_id <=", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdIn(List<Integer> values) {
            addCriterion("doc_id in", values, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdNotIn(List<Integer> values) {
            addCriterion("doc_id not in", values, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdBetween(Integer value1, Integer value2) {
            addCriterion("doc_id between", value1, value2, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdNotBetween(Integer value1, Integer value2) {
            addCriterion("doc_id not between", value1, value2, "docId");
            return (Criteria) this;
        }

        public Criteria andScStartTimeIsNull() {
            addCriterion("sc_start_time is null");
            return (Criteria) this;
        }

        public Criteria andScStartTimeIsNotNull() {
            addCriterion("sc_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andScStartTimeEqualTo(Long value) {
            addCriterion("sc_start_time =", value, "scStartTime");
            return (Criteria) this;
        }

        public Criteria andScStartTimeNotEqualTo(Long value) {
            addCriterion("sc_start_time <>", value, "scStartTime");
            return (Criteria) this;
        }

        public Criteria andScStartTimeGreaterThan(Long value) {
            addCriterion("sc_start_time >", value, "scStartTime");
            return (Criteria) this;
        }

        public Criteria andScStartTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("sc_start_time >=", value, "scStartTime");
            return (Criteria) this;
        }

        public Criteria andScStartTimeLessThan(Long value) {
            addCriterion("sc_start_time <", value, "scStartTime");
            return (Criteria) this;
        }

        public Criteria andScStartTimeLessThanOrEqualTo(Long value) {
            addCriterion("sc_start_time <=", value, "scStartTime");
            return (Criteria) this;
        }

        public Criteria andScStartTimeIn(List<Long> values) {
            addCriterion("sc_start_time in", values, "scStartTime");
            return (Criteria) this;
        }

        public Criteria andScStartTimeNotIn(List<Long> values) {
            addCriterion("sc_start_time not in", values, "scStartTime");
            return (Criteria) this;
        }

        public Criteria andScStartTimeBetween(Long value1, Long value2) {
            addCriterion("sc_start_time between", value1, value2, "scStartTime");
            return (Criteria) this;
        }

        public Criteria andScStartTimeNotBetween(Long value1, Long value2) {
            addCriterion("sc_start_time not between", value1, value2, "scStartTime");
            return (Criteria) this;
        }

        public Criteria andScEndTimeIsNull() {
            addCriterion("sc_end_time is null");
            return (Criteria) this;
        }

        public Criteria andScEndTimeIsNotNull() {
            addCriterion("sc_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andScEndTimeEqualTo(Long value) {
            addCriterion("sc_end_time =", value, "scEndTime");
            return (Criteria) this;
        }

        public Criteria andScEndTimeNotEqualTo(Long value) {
            addCriterion("sc_end_time <>", value, "scEndTime");
            return (Criteria) this;
        }

        public Criteria andScEndTimeGreaterThan(Long value) {
            addCriterion("sc_end_time >", value, "scEndTime");
            return (Criteria) this;
        }

        public Criteria andScEndTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("sc_end_time >=", value, "scEndTime");
            return (Criteria) this;
        }

        public Criteria andScEndTimeLessThan(Long value) {
            addCriterion("sc_end_time <", value, "scEndTime");
            return (Criteria) this;
        }

        public Criteria andScEndTimeLessThanOrEqualTo(Long value) {
            addCriterion("sc_end_time <=", value, "scEndTime");
            return (Criteria) this;
        }

        public Criteria andScEndTimeIn(List<Long> values) {
            addCriterion("sc_end_time in", values, "scEndTime");
            return (Criteria) this;
        }

        public Criteria andScEndTimeNotIn(List<Long> values) {
            addCriterion("sc_end_time not in", values, "scEndTime");
            return (Criteria) this;
        }

        public Criteria andScEndTimeBetween(Long value1, Long value2) {
            addCriterion("sc_end_time between", value1, value2, "scEndTime");
            return (Criteria) this;
        }

        public Criteria andScEndTimeNotBetween(Long value1, Long value2) {
            addCriterion("sc_end_time not between", value1, value2, "scEndTime");
            return (Criteria) this;
        }

        public Criteria andDocPriceIsNull() {
            addCriterion("doc_price is null");
            return (Criteria) this;
        }

        public Criteria andDocPriceIsNotNull() {
            addCriterion("doc_price is not null");
            return (Criteria) this;
        }

        public Criteria andDocPriceEqualTo(Float value) {
            addCriterion("doc_price =", value, "docPrice");
            return (Criteria) this;
        }

        public Criteria andDocPriceNotEqualTo(Float value) {
            addCriterion("doc_price <>", value, "docPrice");
            return (Criteria) this;
        }

        public Criteria andDocPriceGreaterThan(Float value) {
            addCriterion("doc_price >", value, "docPrice");
            return (Criteria) this;
        }

        public Criteria andDocPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("doc_price >=", value, "docPrice");
            return (Criteria) this;
        }

        public Criteria andDocPriceLessThan(Float value) {
            addCriterion("doc_price <", value, "docPrice");
            return (Criteria) this;
        }

        public Criteria andDocPriceLessThanOrEqualTo(Float value) {
            addCriterion("doc_price <=", value, "docPrice");
            return (Criteria) this;
        }

        public Criteria andDocPriceIn(List<Float> values) {
            addCriterion("doc_price in", values, "docPrice");
            return (Criteria) this;
        }

        public Criteria andDocPriceNotIn(List<Float> values) {
            addCriterion("doc_price not in", values, "docPrice");
            return (Criteria) this;
        }

        public Criteria andDocPriceBetween(Float value1, Float value2) {
            addCriterion("doc_price between", value1, value2, "docPrice");
            return (Criteria) this;
        }

        public Criteria andDocPriceNotBetween(Float value1, Float value2) {
            addCriterion("doc_price not between", value1, value2, "docPrice");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("num not between", value1, value2, "num");
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
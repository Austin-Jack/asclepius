package com.asclepius.pojo;

import java.util.ArrayList;
import java.util.List;

public class DoctorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DoctorExample() {
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

        public Criteria andDIdIsNull() {
            addCriterion("d_id is null");
            return (Criteria) this;
        }

        public Criteria andDIdIsNotNull() {
            addCriterion("d_id is not null");
            return (Criteria) this;
        }

        public Criteria andDIdEqualTo(Integer value) {
            addCriterion("d_id =", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdNotEqualTo(Integer value) {
            addCriterion("d_id <>", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdGreaterThan(Integer value) {
            addCriterion("d_id >", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("d_id >=", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdLessThan(Integer value) {
            addCriterion("d_id <", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdLessThanOrEqualTo(Integer value) {
            addCriterion("d_id <=", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdIn(List<Integer> values) {
            addCriterion("d_id in", values, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdNotIn(List<Integer> values) {
            addCriterion("d_id not in", values, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdBetween(Integer value1, Integer value2) {
            addCriterion("d_id between", value1, value2, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdNotBetween(Integer value1, Integer value2) {
            addCriterion("d_id not between", value1, value2, "dId");
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

        public Criteria andDocSexIsNull() {
            addCriterion("doc_sex is null");
            return (Criteria) this;
        }

        public Criteria andDocSexIsNotNull() {
            addCriterion("doc_sex is not null");
            return (Criteria) this;
        }

        public Criteria andDocSexEqualTo(Integer value) {
            addCriterion("doc_sex =", value, "docSex");
            return (Criteria) this;
        }

        public Criteria andDocSexNotEqualTo(Integer value) {
            addCriterion("doc_sex <>", value, "docSex");
            return (Criteria) this;
        }

        public Criteria andDocSexGreaterThan(Integer value) {
            addCriterion("doc_sex >", value, "docSex");
            return (Criteria) this;
        }

        public Criteria andDocSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("doc_sex >=", value, "docSex");
            return (Criteria) this;
        }

        public Criteria andDocSexLessThan(Integer value) {
            addCriterion("doc_sex <", value, "docSex");
            return (Criteria) this;
        }

        public Criteria andDocSexLessThanOrEqualTo(Integer value) {
            addCriterion("doc_sex <=", value, "docSex");
            return (Criteria) this;
        }

        public Criteria andDocSexIn(List<Integer> values) {
            addCriterion("doc_sex in", values, "docSex");
            return (Criteria) this;
        }

        public Criteria andDocSexNotIn(List<Integer> values) {
            addCriterion("doc_sex not in", values, "docSex");
            return (Criteria) this;
        }

        public Criteria andDocSexBetween(Integer value1, Integer value2) {
            addCriterion("doc_sex between", value1, value2, "docSex");
            return (Criteria) this;
        }

        public Criteria andDocSexNotBetween(Integer value1, Integer value2) {
            addCriterion("doc_sex not between", value1, value2, "docSex");
            return (Criteria) this;
        }

        public Criteria andDocRankIsNull() {
            addCriterion("doc_rank is null");
            return (Criteria) this;
        }

        public Criteria andDocRankIsNotNull() {
            addCriterion("doc_rank is not null");
            return (Criteria) this;
        }

        public Criteria andDocRankEqualTo(Integer value) {
            addCriterion("doc_rank =", value, "docRank");
            return (Criteria) this;
        }

        public Criteria andDocRankNotEqualTo(Integer value) {
            addCriterion("doc_rank <>", value, "docRank");
            return (Criteria) this;
        }

        public Criteria andDocRankGreaterThan(Integer value) {
            addCriterion("doc_rank >", value, "docRank");
            return (Criteria) this;
        }

        public Criteria andDocRankGreaterThanOrEqualTo(Integer value) {
            addCriterion("doc_rank >=", value, "docRank");
            return (Criteria) this;
        }

        public Criteria andDocRankLessThan(Integer value) {
            addCriterion("doc_rank <", value, "docRank");
            return (Criteria) this;
        }

        public Criteria andDocRankLessThanOrEqualTo(Integer value) {
            addCriterion("doc_rank <=", value, "docRank");
            return (Criteria) this;
        }

        public Criteria andDocRankIn(List<Integer> values) {
            addCriterion("doc_rank in", values, "docRank");
            return (Criteria) this;
        }

        public Criteria andDocRankNotIn(List<Integer> values) {
            addCriterion("doc_rank not in", values, "docRank");
            return (Criteria) this;
        }

        public Criteria andDocRankBetween(Integer value1, Integer value2) {
            addCriterion("doc_rank between", value1, value2, "docRank");
            return (Criteria) this;
        }

        public Criteria andDocRankNotBetween(Integer value1, Integer value2) {
            addCriterion("doc_rank not between", value1, value2, "docRank");
            return (Criteria) this;
        }

        public Criteria andDocImageIsNull() {
            addCriterion("doc_image is null");
            return (Criteria) this;
        }

        public Criteria andDocImageIsNotNull() {
            addCriterion("doc_image is not null");
            return (Criteria) this;
        }

        public Criteria andDocImageEqualTo(String value) {
            addCriterion("doc_image =", value, "docImage");
            return (Criteria) this;
        }

        public Criteria andDocImageNotEqualTo(String value) {
            addCriterion("doc_image <>", value, "docImage");
            return (Criteria) this;
        }

        public Criteria andDocImageGreaterThan(String value) {
            addCriterion("doc_image >", value, "docImage");
            return (Criteria) this;
        }

        public Criteria andDocImageGreaterThanOrEqualTo(String value) {
            addCriterion("doc_image >=", value, "docImage");
            return (Criteria) this;
        }

        public Criteria andDocImageLessThan(String value) {
            addCriterion("doc_image <", value, "docImage");
            return (Criteria) this;
        }

        public Criteria andDocImageLessThanOrEqualTo(String value) {
            addCriterion("doc_image <=", value, "docImage");
            return (Criteria) this;
        }

        public Criteria andDocImageLike(String value) {
            addCriterion("doc_image like", value, "docImage");
            return (Criteria) this;
        }

        public Criteria andDocImageNotLike(String value) {
            addCriterion("doc_image not like", value, "docImage");
            return (Criteria) this;
        }

        public Criteria andDocImageIn(List<String> values) {
            addCriterion("doc_image in", values, "docImage");
            return (Criteria) this;
        }

        public Criteria andDocImageNotIn(List<String> values) {
            addCriterion("doc_image not in", values, "docImage");
            return (Criteria) this;
        }

        public Criteria andDocImageBetween(String value1, String value2) {
            addCriterion("doc_image between", value1, value2, "docImage");
            return (Criteria) this;
        }

        public Criteria andDocImageNotBetween(String value1, String value2) {
            addCriterion("doc_image not between", value1, value2, "docImage");
            return (Criteria) this;
        }

        public Criteria andDocDetailIsNull() {
            addCriterion("doc_detail is null");
            return (Criteria) this;
        }

        public Criteria andDocDetailIsNotNull() {
            addCriterion("doc_detail is not null");
            return (Criteria) this;
        }

        public Criteria andDocDetailEqualTo(String value) {
            addCriterion("doc_detail =", value, "docDetail");
            return (Criteria) this;
        }

        public Criteria andDocDetailNotEqualTo(String value) {
            addCriterion("doc_detail <>", value, "docDetail");
            return (Criteria) this;
        }

        public Criteria andDocDetailGreaterThan(String value) {
            addCriterion("doc_detail >", value, "docDetail");
            return (Criteria) this;
        }

        public Criteria andDocDetailGreaterThanOrEqualTo(String value) {
            addCriterion("doc_detail >=", value, "docDetail");
            return (Criteria) this;
        }

        public Criteria andDocDetailLessThan(String value) {
            addCriterion("doc_detail <", value, "docDetail");
            return (Criteria) this;
        }

        public Criteria andDocDetailLessThanOrEqualTo(String value) {
            addCriterion("doc_detail <=", value, "docDetail");
            return (Criteria) this;
        }

        public Criteria andDocDetailLike(String value) {
            addCriterion("doc_detail like", value, "docDetail");
            return (Criteria) this;
        }

        public Criteria andDocDetailNotLike(String value) {
            addCriterion("doc_detail not like", value, "docDetail");
            return (Criteria) this;
        }

        public Criteria andDocDetailIn(List<String> values) {
            addCriterion("doc_detail in", values, "docDetail");
            return (Criteria) this;
        }

        public Criteria andDocDetailNotIn(List<String> values) {
            addCriterion("doc_detail not in", values, "docDetail");
            return (Criteria) this;
        }

        public Criteria andDocDetailBetween(String value1, String value2) {
            addCriterion("doc_detail between", value1, value2, "docDetail");
            return (Criteria) this;
        }

        public Criteria andDocDetailNotBetween(String value1, String value2) {
            addCriterion("doc_detail not between", value1, value2, "docDetail");
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
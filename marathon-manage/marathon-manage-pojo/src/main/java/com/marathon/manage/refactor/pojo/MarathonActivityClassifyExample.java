package com.marathon.manage.refactor.pojo;

import java.util.ArrayList;
import java.util.List;

public class MarathonActivityClassifyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MarathonActivityClassifyExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andMarathonActivityclassifyUuidIsNull() {
            addCriterion("marathon_activityclassify_uuid is null");
            return (Criteria) this;
        }

        public Criteria andMarathonActivityclassifyUuidIsNotNull() {
            addCriterion("marathon_activityclassify_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andMarathonActivityclassifyUuidEqualTo(String value) {
            addCriterion("marathon_activityclassify_uuid =", value, "marathonActivityclassifyUuid");
            return (Criteria) this;
        }

        public Criteria andMarathonActivityclassifyUuidNotEqualTo(String value) {
            addCriterion("marathon_activityclassify_uuid <>", value, "marathonActivityclassifyUuid");
            return (Criteria) this;
        }

        public Criteria andMarathonActivityclassifyUuidGreaterThan(String value) {
            addCriterion("marathon_activityclassify_uuid >", value, "marathonActivityclassifyUuid");
            return (Criteria) this;
        }

        public Criteria andMarathonActivityclassifyUuidGreaterThanOrEqualTo(String value) {
            addCriterion("marathon_activityclassify_uuid >=", value, "marathonActivityclassifyUuid");
            return (Criteria) this;
        }

        public Criteria andMarathonActivityclassifyUuidLessThan(String value) {
            addCriterion("marathon_activityclassify_uuid <", value, "marathonActivityclassifyUuid");
            return (Criteria) this;
        }

        public Criteria andMarathonActivityclassifyUuidLessThanOrEqualTo(String value) {
            addCriterion("marathon_activityclassify_uuid <=", value, "marathonActivityclassifyUuid");
            return (Criteria) this;
        }

        public Criteria andMarathonActivityclassifyUuidLike(String value) {
            addCriterion("marathon_activityclassify_uuid like", value, "marathonActivityclassifyUuid");
            return (Criteria) this;
        }

        public Criteria andMarathonActivityclassifyUuidNotLike(String value) {
            addCriterion("marathon_activityclassify_uuid not like", value, "marathonActivityclassifyUuid");
            return (Criteria) this;
        }

        public Criteria andMarathonActivityclassifyUuidIn(List<String> values) {
            addCriterion("marathon_activityclassify_uuid in", values, "marathonActivityclassifyUuid");
            return (Criteria) this;
        }

        public Criteria andMarathonActivityclassifyUuidNotIn(List<String> values) {
            addCriterion("marathon_activityclassify_uuid not in", values, "marathonActivityclassifyUuid");
            return (Criteria) this;
        }

        public Criteria andMarathonActivityclassifyUuidBetween(String value1, String value2) {
            addCriterion("marathon_activityclassify_uuid between", value1, value2, "marathonActivityclassifyUuid");
            return (Criteria) this;
        }

        public Criteria andMarathonActivityclassifyUuidNotBetween(String value1, String value2) {
            addCriterion("marathon_activityclassify_uuid not between", value1, value2, "marathonActivityclassifyUuid");
            return (Criteria) this;
        }

        public Criteria andMarathonIdIsNull() {
            addCriterion("marathon_id is null");
            return (Criteria) this;
        }

        public Criteria andMarathonIdIsNotNull() {
            addCriterion("marathon_id is not null");
            return (Criteria) this;
        }

        public Criteria andMarathonIdEqualTo(String value) {
            addCriterion("marathon_id =", value, "marathonId");
            return (Criteria) this;
        }

        public Criteria andMarathonIdNotEqualTo(String value) {
            addCriterion("marathon_id <>", value, "marathonId");
            return (Criteria) this;
        }

        public Criteria andMarathonIdGreaterThan(String value) {
            addCriterion("marathon_id >", value, "marathonId");
            return (Criteria) this;
        }

        public Criteria andMarathonIdGreaterThanOrEqualTo(String value) {
            addCriterion("marathon_id >=", value, "marathonId");
            return (Criteria) this;
        }

        public Criteria andMarathonIdLessThan(String value) {
            addCriterion("marathon_id <", value, "marathonId");
            return (Criteria) this;
        }

        public Criteria andMarathonIdLessThanOrEqualTo(String value) {
            addCriterion("marathon_id <=", value, "marathonId");
            return (Criteria) this;
        }

        public Criteria andMarathonIdLike(String value) {
            addCriterion("marathon_id like", value, "marathonId");
            return (Criteria) this;
        }

        public Criteria andMarathonIdNotLike(String value) {
            addCriterion("marathon_id not like", value, "marathonId");
            return (Criteria) this;
        }

        public Criteria andMarathonIdIn(List<String> values) {
            addCriterion("marathon_id in", values, "marathonId");
            return (Criteria) this;
        }

        public Criteria andMarathonIdNotIn(List<String> values) {
            addCriterion("marathon_id not in", values, "marathonId");
            return (Criteria) this;
        }

        public Criteria andMarathonIdBetween(String value1, String value2) {
            addCriterion("marathon_id between", value1, value2, "marathonId");
            return (Criteria) this;
        }

        public Criteria andMarathonIdNotBetween(String value1, String value2) {
            addCriterion("marathon_id not between", value1, value2, "marathonId");
            return (Criteria) this;
        }

        public Criteria andActivityclassifyIsNull() {
            addCriterion("activityclassify is null");
            return (Criteria) this;
        }

        public Criteria andActivityclassifyIsNotNull() {
            addCriterion("activityclassify is not null");
            return (Criteria) this;
        }

        public Criteria andActivityclassifyEqualTo(String value) {
            addCriterion("activityclassify =", value, "activityclassify");
            return (Criteria) this;
        }

        public Criteria andActivityclassifyNotEqualTo(String value) {
            addCriterion("activityclassify <>", value, "activityclassify");
            return (Criteria) this;
        }

        public Criteria andActivityclassifyGreaterThan(String value) {
            addCriterion("activityclassify >", value, "activityclassify");
            return (Criteria) this;
        }

        public Criteria andActivityclassifyGreaterThanOrEqualTo(String value) {
            addCriterion("activityclassify >=", value, "activityclassify");
            return (Criteria) this;
        }

        public Criteria andActivityclassifyLessThan(String value) {
            addCriterion("activityclassify <", value, "activityclassify");
            return (Criteria) this;
        }

        public Criteria andActivityclassifyLessThanOrEqualTo(String value) {
            addCriterion("activityclassify <=", value, "activityclassify");
            return (Criteria) this;
        }

        public Criteria andActivityclassifyLike(String value) {
            addCriterion("activityclassify like", value, "activityclassify");
            return (Criteria) this;
        }

        public Criteria andActivityclassifyNotLike(String value) {
            addCriterion("activityclassify not like", value, "activityclassify");
            return (Criteria) this;
        }

        public Criteria andActivityclassifyIn(List<String> values) {
            addCriterion("activityclassify in", values, "activityclassify");
            return (Criteria) this;
        }

        public Criteria andActivityclassifyNotIn(List<String> values) {
            addCriterion("activityclassify not in", values, "activityclassify");
            return (Criteria) this;
        }

        public Criteria andActivityclassifyBetween(String value1, String value2) {
            addCriterion("activityclassify between", value1, value2, "activityclassify");
            return (Criteria) this;
        }

        public Criteria andActivityclassifyNotBetween(String value1, String value2) {
            addCriterion("activityclassify not between", value1, value2, "activityclassify");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagIsNull() {
            addCriterion("deleted_flag is null");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagIsNotNull() {
            addCriterion("deleted_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagEqualTo(Boolean value) {
            addCriterion("deleted_flag =", value, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagNotEqualTo(Boolean value) {
            addCriterion("deleted_flag <>", value, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagGreaterThan(Boolean value) {
            addCriterion("deleted_flag >", value, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("deleted_flag >=", value, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagLessThan(Boolean value) {
            addCriterion("deleted_flag <", value, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("deleted_flag <=", value, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagIn(List<Boolean> values) {
            addCriterion("deleted_flag in", values, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagNotIn(List<Boolean> values) {
            addCriterion("deleted_flag not in", values, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("deleted_flag between", value1, value2, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("deleted_flag not between", value1, value2, "deletedFlag");
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
package com.marathon.manage.refactor.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VolunteerInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VolunteerInfoExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(Integer value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(Integer value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(Integer value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(Integer value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Integer> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Integer> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andLocationIdIsNull() {
            addCriterion("location_id is null");
            return (Criteria) this;
        }

        public Criteria andLocationIdIsNotNull() {
            addCriterion("location_id is not null");
            return (Criteria) this;
        }

        public Criteria andLocationIdEqualTo(Integer value) {
            addCriterion("location_id =", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdNotEqualTo(Integer value) {
            addCriterion("location_id <>", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdGreaterThan(Integer value) {
            addCriterion("location_id >", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("location_id >=", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdLessThan(Integer value) {
            addCriterion("location_id <", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdLessThanOrEqualTo(Integer value) {
            addCriterion("location_id <=", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdIn(List<Integer> values) {
            addCriterion("location_id in", values, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdNotIn(List<Integer> values) {
            addCriterion("location_id not in", values, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdBetween(Integer value1, Integer value2) {
            addCriterion("location_id between", value1, value2, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("location_id not between", value1, value2, "locationId");
            return (Criteria) this;
        }

        public Criteria andGenderRequireIsNull() {
            addCriterion("gender_require is null");
            return (Criteria) this;
        }

        public Criteria andGenderRequireIsNotNull() {
            addCriterion("gender_require is not null");
            return (Criteria) this;
        }

        public Criteria andGenderRequireEqualTo(Integer value) {
            addCriterion("gender_require =", value, "genderRequire");
            return (Criteria) this;
        }

        public Criteria andGenderRequireNotEqualTo(Integer value) {
            addCriterion("gender_require <>", value, "genderRequire");
            return (Criteria) this;
        }

        public Criteria andGenderRequireGreaterThan(Integer value) {
            addCriterion("gender_require >", value, "genderRequire");
            return (Criteria) this;
        }

        public Criteria andGenderRequireGreaterThanOrEqualTo(Integer value) {
            addCriterion("gender_require >=", value, "genderRequire");
            return (Criteria) this;
        }

        public Criteria andGenderRequireLessThan(Integer value) {
            addCriterion("gender_require <", value, "genderRequire");
            return (Criteria) this;
        }

        public Criteria andGenderRequireLessThanOrEqualTo(Integer value) {
            addCriterion("gender_require <=", value, "genderRequire");
            return (Criteria) this;
        }

        public Criteria andGenderRequireIn(List<Integer> values) {
            addCriterion("gender_require in", values, "genderRequire");
            return (Criteria) this;
        }

        public Criteria andGenderRequireNotIn(List<Integer> values) {
            addCriterion("gender_require not in", values, "genderRequire");
            return (Criteria) this;
        }

        public Criteria andGenderRequireBetween(Integer value1, Integer value2) {
            addCriterion("gender_require between", value1, value2, "genderRequire");
            return (Criteria) this;
        }

        public Criteria andGenderRequireNotBetween(Integer value1, Integer value2) {
            addCriterion("gender_require not between", value1, value2, "genderRequire");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(Integer value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(Integer value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(Integer value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(Integer value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(Integer value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<Integer> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<Integer> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(Integer value1, Integer value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("total not between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andJobRequireIsNull() {
            addCriterion("job_require is null");
            return (Criteria) this;
        }

        public Criteria andJobRequireIsNotNull() {
            addCriterion("job_require is not null");
            return (Criteria) this;
        }

        public Criteria andJobRequireEqualTo(String value) {
            addCriterion("job_require =", value, "jobRequire");
            return (Criteria) this;
        }

        public Criteria andJobRequireNotEqualTo(String value) {
            addCriterion("job_require <>", value, "jobRequire");
            return (Criteria) this;
        }

        public Criteria andJobRequireGreaterThan(String value) {
            addCriterion("job_require >", value, "jobRequire");
            return (Criteria) this;
        }

        public Criteria andJobRequireGreaterThanOrEqualTo(String value) {
            addCriterion("job_require >=", value, "jobRequire");
            return (Criteria) this;
        }

        public Criteria andJobRequireLessThan(String value) {
            addCriterion("job_require <", value, "jobRequire");
            return (Criteria) this;
        }

        public Criteria andJobRequireLessThanOrEqualTo(String value) {
            addCriterion("job_require <=", value, "jobRequire");
            return (Criteria) this;
        }

        public Criteria andJobRequireLike(String value) {
            addCriterion("job_require like", value, "jobRequire");
            return (Criteria) this;
        }

        public Criteria andJobRequireNotLike(String value) {
            addCriterion("job_require not like", value, "jobRequire");
            return (Criteria) this;
        }

        public Criteria andJobRequireIn(List<String> values) {
            addCriterion("job_require in", values, "jobRequire");
            return (Criteria) this;
        }

        public Criteria andJobRequireNotIn(List<String> values) {
            addCriterion("job_require not in", values, "jobRequire");
            return (Criteria) this;
        }

        public Criteria andJobRequireBetween(String value1, String value2) {
            addCriterion("job_require between", value1, value2, "jobRequire");
            return (Criteria) this;
        }

        public Criteria andJobRequireNotBetween(String value1, String value2) {
            addCriterion("job_require not between", value1, value2, "jobRequire");
            return (Criteria) this;
        }

        public Criteria andVolunteerRequireIsNull() {
            addCriterion("volunteer_require is null");
            return (Criteria) this;
        }

        public Criteria andVolunteerRequireIsNotNull() {
            addCriterion("volunteer_require is not null");
            return (Criteria) this;
        }

        public Criteria andVolunteerRequireEqualTo(String value) {
            addCriterion("volunteer_require =", value, "volunteerRequire");
            return (Criteria) this;
        }

        public Criteria andVolunteerRequireNotEqualTo(String value) {
            addCriterion("volunteer_require <>", value, "volunteerRequire");
            return (Criteria) this;
        }

        public Criteria andVolunteerRequireGreaterThan(String value) {
            addCriterion("volunteer_require >", value, "volunteerRequire");
            return (Criteria) this;
        }

        public Criteria andVolunteerRequireGreaterThanOrEqualTo(String value) {
            addCriterion("volunteer_require >=", value, "volunteerRequire");
            return (Criteria) this;
        }

        public Criteria andVolunteerRequireLessThan(String value) {
            addCriterion("volunteer_require <", value, "volunteerRequire");
            return (Criteria) this;
        }

        public Criteria andVolunteerRequireLessThanOrEqualTo(String value) {
            addCriterion("volunteer_require <=", value, "volunteerRequire");
            return (Criteria) this;
        }

        public Criteria andVolunteerRequireLike(String value) {
            addCriterion("volunteer_require like", value, "volunteerRequire");
            return (Criteria) this;
        }

        public Criteria andVolunteerRequireNotLike(String value) {
            addCriterion("volunteer_require not like", value, "volunteerRequire");
            return (Criteria) this;
        }

        public Criteria andVolunteerRequireIn(List<String> values) {
            addCriterion("volunteer_require in", values, "volunteerRequire");
            return (Criteria) this;
        }

        public Criteria andVolunteerRequireNotIn(List<String> values) {
            addCriterion("volunteer_require not in", values, "volunteerRequire");
            return (Criteria) this;
        }

        public Criteria andVolunteerRequireBetween(String value1, String value2) {
            addCriterion("volunteer_require between", value1, value2, "volunteerRequire");
            return (Criteria) this;
        }

        public Criteria andVolunteerRequireNotBetween(String value1, String value2) {
            addCriterion("volunteer_require not between", value1, value2, "volunteerRequire");
            return (Criteria) this;
        }

        public Criteria andTrainDateIsNull() {
            addCriterion("train_date is null");
            return (Criteria) this;
        }

        public Criteria andTrainDateIsNotNull() {
            addCriterion("train_date is not null");
            return (Criteria) this;
        }

        public Criteria andTrainDateEqualTo(Date value) {
            addCriterion("train_date =", value, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainDateNotEqualTo(Date value) {
            addCriterion("train_date <>", value, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainDateGreaterThan(Date value) {
            addCriterion("train_date >", value, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainDateGreaterThanOrEqualTo(Date value) {
            addCriterion("train_date >=", value, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainDateLessThan(Date value) {
            addCriterion("train_date <", value, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainDateLessThanOrEqualTo(Date value) {
            addCriterion("train_date <=", value, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainDateIn(List<Date> values) {
            addCriterion("train_date in", values, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainDateNotIn(List<Date> values) {
            addCriterion("train_date not in", values, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainDateBetween(Date value1, Date value2) {
            addCriterion("train_date between", value1, value2, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainDateNotBetween(Date value1, Date value2) {
            addCriterion("train_date not between", value1, value2, "trainDate");
            return (Criteria) this;
        }

        public Criteria andServiceStarttimeIsNull() {
            addCriterion("service_starttime is null");
            return (Criteria) this;
        }

        public Criteria andServiceStarttimeIsNotNull() {
            addCriterion("service_starttime is not null");
            return (Criteria) this;
        }

        public Criteria andServiceStarttimeEqualTo(Date value) {
            addCriterion("service_starttime =", value, "serviceStarttime");
            return (Criteria) this;
        }

        public Criteria andServiceStarttimeNotEqualTo(Date value) {
            addCriterion("service_starttime <>", value, "serviceStarttime");
            return (Criteria) this;
        }

        public Criteria andServiceStarttimeGreaterThan(Date value) {
            addCriterion("service_starttime >", value, "serviceStarttime");
            return (Criteria) this;
        }

        public Criteria andServiceStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("service_starttime >=", value, "serviceStarttime");
            return (Criteria) this;
        }

        public Criteria andServiceStarttimeLessThan(Date value) {
            addCriterion("service_starttime <", value, "serviceStarttime");
            return (Criteria) this;
        }

        public Criteria andServiceStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("service_starttime <=", value, "serviceStarttime");
            return (Criteria) this;
        }

        public Criteria andServiceStarttimeIn(List<Date> values) {
            addCriterion("service_starttime in", values, "serviceStarttime");
            return (Criteria) this;
        }

        public Criteria andServiceStarttimeNotIn(List<Date> values) {
            addCriterion("service_starttime not in", values, "serviceStarttime");
            return (Criteria) this;
        }

        public Criteria andServiceStarttimeBetween(Date value1, Date value2) {
            addCriterion("service_starttime between", value1, value2, "serviceStarttime");
            return (Criteria) this;
        }

        public Criteria andServiceStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("service_starttime not between", value1, value2, "serviceStarttime");
            return (Criteria) this;
        }

        public Criteria andServiceEndtimeIsNull() {
            addCriterion("service_endtime is null");
            return (Criteria) this;
        }

        public Criteria andServiceEndtimeIsNotNull() {
            addCriterion("service_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andServiceEndtimeEqualTo(Date value) {
            addCriterion("service_endtime =", value, "serviceEndtime");
            return (Criteria) this;
        }

        public Criteria andServiceEndtimeNotEqualTo(Date value) {
            addCriterion("service_endtime <>", value, "serviceEndtime");
            return (Criteria) this;
        }

        public Criteria andServiceEndtimeGreaterThan(Date value) {
            addCriterion("service_endtime >", value, "serviceEndtime");
            return (Criteria) this;
        }

        public Criteria andServiceEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("service_endtime >=", value, "serviceEndtime");
            return (Criteria) this;
        }

        public Criteria andServiceEndtimeLessThan(Date value) {
            addCriterion("service_endtime <", value, "serviceEndtime");
            return (Criteria) this;
        }

        public Criteria andServiceEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("service_endtime <=", value, "serviceEndtime");
            return (Criteria) this;
        }

        public Criteria andServiceEndtimeIn(List<Date> values) {
            addCriterion("service_endtime in", values, "serviceEndtime");
            return (Criteria) this;
        }

        public Criteria andServiceEndtimeNotIn(List<Date> values) {
            addCriterion("service_endtime not in", values, "serviceEndtime");
            return (Criteria) this;
        }

        public Criteria andServiceEndtimeBetween(Date value1, Date value2) {
            addCriterion("service_endtime between", value1, value2, "serviceEndtime");
            return (Criteria) this;
        }

        public Criteria andServiceEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("service_endtime not between", value1, value2, "serviceEndtime");
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
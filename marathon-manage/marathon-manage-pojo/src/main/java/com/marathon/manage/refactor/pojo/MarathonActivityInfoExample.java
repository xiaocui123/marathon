package com.marathon.manage.refactor.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MarathonActivityInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MarathonActivityInfoExample() {
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

        public Criteria andActivityUuidIsNull() {
            addCriterion("activity_uuid is null");
            return (Criteria) this;
        }

        public Criteria andActivityUuidIsNotNull() {
            addCriterion("activity_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andActivityUuidEqualTo(String value) {
            addCriterion("activity_uuid =", value, "activityUuid");
            return (Criteria) this;
        }

        public Criteria andActivityUuidNotEqualTo(String value) {
            addCriterion("activity_uuid <>", value, "activityUuid");
            return (Criteria) this;
        }

        public Criteria andActivityUuidGreaterThan(String value) {
            addCriterion("activity_uuid >", value, "activityUuid");
            return (Criteria) this;
        }

        public Criteria andActivityUuidGreaterThanOrEqualTo(String value) {
            addCriterion("activity_uuid >=", value, "activityUuid");
            return (Criteria) this;
        }

        public Criteria andActivityUuidLessThan(String value) {
            addCriterion("activity_uuid <", value, "activityUuid");
            return (Criteria) this;
        }

        public Criteria andActivityUuidLessThanOrEqualTo(String value) {
            addCriterion("activity_uuid <=", value, "activityUuid");
            return (Criteria) this;
        }

        public Criteria andActivityUuidLike(String value) {
            addCriterion("activity_uuid like", value, "activityUuid");
            return (Criteria) this;
        }

        public Criteria andActivityUuidNotLike(String value) {
            addCriterion("activity_uuid not like", value, "activityUuid");
            return (Criteria) this;
        }

        public Criteria andActivityUuidIn(List<String> values) {
            addCriterion("activity_uuid in", values, "activityUuid");
            return (Criteria) this;
        }

        public Criteria andActivityUuidNotIn(List<String> values) {
            addCriterion("activity_uuid not in", values, "activityUuid");
            return (Criteria) this;
        }

        public Criteria andActivityUuidBetween(String value1, String value2) {
            addCriterion("activity_uuid between", value1, value2, "activityUuid");
            return (Criteria) this;
        }

        public Criteria andActivityUuidNotBetween(String value1, String value2) {
            addCriterion("activity_uuid not between", value1, value2, "activityUuid");
            return (Criteria) this;
        }

        public Criteria andMarathonUuidIsNull() {
            addCriterion("marathon_uuid is null");
            return (Criteria) this;
        }

        public Criteria andMarathonUuidIsNotNull() {
            addCriterion("marathon_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andMarathonUuidEqualTo(String value) {
            addCriterion("marathon_uuid =", value, "marathonUuid");
            return (Criteria) this;
        }

        public Criteria andMarathonUuidNotEqualTo(String value) {
            addCriterion("marathon_uuid <>", value, "marathonUuid");
            return (Criteria) this;
        }

        public Criteria andMarathonUuidGreaterThan(String value) {
            addCriterion("marathon_uuid >", value, "marathonUuid");
            return (Criteria) this;
        }

        public Criteria andMarathonUuidGreaterThanOrEqualTo(String value) {
            addCriterion("marathon_uuid >=", value, "marathonUuid");
            return (Criteria) this;
        }

        public Criteria andMarathonUuidLessThan(String value) {
            addCriterion("marathon_uuid <", value, "marathonUuid");
            return (Criteria) this;
        }

        public Criteria andMarathonUuidLessThanOrEqualTo(String value) {
            addCriterion("marathon_uuid <=", value, "marathonUuid");
            return (Criteria) this;
        }

        public Criteria andMarathonUuidLike(String value) {
            addCriterion("marathon_uuid like", value, "marathonUuid");
            return (Criteria) this;
        }

        public Criteria andMarathonUuidNotLike(String value) {
            addCriterion("marathon_uuid not like", value, "marathonUuid");
            return (Criteria) this;
        }

        public Criteria andMarathonUuidIn(List<String> values) {
            addCriterion("marathon_uuid in", values, "marathonUuid");
            return (Criteria) this;
        }

        public Criteria andMarathonUuidNotIn(List<String> values) {
            addCriterion("marathon_uuid not in", values, "marathonUuid");
            return (Criteria) this;
        }

        public Criteria andMarathonUuidBetween(String value1, String value2) {
            addCriterion("marathon_uuid between", value1, value2, "marathonUuid");
            return (Criteria) this;
        }

        public Criteria andMarathonUuidNotBetween(String value1, String value2) {
            addCriterion("marathon_uuid not between", value1, value2, "marathonUuid");
            return (Criteria) this;
        }

        public Criteria andActivityClassifyIsNull() {
            addCriterion("activity_classify is null");
            return (Criteria) this;
        }

        public Criteria andActivityClassifyIsNotNull() {
            addCriterion("activity_classify is not null");
            return (Criteria) this;
        }

        public Criteria andActivityClassifyEqualTo(String value) {
            addCriterion("activity_classify =", value, "activityClassify");
            return (Criteria) this;
        }

        public Criteria andActivityClassifyNotEqualTo(String value) {
            addCriterion("activity_classify <>", value, "activityClassify");
            return (Criteria) this;
        }

        public Criteria andActivityClassifyGreaterThan(String value) {
            addCriterion("activity_classify >", value, "activityClassify");
            return (Criteria) this;
        }

        public Criteria andActivityClassifyGreaterThanOrEqualTo(String value) {
            addCriterion("activity_classify >=", value, "activityClassify");
            return (Criteria) this;
        }

        public Criteria andActivityClassifyLessThan(String value) {
            addCriterion("activity_classify <", value, "activityClassify");
            return (Criteria) this;
        }

        public Criteria andActivityClassifyLessThanOrEqualTo(String value) {
            addCriterion("activity_classify <=", value, "activityClassify");
            return (Criteria) this;
        }

        public Criteria andActivityClassifyLike(String value) {
            addCriterion("activity_classify like", value, "activityClassify");
            return (Criteria) this;
        }

        public Criteria andActivityClassifyNotLike(String value) {
            addCriterion("activity_classify not like", value, "activityClassify");
            return (Criteria) this;
        }

        public Criteria andActivityClassifyIn(List<String> values) {
            addCriterion("activity_classify in", values, "activityClassify");
            return (Criteria) this;
        }

        public Criteria andActivityClassifyNotIn(List<String> values) {
            addCriterion("activity_classify not in", values, "activityClassify");
            return (Criteria) this;
        }

        public Criteria andActivityClassifyBetween(String value1, String value2) {
            addCriterion("activity_classify between", value1, value2, "activityClassify");
            return (Criteria) this;
        }

        public Criteria andActivityClassifyNotBetween(String value1, String value2) {
            addCriterion("activity_classify not between", value1, value2, "activityClassify");
            return (Criteria) this;
        }

        public Criteria andActivityNameIsNull() {
            addCriterion("activity_name is null");
            return (Criteria) this;
        }

        public Criteria andActivityNameIsNotNull() {
            addCriterion("activity_name is not null");
            return (Criteria) this;
        }

        public Criteria andActivityNameEqualTo(String value) {
            addCriterion("activity_name =", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotEqualTo(String value) {
            addCriterion("activity_name <>", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThan(String value) {
            addCriterion("activity_name >", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThanOrEqualTo(String value) {
            addCriterion("activity_name >=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThan(String value) {
            addCriterion("activity_name <", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThanOrEqualTo(String value) {
            addCriterion("activity_name <=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLike(String value) {
            addCriterion("activity_name like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotLike(String value) {
            addCriterion("activity_name not like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameIn(List<String> values) {
            addCriterion("activity_name in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotIn(List<String> values) {
            addCriterion("activity_name not in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameBetween(String value1, String value2) {
            addCriterion("activity_name between", value1, value2, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotBetween(String value1, String value2) {
            addCriterion("activity_name not between", value1, value2, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityProfileIsNull() {
            addCriterion("activity_profile is null");
            return (Criteria) this;
        }

        public Criteria andActivityProfileIsNotNull() {
            addCriterion("activity_profile is not null");
            return (Criteria) this;
        }

        public Criteria andActivityProfileEqualTo(String value) {
            addCriterion("activity_profile =", value, "activityProfile");
            return (Criteria) this;
        }

        public Criteria andActivityProfileNotEqualTo(String value) {
            addCriterion("activity_profile <>", value, "activityProfile");
            return (Criteria) this;
        }

        public Criteria andActivityProfileGreaterThan(String value) {
            addCriterion("activity_profile >", value, "activityProfile");
            return (Criteria) this;
        }

        public Criteria andActivityProfileGreaterThanOrEqualTo(String value) {
            addCriterion("activity_profile >=", value, "activityProfile");
            return (Criteria) this;
        }

        public Criteria andActivityProfileLessThan(String value) {
            addCriterion("activity_profile <", value, "activityProfile");
            return (Criteria) this;
        }

        public Criteria andActivityProfileLessThanOrEqualTo(String value) {
            addCriterion("activity_profile <=", value, "activityProfile");
            return (Criteria) this;
        }

        public Criteria andActivityProfileLike(String value) {
            addCriterion("activity_profile like", value, "activityProfile");
            return (Criteria) this;
        }

        public Criteria andActivityProfileNotLike(String value) {
            addCriterion("activity_profile not like", value, "activityProfile");
            return (Criteria) this;
        }

        public Criteria andActivityProfileIn(List<String> values) {
            addCriterion("activity_profile in", values, "activityProfile");
            return (Criteria) this;
        }

        public Criteria andActivityProfileNotIn(List<String> values) {
            addCriterion("activity_profile not in", values, "activityProfile");
            return (Criteria) this;
        }

        public Criteria andActivityProfileBetween(String value1, String value2) {
            addCriterion("activity_profile between", value1, value2, "activityProfile");
            return (Criteria) this;
        }

        public Criteria andActivityProfileNotBetween(String value1, String value2) {
            addCriterion("activity_profile not between", value1, value2, "activityProfile");
            return (Criteria) this;
        }

        public Criteria andActivityPlanStarttimeIsNull() {
            addCriterion("activity_plan_starttime is null");
            return (Criteria) this;
        }

        public Criteria andActivityPlanStarttimeIsNotNull() {
            addCriterion("activity_plan_starttime is not null");
            return (Criteria) this;
        }

        public Criteria andActivityPlanStarttimeEqualTo(Date value) {
            addCriterion("activity_plan_starttime =", value, "activityPlanStarttime");
            return (Criteria) this;
        }

        public Criteria andActivityPlanStarttimeNotEqualTo(Date value) {
            addCriterion("activity_plan_starttime <>", value, "activityPlanStarttime");
            return (Criteria) this;
        }

        public Criteria andActivityPlanStarttimeGreaterThan(Date value) {
            addCriterion("activity_plan_starttime >", value, "activityPlanStarttime");
            return (Criteria) this;
        }

        public Criteria andActivityPlanStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activity_plan_starttime >=", value, "activityPlanStarttime");
            return (Criteria) this;
        }

        public Criteria andActivityPlanStarttimeLessThan(Date value) {
            addCriterion("activity_plan_starttime <", value, "activityPlanStarttime");
            return (Criteria) this;
        }

        public Criteria andActivityPlanStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("activity_plan_starttime <=", value, "activityPlanStarttime");
            return (Criteria) this;
        }

        public Criteria andActivityPlanStarttimeIn(List<Date> values) {
            addCriterion("activity_plan_starttime in", values, "activityPlanStarttime");
            return (Criteria) this;
        }

        public Criteria andActivityPlanStarttimeNotIn(List<Date> values) {
            addCriterion("activity_plan_starttime not in", values, "activityPlanStarttime");
            return (Criteria) this;
        }

        public Criteria andActivityPlanStarttimeBetween(Date value1, Date value2) {
            addCriterion("activity_plan_starttime between", value1, value2, "activityPlanStarttime");
            return (Criteria) this;
        }

        public Criteria andActivityPlanStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("activity_plan_starttime not between", value1, value2, "activityPlanStarttime");
            return (Criteria) this;
        }

        public Criteria andActivityPlanEndtimeIsNull() {
            addCriterion("activity_plan_endtime is null");
            return (Criteria) this;
        }

        public Criteria andActivityPlanEndtimeIsNotNull() {
            addCriterion("activity_plan_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andActivityPlanEndtimeEqualTo(Date value) {
            addCriterion("activity_plan_endtime =", value, "activityPlanEndtime");
            return (Criteria) this;
        }

        public Criteria andActivityPlanEndtimeNotEqualTo(Date value) {
            addCriterion("activity_plan_endtime <>", value, "activityPlanEndtime");
            return (Criteria) this;
        }

        public Criteria andActivityPlanEndtimeGreaterThan(Date value) {
            addCriterion("activity_plan_endtime >", value, "activityPlanEndtime");
            return (Criteria) this;
        }

        public Criteria andActivityPlanEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activity_plan_endtime >=", value, "activityPlanEndtime");
            return (Criteria) this;
        }

        public Criteria andActivityPlanEndtimeLessThan(Date value) {
            addCriterion("activity_plan_endtime <", value, "activityPlanEndtime");
            return (Criteria) this;
        }

        public Criteria andActivityPlanEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("activity_plan_endtime <=", value, "activityPlanEndtime");
            return (Criteria) this;
        }

        public Criteria andActivityPlanEndtimeIn(List<Date> values) {
            addCriterion("activity_plan_endtime in", values, "activityPlanEndtime");
            return (Criteria) this;
        }

        public Criteria andActivityPlanEndtimeNotIn(List<Date> values) {
            addCriterion("activity_plan_endtime not in", values, "activityPlanEndtime");
            return (Criteria) this;
        }

        public Criteria andActivityPlanEndtimeBetween(Date value1, Date value2) {
            addCriterion("activity_plan_endtime between", value1, value2, "activityPlanEndtime");
            return (Criteria) this;
        }

        public Criteria andActivityPlanEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("activity_plan_endtime not between", value1, value2, "activityPlanEndtime");
            return (Criteria) this;
        }

        public Criteria andActivityDirectorIsNull() {
            addCriterion("activity_director is null");
            return (Criteria) this;
        }

        public Criteria andActivityDirectorIsNotNull() {
            addCriterion("activity_director is not null");
            return (Criteria) this;
        }

        public Criteria andActivityDirectorEqualTo(String value) {
            addCriterion("activity_director =", value, "activityDirector");
            return (Criteria) this;
        }

        public Criteria andActivityDirectorNotEqualTo(String value) {
            addCriterion("activity_director <>", value, "activityDirector");
            return (Criteria) this;
        }

        public Criteria andActivityDirectorGreaterThan(String value) {
            addCriterion("activity_director >", value, "activityDirector");
            return (Criteria) this;
        }

        public Criteria andActivityDirectorGreaterThanOrEqualTo(String value) {
            addCriterion("activity_director >=", value, "activityDirector");
            return (Criteria) this;
        }

        public Criteria andActivityDirectorLessThan(String value) {
            addCriterion("activity_director <", value, "activityDirector");
            return (Criteria) this;
        }

        public Criteria andActivityDirectorLessThanOrEqualTo(String value) {
            addCriterion("activity_director <=", value, "activityDirector");
            return (Criteria) this;
        }

        public Criteria andActivityDirectorLike(String value) {
            addCriterion("activity_director like", value, "activityDirector");
            return (Criteria) this;
        }

        public Criteria andActivityDirectorNotLike(String value) {
            addCriterion("activity_director not like", value, "activityDirector");
            return (Criteria) this;
        }

        public Criteria andActivityDirectorIn(List<String> values) {
            addCriterion("activity_director in", values, "activityDirector");
            return (Criteria) this;
        }

        public Criteria andActivityDirectorNotIn(List<String> values) {
            addCriterion("activity_director not in", values, "activityDirector");
            return (Criteria) this;
        }

        public Criteria andActivityDirectorBetween(String value1, String value2) {
            addCriterion("activity_director between", value1, value2, "activityDirector");
            return (Criteria) this;
        }

        public Criteria andActivityDirectorNotBetween(String value1, String value2) {
            addCriterion("activity_director not between", value1, value2, "activityDirector");
            return (Criteria) this;
        }

        public Criteria andActivityCostIsNull() {
            addCriterion("activity_cost is null");
            return (Criteria) this;
        }

        public Criteria andActivityCostIsNotNull() {
            addCriterion("activity_cost is not null");
            return (Criteria) this;
        }

        public Criteria andActivityCostEqualTo(Long value) {
            addCriterion("activity_cost =", value, "activityCost");
            return (Criteria) this;
        }

        public Criteria andActivityCostNotEqualTo(Long value) {
            addCriterion("activity_cost <>", value, "activityCost");
            return (Criteria) this;
        }

        public Criteria andActivityCostGreaterThan(Long value) {
            addCriterion("activity_cost >", value, "activityCost");
            return (Criteria) this;
        }

        public Criteria andActivityCostGreaterThanOrEqualTo(Long value) {
            addCriterion("activity_cost >=", value, "activityCost");
            return (Criteria) this;
        }

        public Criteria andActivityCostLessThan(Long value) {
            addCriterion("activity_cost <", value, "activityCost");
            return (Criteria) this;
        }

        public Criteria andActivityCostLessThanOrEqualTo(Long value) {
            addCriterion("activity_cost <=", value, "activityCost");
            return (Criteria) this;
        }

        public Criteria andActivityCostIn(List<Long> values) {
            addCriterion("activity_cost in", values, "activityCost");
            return (Criteria) this;
        }

        public Criteria andActivityCostNotIn(List<Long> values) {
            addCriterion("activity_cost not in", values, "activityCost");
            return (Criteria) this;
        }

        public Criteria andActivityCostBetween(Long value1, Long value2) {
            addCriterion("activity_cost between", value1, value2, "activityCost");
            return (Criteria) this;
        }

        public Criteria andActivityCostNotBetween(Long value1, Long value2) {
            addCriterion("activity_cost not between", value1, value2, "activityCost");
            return (Criteria) this;
        }

        public Criteria andActivityStatusIsNull() {
            addCriterion("activity_status is null");
            return (Criteria) this;
        }

        public Criteria andActivityStatusIsNotNull() {
            addCriterion("activity_status is not null");
            return (Criteria) this;
        }

        public Criteria andActivityStatusEqualTo(String value) {
            addCriterion("activity_status =", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusNotEqualTo(String value) {
            addCriterion("activity_status <>", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusGreaterThan(String value) {
            addCriterion("activity_status >", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusGreaterThanOrEqualTo(String value) {
            addCriterion("activity_status >=", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusLessThan(String value) {
            addCriterion("activity_status <", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusLessThanOrEqualTo(String value) {
            addCriterion("activity_status <=", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusLike(String value) {
            addCriterion("activity_status like", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusNotLike(String value) {
            addCriterion("activity_status not like", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusIn(List<String> values) {
            addCriterion("activity_status in", values, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusNotIn(List<String> values) {
            addCriterion("activity_status not in", values, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusBetween(String value1, String value2) {
            addCriterion("activity_status between", value1, value2, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusNotBetween(String value1, String value2) {
            addCriterion("activity_status not between", value1, value2, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityProgressIsNull() {
            addCriterion("activity_progress is null");
            return (Criteria) this;
        }

        public Criteria andActivityProgressIsNotNull() {
            addCriterion("activity_progress is not null");
            return (Criteria) this;
        }

        public Criteria andActivityProgressEqualTo(String value) {
            addCriterion("activity_progress =", value, "activityProgress");
            return (Criteria) this;
        }

        public Criteria andActivityProgressNotEqualTo(String value) {
            addCriterion("activity_progress <>", value, "activityProgress");
            return (Criteria) this;
        }

        public Criteria andActivityProgressGreaterThan(String value) {
            addCriterion("activity_progress >", value, "activityProgress");
            return (Criteria) this;
        }

        public Criteria andActivityProgressGreaterThanOrEqualTo(String value) {
            addCriterion("activity_progress >=", value, "activityProgress");
            return (Criteria) this;
        }

        public Criteria andActivityProgressLessThan(String value) {
            addCriterion("activity_progress <", value, "activityProgress");
            return (Criteria) this;
        }

        public Criteria andActivityProgressLessThanOrEqualTo(String value) {
            addCriterion("activity_progress <=", value, "activityProgress");
            return (Criteria) this;
        }

        public Criteria andActivityProgressLike(String value) {
            addCriterion("activity_progress like", value, "activityProgress");
            return (Criteria) this;
        }

        public Criteria andActivityProgressNotLike(String value) {
            addCriterion("activity_progress not like", value, "activityProgress");
            return (Criteria) this;
        }

        public Criteria andActivityProgressIn(List<String> values) {
            addCriterion("activity_progress in", values, "activityProgress");
            return (Criteria) this;
        }

        public Criteria andActivityProgressNotIn(List<String> values) {
            addCriterion("activity_progress not in", values, "activityProgress");
            return (Criteria) this;
        }

        public Criteria andActivityProgressBetween(String value1, String value2) {
            addCriterion("activity_progress between", value1, value2, "activityProgress");
            return (Criteria) this;
        }

        public Criteria andActivityProgressNotBetween(String value1, String value2) {
            addCriterion("activity_progress not between", value1, value2, "activityProgress");
            return (Criteria) this;
        }

        public Criteria andActivityRealStarttimeIsNull() {
            addCriterion("activity_real_starttime is null");
            return (Criteria) this;
        }

        public Criteria andActivityRealStarttimeIsNotNull() {
            addCriterion("activity_real_starttime is not null");
            return (Criteria) this;
        }

        public Criteria andActivityRealStarttimeEqualTo(Date value) {
            addCriterion("activity_real_starttime =", value, "activityRealStarttime");
            return (Criteria) this;
        }

        public Criteria andActivityRealStarttimeNotEqualTo(Date value) {
            addCriterion("activity_real_starttime <>", value, "activityRealStarttime");
            return (Criteria) this;
        }

        public Criteria andActivityRealStarttimeGreaterThan(Date value) {
            addCriterion("activity_real_starttime >", value, "activityRealStarttime");
            return (Criteria) this;
        }

        public Criteria andActivityRealStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activity_real_starttime >=", value, "activityRealStarttime");
            return (Criteria) this;
        }

        public Criteria andActivityRealStarttimeLessThan(Date value) {
            addCriterion("activity_real_starttime <", value, "activityRealStarttime");
            return (Criteria) this;
        }

        public Criteria andActivityRealStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("activity_real_starttime <=", value, "activityRealStarttime");
            return (Criteria) this;
        }

        public Criteria andActivityRealStarttimeIn(List<Date> values) {
            addCriterion("activity_real_starttime in", values, "activityRealStarttime");
            return (Criteria) this;
        }

        public Criteria andActivityRealStarttimeNotIn(List<Date> values) {
            addCriterion("activity_real_starttime not in", values, "activityRealStarttime");
            return (Criteria) this;
        }

        public Criteria andActivityRealStarttimeBetween(Date value1, Date value2) {
            addCriterion("activity_real_starttime between", value1, value2, "activityRealStarttime");
            return (Criteria) this;
        }

        public Criteria andActivityRealStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("activity_real_starttime not between", value1, value2, "activityRealStarttime");
            return (Criteria) this;
        }

        public Criteria andActivityRealEndtimeIsNull() {
            addCriterion("activity_real_endtime is null");
            return (Criteria) this;
        }

        public Criteria andActivityRealEndtimeIsNotNull() {
            addCriterion("activity_real_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andActivityRealEndtimeEqualTo(Date value) {
            addCriterion("activity_real_endtime =", value, "activityRealEndtime");
            return (Criteria) this;
        }

        public Criteria andActivityRealEndtimeNotEqualTo(Date value) {
            addCriterion("activity_real_endtime <>", value, "activityRealEndtime");
            return (Criteria) this;
        }

        public Criteria andActivityRealEndtimeGreaterThan(Date value) {
            addCriterion("activity_real_endtime >", value, "activityRealEndtime");
            return (Criteria) this;
        }

        public Criteria andActivityRealEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activity_real_endtime >=", value, "activityRealEndtime");
            return (Criteria) this;
        }

        public Criteria andActivityRealEndtimeLessThan(Date value) {
            addCriterion("activity_real_endtime <", value, "activityRealEndtime");
            return (Criteria) this;
        }

        public Criteria andActivityRealEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("activity_real_endtime <=", value, "activityRealEndtime");
            return (Criteria) this;
        }

        public Criteria andActivityRealEndtimeIn(List<Date> values) {
            addCriterion("activity_real_endtime in", values, "activityRealEndtime");
            return (Criteria) this;
        }

        public Criteria andActivityRealEndtimeNotIn(List<Date> values) {
            addCriterion("activity_real_endtime not in", values, "activityRealEndtime");
            return (Criteria) this;
        }

        public Criteria andActivityRealEndtimeBetween(Date value1, Date value2) {
            addCriterion("activity_real_endtime between", value1, value2, "activityRealEndtime");
            return (Criteria) this;
        }

        public Criteria andActivityRealEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("activity_real_endtime not between", value1, value2, "activityRealEndtime");
            return (Criteria) this;
        }

        public Criteria andActivityRealCostIsNull() {
            addCriterion("activity_real_cost is null");
            return (Criteria) this;
        }

        public Criteria andActivityRealCostIsNotNull() {
            addCriterion("activity_real_cost is not null");
            return (Criteria) this;
        }

        public Criteria andActivityRealCostEqualTo(Long value) {
            addCriterion("activity_real_cost =", value, "activityRealCost");
            return (Criteria) this;
        }

        public Criteria andActivityRealCostNotEqualTo(Long value) {
            addCriterion("activity_real_cost <>", value, "activityRealCost");
            return (Criteria) this;
        }

        public Criteria andActivityRealCostGreaterThan(Long value) {
            addCriterion("activity_real_cost >", value, "activityRealCost");
            return (Criteria) this;
        }

        public Criteria andActivityRealCostGreaterThanOrEqualTo(Long value) {
            addCriterion("activity_real_cost >=", value, "activityRealCost");
            return (Criteria) this;
        }

        public Criteria andActivityRealCostLessThan(Long value) {
            addCriterion("activity_real_cost <", value, "activityRealCost");
            return (Criteria) this;
        }

        public Criteria andActivityRealCostLessThanOrEqualTo(Long value) {
            addCriterion("activity_real_cost <=", value, "activityRealCost");
            return (Criteria) this;
        }

        public Criteria andActivityRealCostIn(List<Long> values) {
            addCriterion("activity_real_cost in", values, "activityRealCost");
            return (Criteria) this;
        }

        public Criteria andActivityRealCostNotIn(List<Long> values) {
            addCriterion("activity_real_cost not in", values, "activityRealCost");
            return (Criteria) this;
        }

        public Criteria andActivityRealCostBetween(Long value1, Long value2) {
            addCriterion("activity_real_cost between", value1, value2, "activityRealCost");
            return (Criteria) this;
        }

        public Criteria andActivityRealCostNotBetween(Long value1, Long value2) {
            addCriterion("activity_real_cost not between", value1, value2, "activityRealCost");
            return (Criteria) this;
        }

        public Criteria andActivityCommentsIsNull() {
            addCriterion("activity_comments is null");
            return (Criteria) this;
        }

        public Criteria andActivityCommentsIsNotNull() {
            addCriterion("activity_comments is not null");
            return (Criteria) this;
        }

        public Criteria andActivityCommentsEqualTo(String value) {
            addCriterion("activity_comments =", value, "activityComments");
            return (Criteria) this;
        }

        public Criteria andActivityCommentsNotEqualTo(String value) {
            addCriterion("activity_comments <>", value, "activityComments");
            return (Criteria) this;
        }

        public Criteria andActivityCommentsGreaterThan(String value) {
            addCriterion("activity_comments >", value, "activityComments");
            return (Criteria) this;
        }

        public Criteria andActivityCommentsGreaterThanOrEqualTo(String value) {
            addCriterion("activity_comments >=", value, "activityComments");
            return (Criteria) this;
        }

        public Criteria andActivityCommentsLessThan(String value) {
            addCriterion("activity_comments <", value, "activityComments");
            return (Criteria) this;
        }

        public Criteria andActivityCommentsLessThanOrEqualTo(String value) {
            addCriterion("activity_comments <=", value, "activityComments");
            return (Criteria) this;
        }

        public Criteria andActivityCommentsLike(String value) {
            addCriterion("activity_comments like", value, "activityComments");
            return (Criteria) this;
        }

        public Criteria andActivityCommentsNotLike(String value) {
            addCriterion("activity_comments not like", value, "activityComments");
            return (Criteria) this;
        }

        public Criteria andActivityCommentsIn(List<String> values) {
            addCriterion("activity_comments in", values, "activityComments");
            return (Criteria) this;
        }

        public Criteria andActivityCommentsNotIn(List<String> values) {
            addCriterion("activity_comments not in", values, "activityComments");
            return (Criteria) this;
        }

        public Criteria andActivityCommentsBetween(String value1, String value2) {
            addCriterion("activity_comments between", value1, value2, "activityComments");
            return (Criteria) this;
        }

        public Criteria andActivityCommentsNotBetween(String value1, String value2) {
            addCriterion("activity_comments not between", value1, value2, "activityComments");
            return (Criteria) this;
        }

        public Criteria andActivityCreatorIsNull() {
            addCriterion("activity_creator is null");
            return (Criteria) this;
        }

        public Criteria andActivityCreatorIsNotNull() {
            addCriterion("activity_creator is not null");
            return (Criteria) this;
        }

        public Criteria andActivityCreatorEqualTo(String value) {
            addCriterion("activity_creator =", value, "activityCreator");
            return (Criteria) this;
        }

        public Criteria andActivityCreatorNotEqualTo(String value) {
            addCriterion("activity_creator <>", value, "activityCreator");
            return (Criteria) this;
        }

        public Criteria andActivityCreatorGreaterThan(String value) {
            addCriterion("activity_creator >", value, "activityCreator");
            return (Criteria) this;
        }

        public Criteria andActivityCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("activity_creator >=", value, "activityCreator");
            return (Criteria) this;
        }

        public Criteria andActivityCreatorLessThan(String value) {
            addCriterion("activity_creator <", value, "activityCreator");
            return (Criteria) this;
        }

        public Criteria andActivityCreatorLessThanOrEqualTo(String value) {
            addCriterion("activity_creator <=", value, "activityCreator");
            return (Criteria) this;
        }

        public Criteria andActivityCreatorLike(String value) {
            addCriterion("activity_creator like", value, "activityCreator");
            return (Criteria) this;
        }

        public Criteria andActivityCreatorNotLike(String value) {
            addCriterion("activity_creator not like", value, "activityCreator");
            return (Criteria) this;
        }

        public Criteria andActivityCreatorIn(List<String> values) {
            addCriterion("activity_creator in", values, "activityCreator");
            return (Criteria) this;
        }

        public Criteria andActivityCreatorNotIn(List<String> values) {
            addCriterion("activity_creator not in", values, "activityCreator");
            return (Criteria) this;
        }

        public Criteria andActivityCreatorBetween(String value1, String value2) {
            addCriterion("activity_creator between", value1, value2, "activityCreator");
            return (Criteria) this;
        }

        public Criteria andActivityCreatorNotBetween(String value1, String value2) {
            addCriterion("activity_creator not between", value1, value2, "activityCreator");
            return (Criteria) this;
        }

        public Criteria andActivityCreatetimeIsNull() {
            addCriterion("activity_createtime is null");
            return (Criteria) this;
        }

        public Criteria andActivityCreatetimeIsNotNull() {
            addCriterion("activity_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andActivityCreatetimeEqualTo(Date value) {
            addCriterion("activity_createtime =", value, "activityCreatetime");
            return (Criteria) this;
        }

        public Criteria andActivityCreatetimeNotEqualTo(Date value) {
            addCriterion("activity_createtime <>", value, "activityCreatetime");
            return (Criteria) this;
        }

        public Criteria andActivityCreatetimeGreaterThan(Date value) {
            addCriterion("activity_createtime >", value, "activityCreatetime");
            return (Criteria) this;
        }

        public Criteria andActivityCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activity_createtime >=", value, "activityCreatetime");
            return (Criteria) this;
        }

        public Criteria andActivityCreatetimeLessThan(Date value) {
            addCriterion("activity_createtime <", value, "activityCreatetime");
            return (Criteria) this;
        }

        public Criteria andActivityCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("activity_createtime <=", value, "activityCreatetime");
            return (Criteria) this;
        }

        public Criteria andActivityCreatetimeIn(List<Date> values) {
            addCriterion("activity_createtime in", values, "activityCreatetime");
            return (Criteria) this;
        }

        public Criteria andActivityCreatetimeNotIn(List<Date> values) {
            addCriterion("activity_createtime not in", values, "activityCreatetime");
            return (Criteria) this;
        }

        public Criteria andActivityCreatetimeBetween(Date value1, Date value2) {
            addCriterion("activity_createtime between", value1, value2, "activityCreatetime");
            return (Criteria) this;
        }

        public Criteria andActivityCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("activity_createtime not between", value1, value2, "activityCreatetime");
            return (Criteria) this;
        }

        public Criteria andActivityUpdaterIsNull() {
            addCriterion("activity_updater is null");
            return (Criteria) this;
        }

        public Criteria andActivityUpdaterIsNotNull() {
            addCriterion("activity_updater is not null");
            return (Criteria) this;
        }

        public Criteria andActivityUpdaterEqualTo(String value) {
            addCriterion("activity_updater =", value, "activityUpdater");
            return (Criteria) this;
        }

        public Criteria andActivityUpdaterNotEqualTo(String value) {
            addCriterion("activity_updater <>", value, "activityUpdater");
            return (Criteria) this;
        }

        public Criteria andActivityUpdaterGreaterThan(String value) {
            addCriterion("activity_updater >", value, "activityUpdater");
            return (Criteria) this;
        }

        public Criteria andActivityUpdaterGreaterThanOrEqualTo(String value) {
            addCriterion("activity_updater >=", value, "activityUpdater");
            return (Criteria) this;
        }

        public Criteria andActivityUpdaterLessThan(String value) {
            addCriterion("activity_updater <", value, "activityUpdater");
            return (Criteria) this;
        }

        public Criteria andActivityUpdaterLessThanOrEqualTo(String value) {
            addCriterion("activity_updater <=", value, "activityUpdater");
            return (Criteria) this;
        }

        public Criteria andActivityUpdaterLike(String value) {
            addCriterion("activity_updater like", value, "activityUpdater");
            return (Criteria) this;
        }

        public Criteria andActivityUpdaterNotLike(String value) {
            addCriterion("activity_updater not like", value, "activityUpdater");
            return (Criteria) this;
        }

        public Criteria andActivityUpdaterIn(List<String> values) {
            addCriterion("activity_updater in", values, "activityUpdater");
            return (Criteria) this;
        }

        public Criteria andActivityUpdaterNotIn(List<String> values) {
            addCriterion("activity_updater not in", values, "activityUpdater");
            return (Criteria) this;
        }

        public Criteria andActivityUpdaterBetween(String value1, String value2) {
            addCriterion("activity_updater between", value1, value2, "activityUpdater");
            return (Criteria) this;
        }

        public Criteria andActivityUpdaterNotBetween(String value1, String value2) {
            addCriterion("activity_updater not between", value1, value2, "activityUpdater");
            return (Criteria) this;
        }

        public Criteria andActivityUpdatetimeIsNull() {
            addCriterion("activity_updatetime is null");
            return (Criteria) this;
        }

        public Criteria andActivityUpdatetimeIsNotNull() {
            addCriterion("activity_updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andActivityUpdatetimeEqualTo(Date value) {
            addCriterion("activity_updatetime =", value, "activityUpdatetime");
            return (Criteria) this;
        }

        public Criteria andActivityUpdatetimeNotEqualTo(Date value) {
            addCriterion("activity_updatetime <>", value, "activityUpdatetime");
            return (Criteria) this;
        }

        public Criteria andActivityUpdatetimeGreaterThan(Date value) {
            addCriterion("activity_updatetime >", value, "activityUpdatetime");
            return (Criteria) this;
        }

        public Criteria andActivityUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activity_updatetime >=", value, "activityUpdatetime");
            return (Criteria) this;
        }

        public Criteria andActivityUpdatetimeLessThan(Date value) {
            addCriterion("activity_updatetime <", value, "activityUpdatetime");
            return (Criteria) this;
        }

        public Criteria andActivityUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("activity_updatetime <=", value, "activityUpdatetime");
            return (Criteria) this;
        }

        public Criteria andActivityUpdatetimeIn(List<Date> values) {
            addCriterion("activity_updatetime in", values, "activityUpdatetime");
            return (Criteria) this;
        }

        public Criteria andActivityUpdatetimeNotIn(List<Date> values) {
            addCriterion("activity_updatetime not in", values, "activityUpdatetime");
            return (Criteria) this;
        }

        public Criteria andActivityUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("activity_updatetime between", value1, value2, "activityUpdatetime");
            return (Criteria) this;
        }

        public Criteria andActivityUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("activity_updatetime not between", value1, value2, "activityUpdatetime");
            return (Criteria) this;
        }

        public Criteria andActivityDeletedIsNull() {
            addCriterion("activity_deleted is null");
            return (Criteria) this;
        }

        public Criteria andActivityDeletedIsNotNull() {
            addCriterion("activity_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andActivityDeletedEqualTo(Byte value) {
            addCriterion("activity_deleted =", value, "activityDeleted");
            return (Criteria) this;
        }

        public Criteria andActivityDeletedNotEqualTo(Byte value) {
            addCriterion("activity_deleted <>", value, "activityDeleted");
            return (Criteria) this;
        }

        public Criteria andActivityDeletedGreaterThan(Byte value) {
            addCriterion("activity_deleted >", value, "activityDeleted");
            return (Criteria) this;
        }

        public Criteria andActivityDeletedGreaterThanOrEqualTo(Byte value) {
            addCriterion("activity_deleted >=", value, "activityDeleted");
            return (Criteria) this;
        }

        public Criteria andActivityDeletedLessThan(Byte value) {
            addCriterion("activity_deleted <", value, "activityDeleted");
            return (Criteria) this;
        }

        public Criteria andActivityDeletedLessThanOrEqualTo(Byte value) {
            addCriterion("activity_deleted <=", value, "activityDeleted");
            return (Criteria) this;
        }

        public Criteria andActivityDeletedIn(List<Byte> values) {
            addCriterion("activity_deleted in", values, "activityDeleted");
            return (Criteria) this;
        }

        public Criteria andActivityDeletedNotIn(List<Byte> values) {
            addCriterion("activity_deleted not in", values, "activityDeleted");
            return (Criteria) this;
        }

        public Criteria andActivityDeletedBetween(Byte value1, Byte value2) {
            addCriterion("activity_deleted between", value1, value2, "activityDeleted");
            return (Criteria) this;
        }

        public Criteria andActivityDeletedNotBetween(Byte value1, Byte value2) {
            addCriterion("activity_deleted not between", value1, value2, "activityDeleted");
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
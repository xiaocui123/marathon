package com.marathon.manage.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MarathonInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MarathonInfoExample() {
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

        public Criteria andMarathonNameIsNull() {
            addCriterion("marathon_name is null");
            return (Criteria) this;
        }

        public Criteria andMarathonNameIsNotNull() {
            addCriterion("marathon_name is not null");
            return (Criteria) this;
        }

        public Criteria andMarathonNameEqualTo(String value) {
            addCriterion("marathon_name =", value, "marathonName");
            return (Criteria) this;
        }

        public Criteria andMarathonNameNotEqualTo(String value) {
            addCriterion("marathon_name <>", value, "marathonName");
            return (Criteria) this;
        }

        public Criteria andMarathonNameGreaterThan(String value) {
            addCriterion("marathon_name >", value, "marathonName");
            return (Criteria) this;
        }

        public Criteria andMarathonNameGreaterThanOrEqualTo(String value) {
            addCriterion("marathon_name >=", value, "marathonName");
            return (Criteria) this;
        }

        public Criteria andMarathonNameLessThan(String value) {
            addCriterion("marathon_name <", value, "marathonName");
            return (Criteria) this;
        }

        public Criteria andMarathonNameLessThanOrEqualTo(String value) {
            addCriterion("marathon_name <=", value, "marathonName");
            return (Criteria) this;
        }

        public Criteria andMarathonNameLike(String value) {
            addCriterion("marathon_name like", value, "marathonName");
            return (Criteria) this;
        }

        public Criteria andMarathonNameNotLike(String value) {
            addCriterion("marathon_name not like", value, "marathonName");
            return (Criteria) this;
        }

        public Criteria andMarathonNameIn(List<String> values) {
            addCriterion("marathon_name in", values, "marathonName");
            return (Criteria) this;
        }

        public Criteria andMarathonNameNotIn(List<String> values) {
            addCriterion("marathon_name not in", values, "marathonName");
            return (Criteria) this;
        }

        public Criteria andMarathonNameBetween(String value1, String value2) {
            addCriterion("marathon_name between", value1, value2, "marathonName");
            return (Criteria) this;
        }

        public Criteria andMarathonNameNotBetween(String value1, String value2) {
            addCriterion("marathon_name not between", value1, value2, "marathonName");
            return (Criteria) this;
        }

        public Criteria andMarathonStarttimeIsNull() {
            addCriterion("marathon_starttime is null");
            return (Criteria) this;
        }

        public Criteria andMarathonStarttimeIsNotNull() {
            addCriterion("marathon_starttime is not null");
            return (Criteria) this;
        }

        public Criteria andMarathonStarttimeEqualTo(Date value) {
            addCriterion("marathon_starttime =", value, "marathonStarttime");
            return (Criteria) this;
        }

        public Criteria andMarathonStarttimeNotEqualTo(Date value) {
            addCriterion("marathon_starttime <>", value, "marathonStarttime");
            return (Criteria) this;
        }

        public Criteria andMarathonStarttimeGreaterThan(Date value) {
            addCriterion("marathon_starttime >", value, "marathonStarttime");
            return (Criteria) this;
        }

        public Criteria andMarathonStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("marathon_starttime >=", value, "marathonStarttime");
            return (Criteria) this;
        }

        public Criteria andMarathonStarttimeLessThan(Date value) {
            addCriterion("marathon_starttime <", value, "marathonStarttime");
            return (Criteria) this;
        }

        public Criteria andMarathonStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("marathon_starttime <=", value, "marathonStarttime");
            return (Criteria) this;
        }

        public Criteria andMarathonStarttimeIn(List<Date> values) {
            addCriterion("marathon_starttime in", values, "marathonStarttime");
            return (Criteria) this;
        }

        public Criteria andMarathonStarttimeNotIn(List<Date> values) {
            addCriterion("marathon_starttime not in", values, "marathonStarttime");
            return (Criteria) this;
        }

        public Criteria andMarathonStarttimeBetween(Date value1, Date value2) {
            addCriterion("marathon_starttime between", value1, value2, "marathonStarttime");
            return (Criteria) this;
        }

        public Criteria andMarathonStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("marathon_starttime not between", value1, value2, "marathonStarttime");
            return (Criteria) this;
        }

        public Criteria andMarathonEndtimeIsNull() {
            addCriterion("marathon_endtime is null");
            return (Criteria) this;
        }

        public Criteria andMarathonEndtimeIsNotNull() {
            addCriterion("marathon_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andMarathonEndtimeEqualTo(Date value) {
            addCriterion("marathon_endtime =", value, "marathonEndtime");
            return (Criteria) this;
        }

        public Criteria andMarathonEndtimeNotEqualTo(Date value) {
            addCriterion("marathon_endtime <>", value, "marathonEndtime");
            return (Criteria) this;
        }

        public Criteria andMarathonEndtimeGreaterThan(Date value) {
            addCriterion("marathon_endtime >", value, "marathonEndtime");
            return (Criteria) this;
        }

        public Criteria andMarathonEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("marathon_endtime >=", value, "marathonEndtime");
            return (Criteria) this;
        }

        public Criteria andMarathonEndtimeLessThan(Date value) {
            addCriterion("marathon_endtime <", value, "marathonEndtime");
            return (Criteria) this;
        }

        public Criteria andMarathonEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("marathon_endtime <=", value, "marathonEndtime");
            return (Criteria) this;
        }

        public Criteria andMarathonEndtimeIn(List<Date> values) {
            addCriterion("marathon_endtime in", values, "marathonEndtime");
            return (Criteria) this;
        }

        public Criteria andMarathonEndtimeNotIn(List<Date> values) {
            addCriterion("marathon_endtime not in", values, "marathonEndtime");
            return (Criteria) this;
        }

        public Criteria andMarathonEndtimeBetween(Date value1, Date value2) {
            addCriterion("marathon_endtime between", value1, value2, "marathonEndtime");
            return (Criteria) this;
        }

        public Criteria andMarathonEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("marathon_endtime not between", value1, value2, "marathonEndtime");
            return (Criteria) this;
        }

        public Criteria andMarathonAddressIsNull() {
            addCriterion("marathon_address is null");
            return (Criteria) this;
        }

        public Criteria andMarathonAddressIsNotNull() {
            addCriterion("marathon_address is not null");
            return (Criteria) this;
        }

        public Criteria andMarathonAddressEqualTo(String value) {
            addCriterion("marathon_address =", value, "marathonAddress");
            return (Criteria) this;
        }

        public Criteria andMarathonAddressNotEqualTo(String value) {
            addCriterion("marathon_address <>", value, "marathonAddress");
            return (Criteria) this;
        }

        public Criteria andMarathonAddressGreaterThan(String value) {
            addCriterion("marathon_address >", value, "marathonAddress");
            return (Criteria) this;
        }

        public Criteria andMarathonAddressGreaterThanOrEqualTo(String value) {
            addCriterion("marathon_address >=", value, "marathonAddress");
            return (Criteria) this;
        }

        public Criteria andMarathonAddressLessThan(String value) {
            addCriterion("marathon_address <", value, "marathonAddress");
            return (Criteria) this;
        }

        public Criteria andMarathonAddressLessThanOrEqualTo(String value) {
            addCriterion("marathon_address <=", value, "marathonAddress");
            return (Criteria) this;
        }

        public Criteria andMarathonAddressLike(String value) {
            addCriterion("marathon_address like", value, "marathonAddress");
            return (Criteria) this;
        }

        public Criteria andMarathonAddressNotLike(String value) {
            addCriterion("marathon_address not like", value, "marathonAddress");
            return (Criteria) this;
        }

        public Criteria andMarathonAddressIn(List<String> values) {
            addCriterion("marathon_address in", values, "marathonAddress");
            return (Criteria) this;
        }

        public Criteria andMarathonAddressNotIn(List<String> values) {
            addCriterion("marathon_address not in", values, "marathonAddress");
            return (Criteria) this;
        }

        public Criteria andMarathonAddressBetween(String value1, String value2) {
            addCriterion("marathon_address between", value1, value2, "marathonAddress");
            return (Criteria) this;
        }

        public Criteria andMarathonAddressNotBetween(String value1, String value2) {
            addCriterion("marathon_address not between", value1, value2, "marathonAddress");
            return (Criteria) this;
        }

        public Criteria andMarathonCreaterIsNull() {
            addCriterion("marathon_creater is null");
            return (Criteria) this;
        }

        public Criteria andMarathonCreaterIsNotNull() {
            addCriterion("marathon_creater is not null");
            return (Criteria) this;
        }

        public Criteria andMarathonCreaterEqualTo(String value) {
            addCriterion("marathon_creater =", value, "marathonCreater");
            return (Criteria) this;
        }

        public Criteria andMarathonCreaterNotEqualTo(String value) {
            addCriterion("marathon_creater <>", value, "marathonCreater");
            return (Criteria) this;
        }

        public Criteria andMarathonCreaterGreaterThan(String value) {
            addCriterion("marathon_creater >", value, "marathonCreater");
            return (Criteria) this;
        }

        public Criteria andMarathonCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("marathon_creater >=", value, "marathonCreater");
            return (Criteria) this;
        }

        public Criteria andMarathonCreaterLessThan(String value) {
            addCriterion("marathon_creater <", value, "marathonCreater");
            return (Criteria) this;
        }

        public Criteria andMarathonCreaterLessThanOrEqualTo(String value) {
            addCriterion("marathon_creater <=", value, "marathonCreater");
            return (Criteria) this;
        }

        public Criteria andMarathonCreaterLike(String value) {
            addCriterion("marathon_creater like", value, "marathonCreater");
            return (Criteria) this;
        }

        public Criteria andMarathonCreaterNotLike(String value) {
            addCriterion("marathon_creater not like", value, "marathonCreater");
            return (Criteria) this;
        }

        public Criteria andMarathonCreaterIn(List<String> values) {
            addCriterion("marathon_creater in", values, "marathonCreater");
            return (Criteria) this;
        }

        public Criteria andMarathonCreaterNotIn(List<String> values) {
            addCriterion("marathon_creater not in", values, "marathonCreater");
            return (Criteria) this;
        }

        public Criteria andMarathonCreaterBetween(String value1, String value2) {
            addCriterion("marathon_creater between", value1, value2, "marathonCreater");
            return (Criteria) this;
        }

        public Criteria andMarathonCreaterNotBetween(String value1, String value2) {
            addCriterion("marathon_creater not between", value1, value2, "marathonCreater");
            return (Criteria) this;
        }

        public Criteria andMarathonCreatetimeIsNull() {
            addCriterion("marathon_createtime is null");
            return (Criteria) this;
        }

        public Criteria andMarathonCreatetimeIsNotNull() {
            addCriterion("marathon_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andMarathonCreatetimeEqualTo(Date value) {
            addCriterion("marathon_createtime =", value, "marathonCreatetime");
            return (Criteria) this;
        }

        public Criteria andMarathonCreatetimeNotEqualTo(Date value) {
            addCriterion("marathon_createtime <>", value, "marathonCreatetime");
            return (Criteria) this;
        }

        public Criteria andMarathonCreatetimeGreaterThan(Date value) {
            addCriterion("marathon_createtime >", value, "marathonCreatetime");
            return (Criteria) this;
        }

        public Criteria andMarathonCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("marathon_createtime >=", value, "marathonCreatetime");
            return (Criteria) this;
        }

        public Criteria andMarathonCreatetimeLessThan(Date value) {
            addCriterion("marathon_createtime <", value, "marathonCreatetime");
            return (Criteria) this;
        }

        public Criteria andMarathonCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("marathon_createtime <=", value, "marathonCreatetime");
            return (Criteria) this;
        }

        public Criteria andMarathonCreatetimeIn(List<Date> values) {
            addCriterion("marathon_createtime in", values, "marathonCreatetime");
            return (Criteria) this;
        }

        public Criteria andMarathonCreatetimeNotIn(List<Date> values) {
            addCriterion("marathon_createtime not in", values, "marathonCreatetime");
            return (Criteria) this;
        }

        public Criteria andMarathonCreatetimeBetween(Date value1, Date value2) {
            addCriterion("marathon_createtime between", value1, value2, "marathonCreatetime");
            return (Criteria) this;
        }

        public Criteria andMarathonCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("marathon_createtime not between", value1, value2, "marathonCreatetime");
            return (Criteria) this;
        }

        public Criteria andMarathonUpdaterIsNull() {
            addCriterion("marathon_updater is null");
            return (Criteria) this;
        }

        public Criteria andMarathonUpdaterIsNotNull() {
            addCriterion("marathon_updater is not null");
            return (Criteria) this;
        }

        public Criteria andMarathonUpdaterEqualTo(String value) {
            addCriterion("marathon_updater =", value, "marathonUpdater");
            return (Criteria) this;
        }

        public Criteria andMarathonUpdaterNotEqualTo(String value) {
            addCriterion("marathon_updater <>", value, "marathonUpdater");
            return (Criteria) this;
        }

        public Criteria andMarathonUpdaterGreaterThan(String value) {
            addCriterion("marathon_updater >", value, "marathonUpdater");
            return (Criteria) this;
        }

        public Criteria andMarathonUpdaterGreaterThanOrEqualTo(String value) {
            addCriterion("marathon_updater >=", value, "marathonUpdater");
            return (Criteria) this;
        }

        public Criteria andMarathonUpdaterLessThan(String value) {
            addCriterion("marathon_updater <", value, "marathonUpdater");
            return (Criteria) this;
        }

        public Criteria andMarathonUpdaterLessThanOrEqualTo(String value) {
            addCriterion("marathon_updater <=", value, "marathonUpdater");
            return (Criteria) this;
        }

        public Criteria andMarathonUpdaterLike(String value) {
            addCriterion("marathon_updater like", value, "marathonUpdater");
            return (Criteria) this;
        }

        public Criteria andMarathonUpdaterNotLike(String value) {
            addCriterion("marathon_updater not like", value, "marathonUpdater");
            return (Criteria) this;
        }

        public Criteria andMarathonUpdaterIn(List<String> values) {
            addCriterion("marathon_updater in", values, "marathonUpdater");
            return (Criteria) this;
        }

        public Criteria andMarathonUpdaterNotIn(List<String> values) {
            addCriterion("marathon_updater not in", values, "marathonUpdater");
            return (Criteria) this;
        }

        public Criteria andMarathonUpdaterBetween(String value1, String value2) {
            addCriterion("marathon_updater between", value1, value2, "marathonUpdater");
            return (Criteria) this;
        }

        public Criteria andMarathonUpdaterNotBetween(String value1, String value2) {
            addCriterion("marathon_updater not between", value1, value2, "marathonUpdater");
            return (Criteria) this;
        }

        public Criteria andMarathonUpdatetimeIsNull() {
            addCriterion("marathon_updatetime is null");
            return (Criteria) this;
        }

        public Criteria andMarathonUpdatetimeIsNotNull() {
            addCriterion("marathon_updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andMarathonUpdatetimeEqualTo(Date value) {
            addCriterion("marathon_updatetime =", value, "marathonUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMarathonUpdatetimeNotEqualTo(Date value) {
            addCriterion("marathon_updatetime <>", value, "marathonUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMarathonUpdatetimeGreaterThan(Date value) {
            addCriterion("marathon_updatetime >", value, "marathonUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMarathonUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("marathon_updatetime >=", value, "marathonUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMarathonUpdatetimeLessThan(Date value) {
            addCriterion("marathon_updatetime <", value, "marathonUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMarathonUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("marathon_updatetime <=", value, "marathonUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMarathonUpdatetimeIn(List<Date> values) {
            addCriterion("marathon_updatetime in", values, "marathonUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMarathonUpdatetimeNotIn(List<Date> values) {
            addCriterion("marathon_updatetime not in", values, "marathonUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMarathonUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("marathon_updatetime between", value1, value2, "marathonUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMarathonUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("marathon_updatetime not between", value1, value2, "marathonUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMarathonDeletedIsNull() {
            addCriterion("marathon_deleted is null");
            return (Criteria) this;
        }

        public Criteria andMarathonDeletedIsNotNull() {
            addCriterion("marathon_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andMarathonDeletedEqualTo(Byte value) {
            addCriterion("marathon_deleted =", value, "marathonDeleted");
            return (Criteria) this;
        }

        public Criteria andMarathonDeletedNotEqualTo(Byte value) {
            addCriterion("marathon_deleted <>", value, "marathonDeleted");
            return (Criteria) this;
        }

        public Criteria andMarathonDeletedGreaterThan(Byte value) {
            addCriterion("marathon_deleted >", value, "marathonDeleted");
            return (Criteria) this;
        }

        public Criteria andMarathonDeletedGreaterThanOrEqualTo(Byte value) {
            addCriterion("marathon_deleted >=", value, "marathonDeleted");
            return (Criteria) this;
        }

        public Criteria andMarathonDeletedLessThan(Byte value) {
            addCriterion("marathon_deleted <", value, "marathonDeleted");
            return (Criteria) this;
        }

        public Criteria andMarathonDeletedLessThanOrEqualTo(Byte value) {
            addCriterion("marathon_deleted <=", value, "marathonDeleted");
            return (Criteria) this;
        }

        public Criteria andMarathonDeletedIn(List<Byte> values) {
            addCriterion("marathon_deleted in", values, "marathonDeleted");
            return (Criteria) this;
        }

        public Criteria andMarathonDeletedNotIn(List<Byte> values) {
            addCriterion("marathon_deleted not in", values, "marathonDeleted");
            return (Criteria) this;
        }

        public Criteria andMarathonDeletedBetween(Byte value1, Byte value2) {
            addCriterion("marathon_deleted between", value1, value2, "marathonDeleted");
            return (Criteria) this;
        }

        public Criteria andMarathonDeletedNotBetween(Byte value1, Byte value2) {
            addCriterion("marathon_deleted not between", value1, value2, "marathonDeleted");
            return (Criteria) this;
        }

        public Criteria andMarathonCommentIsNull() {
            addCriterion("marathon_comment is null");
            return (Criteria) this;
        }

        public Criteria andMarathonCommentIsNotNull() {
            addCriterion("marathon_comment is not null");
            return (Criteria) this;
        }

        public Criteria andMarathonCommentEqualTo(String value) {
            addCriterion("marathon_comment =", value, "marathonComment");
            return (Criteria) this;
        }

        public Criteria andMarathonCommentNotEqualTo(String value) {
            addCriterion("marathon_comment <>", value, "marathonComment");
            return (Criteria) this;
        }

        public Criteria andMarathonCommentGreaterThan(String value) {
            addCriterion("marathon_comment >", value, "marathonComment");
            return (Criteria) this;
        }

        public Criteria andMarathonCommentGreaterThanOrEqualTo(String value) {
            addCriterion("marathon_comment >=", value, "marathonComment");
            return (Criteria) this;
        }

        public Criteria andMarathonCommentLessThan(String value) {
            addCriterion("marathon_comment <", value, "marathonComment");
            return (Criteria) this;
        }

        public Criteria andMarathonCommentLessThanOrEqualTo(String value) {
            addCriterion("marathon_comment <=", value, "marathonComment");
            return (Criteria) this;
        }

        public Criteria andMarathonCommentLike(String value) {
            addCriterion("marathon_comment like", value, "marathonComment");
            return (Criteria) this;
        }

        public Criteria andMarathonCommentNotLike(String value) {
            addCriterion("marathon_comment not like", value, "marathonComment");
            return (Criteria) this;
        }

        public Criteria andMarathonCommentIn(List<String> values) {
            addCriterion("marathon_comment in", values, "marathonComment");
            return (Criteria) this;
        }

        public Criteria andMarathonCommentNotIn(List<String> values) {
            addCriterion("marathon_comment not in", values, "marathonComment");
            return (Criteria) this;
        }

        public Criteria andMarathonCommentBetween(String value1, String value2) {
            addCriterion("marathon_comment between", value1, value2, "marathonComment");
            return (Criteria) this;
        }

        public Criteria andMarathonCommentNotBetween(String value1, String value2) {
            addCriterion("marathon_comment not between", value1, value2, "marathonComment");
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
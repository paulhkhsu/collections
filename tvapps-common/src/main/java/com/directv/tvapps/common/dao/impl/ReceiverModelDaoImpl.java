package com.directv.tvapps.common.dao.impl;

/*
 * @author Paul Hsu
 */

import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;
import com.directv.tvapps.common.dao.ReceiverModelDao;

import com.directv.tvapps.common.pojo.ReceiverModel;

@Repository("receiverModelDao")
public class ReceiverModelDaoImpl extends DaoBaseImpl<Long, ReceiverModel>
		implements ReceiverModelDao {
	public ReceiverModelDaoImpl() {
	}

	@SuppressWarnings("unchecked")
	public List<ReceiverModel> getSupportedReceivers() {
		Criteria c = this.getSession().createCriteria(
				ReceiverModel.class);
		return c.list();
	}
}
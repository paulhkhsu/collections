package com.directv.tvapps.common.dao.impl;

import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.directv.tvapps.common.dao.ProblemDao;
import com.directv.tvapps.common.dao.ReceiverDao;
import com.directv.tvapps.common.dao.ReceiverModelDao;
import com.directv.tvapps.common.enums.WidgetStatus;

import com.directv.tvapps.common.pojo.Problem;
import com.directv.tvapps.common.pojo.Receiver;
import com.directv.tvapps.common.pojo.ReceiverModel;
import com.directv.tvapps.common.pojo.WidgetRating;

@Repository("receiverDao")
public class ReceiverDaoImpl extends DaoBaseImpl<Long, Receiver> implements
		ReceiverDao {
	public ReceiverDaoImpl() {
	}

	@Autowired
	public ReceiverDaoImpl(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	public Receiver getReceiver(final String receiverId, final String cardId) {
		return getReceiver(receiverId, cardId);
	}

	public Receiver getReceiver(final String receiverId, final String cardId,
			final long accountId) {
		Criteria c = this.getSession().createCriteria(Receiver.class)
				.add(Restrictions.eq("receiverId", receiverId))
				.add(Restrictions.eq("accessCardNumber", cardId));

		if (accountId > 0) {
			c.createAlias("userAccount", "userAccount").add(
					Restrictions.eq("userAccount.accountId", accountId));
		}
		return (Receiver) c.uniqueResult();
	}
}
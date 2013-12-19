package com.directv.tvapps.common.dao.impl;
/*
 * @author Paul Hsu
 */

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.directv.tvapps.common.dao.UserAccountDao;
import com.directv.tvapps.common.pojo.UserAccount;

@Repository("userAccountDao")
public class UserAccountDaoImpl extends DaoBaseImpl<Long, UserAccount>
		implements UserAccountDao {

	public UserAccountDaoImpl() {
	}

	@SuppressWarnings("unchecked")
	public List<UserAccount> getUsers() {
		return this.getSession().createSQLQuery(
				"from User u fetch all properties order by u.id").list();
	}

	public UserAccount getUserByEmail(String email) {
		return null;
	}

	public UserAccount getUserByReceiverId(final String receiverId) {
		return null;
	}

	public UserAccount getUser(long accountId) {
		// TODO Auto-generated method stub
		return null;
	}
}

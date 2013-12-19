package com.directv.tvapps.common.dao;
/*
 * @author Paul Hsu
 */

import java.math.BigDecimal;
import java.util.List;

import com.directv.tvapps.common.pojo.UserAccount;

public interface UserAccountDao extends DaoBase<Long, UserAccount> {
	List<UserAccount> getUsers();

	UserAccount getUser(long accountId);

	UserAccount getUserByEmail(String email);

	UserAccount getUserByReceiverId(String receiverId);
}

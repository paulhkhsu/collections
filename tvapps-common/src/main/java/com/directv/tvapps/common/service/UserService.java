package com.directv.tvapps.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.directv.tvapps.common.dao.UserAccountDao;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserService {
	
	@Autowired
    private UserAccountDao userAccountDao;

	public boolean getUserAgreement(long acctId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean getUserAgreement(String rid, String cardId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean acceptUserAgreement(long acctId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean acceptUserAgreement(String rid, String cardId) {
		// TODO Auto-generated method stub
		return false;
	}

}

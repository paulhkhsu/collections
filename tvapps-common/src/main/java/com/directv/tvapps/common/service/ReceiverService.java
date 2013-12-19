package com.directv.tvapps.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.directv.tvapps.common.dao.CategoryDao;
import com.directv.tvapps.common.dao.ReceiverDao;
import com.directv.tvapps.common.pojo.Receiver;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class ReceiverService {
	
	@Autowired
    private ReceiverDao receiverDao;
	public Receiver getReceiver(final String receiverId, final String cardId)
	{
		return getReceiver(receiverId, cardId, 0);
	}
	public Receiver getReceiver(final String receiverId, final String cardId, final long accountId){
		return receiverDao.getReceiver(receiverId, cardId, accountId);
	}

}

package com.directv.tvapps.common.dao;
/*
 * @author Paul Hsu
 */

import java.math.BigDecimal;
import java.util.List;

import com.directv.tvapps.common.pojo.Receiver;
import com.directv.tvapps.common.pojo.ReceiverModel;

public interface ReceiverDao extends DaoBase<Long, Receiver> {
	public Receiver getReceiver(final String receiverId, final String cardId);
	public Receiver getReceiver(final String receiverId, final String cardId, final long accountId);

}

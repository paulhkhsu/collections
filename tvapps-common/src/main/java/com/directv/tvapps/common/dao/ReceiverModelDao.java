package com.directv.tvapps.common.dao;
/*
 * @author Paul Hsu
 */

import java.math.BigDecimal;
import java.util.List;

import com.directv.tvapps.common.pojo.ReceiverModel;

public interface ReceiverModelDao extends DaoBase<Long, ReceiverModel> {
	public List<ReceiverModel> getSupportedReceivers();
}

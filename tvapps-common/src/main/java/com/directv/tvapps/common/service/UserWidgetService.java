package com.directv.tvapps.common.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.directv.tvapps.common.dao.UserWidgetDao;
import com.directv.tvapps.common.pojo.Receiver;
import com.directv.tvapps.common.pojo.RefreshRate;
import com.directv.tvapps.common.pojo.UserWidget;
import com.directv.tvapps.common.pojo.Widget;
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserWidgetService {
	
	@Autowired
	private UserWidgetDao userWidgetDao;
	
	public List<UserWidget> getUserWidgets(long acctId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<UserWidget> getUserWidgets(String rid, String cardid) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean removeUserWidget(long userWidgetId, long acctId) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean removeUserWidget(long userWidgetId, String rid, String cardid) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean duplicateUserWidget(long userWidgetId, long acctId) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean duplicateUserWidget(long userWidgetId, String rid,
			String cardid) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean setUserWidgetOptions(long userWidgetId, String options) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean reorderUserWidget(long userWidgetId, long acctId,
			int newPosition) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean reorderUserWidget(long userWidgetId, String rid,
			String cardid, int newPosition) {
		// TODO Auto-generated method stub
		return false;
	}

	public UserWidget createUserWidget(Widget widget, Receiver receiver) {
		UserWidget userWidget = new UserWidget();
		userWidget.setDisplayName(widget.getName());
		userWidget.setActive(true);
		userWidget.setSeqNumber(1);
		userWidget.setReceiver(receiver);
		userWidget.setWidget(widget);
		userWidget.setDockIconUrl("");
		userWidget.setUserOption("");
		
		Set<RefreshRate> refreshRates = widget.getRefreshRates();
		for (RefreshRate rate : refreshRates) {
			if (rate.isDefaultValue())
				userWidget.setRefreshRate(rate.getRefreshRate());
		}

		userWidget.setCreated(new Date());
		return userWidget;
	}
	public UserWidget saveUserWidget(UserWidget userWidget) {
		userWidgetDao.save(userWidget);
		return userWidget;
	}

}

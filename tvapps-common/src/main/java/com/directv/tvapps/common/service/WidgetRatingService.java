package com.directv.tvapps.common.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.directv.tvapps.common.dao.WidgetRatingDao;
import com.directv.tvapps.common.pojo.WidgetRating;

@Service("widgetRatingService")
@Transactional(rollbackFor = RuntimeException.class)
public class WidgetRatingService {
	@Autowired
	private WidgetRatingDao widgetRatingDao;

	public WidgetRating getWidgetRating(final long userAccountId,
			final long widgetId) {

		return widgetRatingDao.getWidgetRating(userAccountId, widgetId);
	}

	public void saveUpdateWidgetRating(WidgetRating wr){

		widgetRatingDao.saveOrUpdate(wr);
		
		//throw new RuntimeException("ttt");
	}

	public void saveWidgetRating(WidgetRating wr) {

		widgetRatingDao.save(wr);
	}

}

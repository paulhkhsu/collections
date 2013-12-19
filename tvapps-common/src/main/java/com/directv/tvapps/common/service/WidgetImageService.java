package com.directv.tvapps.common.service;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.directv.tvapps.common.dao.WidgetImageDao;
import com.directv.tvapps.common.pojo.WidgetImage;

@Service("widgetImageService")
@Transactional(rollbackFor = RuntimeException.class)
public class WidgetImageService {
	private static Log log = LogFactory.getLog(WidgetImageService.class);
	@Autowired
	private WidgetImageDao widgetImageDao;

	public List<WidgetImage> getWidgetImages(long widgetId) {
	
		List<WidgetImage> result = widgetImageDao.getWidgetImages(widgetId);
		return result;
	}

}

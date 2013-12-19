package com.directv.tvapps.ws.mvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.stat.CollectionStatistics;
import org.hibernate.stat.EntityStatistics;
import org.hibernate.stat.QueryStatistics;
import org.hibernate.stat.SecondLevelCacheStatistics;
import org.hibernate.stat.Statistics;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.directv.tvapps.common.service.CacheUtil;


@Controller
@RequestMapping(value="/stat")
public class StatisticsController {
	private static final Log log = LogFactory.getLog(StatisticsController.class);

    @Autowired
	CacheUtil cacheUtil;
    
    //http://localhost:8080/tvapps-ws/util/stat/display
	@RequestMapping(value="display", method=RequestMethod.GET)
	public String dumpCache(Model model) {
		Statistics cf = cacheUtil.getCacheInfo();
		List<SecondLevelCacheStatistics> second = cacheUtil.getSecondLevelInfo();
		List<QueryStatistics> query = cacheUtil.getQueryInfo();
		List<CollectionStatistics> collect = cacheUtil.getCollectionInfo();
		List<EntityStatistics> entity = cacheUtil.getEntityInfo();
		model.addAttribute("cacheform", cf);
		model.addAttribute("second", second);
		model.addAttribute("query", query);
		model.addAttribute("collect", collect);
		model.addAttribute("entity", entity);
		
		Date start  = new Date();
		start.setTime(cf.getStartTime());
		model.addAttribute("start", start.toString());
	
		return "dumpcache";
	}
	@RequestMapping(value="clear", method=RequestMethod.GET)
	public String clearStat(Model model) {
		cacheUtil.clearStatistics();
		model.addAttribute("title", "Clear Statistics");
		return "stat";
	}
	@RequestMapping(value="disable", method=RequestMethod.GET)
	public String disableStat(Model model) {
		cacheUtil.disableStatistics();
		model.addAttribute("title", "Disable Statistics");
		return "stat";
	}
	@RequestMapping(value="enable", method=RequestMethod.GET)
	public String enableStat(Model model) {
		cacheUtil.enableStatistics();
		model.addAttribute("title", "Enable Statistics");
		return "stat";
	}

}

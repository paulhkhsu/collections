package com.directv.tvapps.common.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.stat.CollectionStatistics;
import org.hibernate.stat.EntityStatistics;
import org.hibernate.stat.QueryStatistics;
import org.hibernate.stat.SecondLevelCacheStatistics;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

@Service("cacheUtil")
public class CacheUtil {
	private static final Log log = LogFactory.getLog(CacheUtil.class);

	@Autowired
	private SessionFactory sessionFactory;

	public Statistics getCacheInfo() {
		Statistics stats = sessionFactory.getStatistics();
		return stats;
	}

	public List<EntityStatistics> getEntityInfo() {
		List<EntityStatistics> l = new ArrayList<EntityStatistics>();
		Statistics stats = sessionFactory.getStatistics();
		String s[] = stats.getEntityNames();
		for (String ss : s) {
			EntityStatistics s1 = stats.getEntityStatistics(ss);
			l.add(s1);
		}

		return l;
	}

	public List<SecondLevelCacheStatistics> getSecondLevelInfo() {
		List<SecondLevelCacheStatistics> l = new ArrayList<SecondLevelCacheStatistics>();
		Statistics stats = sessionFactory.getStatistics();
		String s[] = stats.getSecondLevelCacheRegionNames();
		for (String ss : s) {
			SecondLevelCacheStatistics s1 = stats
					.getSecondLevelCacheStatistics(ss);
			l.add(s1);
		}

		return l;
	}

	public List<QueryStatistics> getQueryInfo() {
		List<QueryStatistics> l = new ArrayList<QueryStatistics>();
		Statistics stats = sessionFactory.getStatistics();
		String s[] = stats.getQueries();
		for (String ss : s) {
			QueryStatistics s1 = stats.getQueryStatistics(ss);
			l.add(s1);
		}

		return l;
	}

	public List<CollectionStatistics> getCollectionInfo() {
		List<CollectionStatistics> l = new ArrayList<CollectionStatistics>();
		Statistics stats = sessionFactory.getStatistics();
		String s[] = stats.getCollectionRoleNames();
		for (String ss : s) {
			CollectionStatistics s1 = stats.getCollectionStatistics(ss);
			l.add(s1);
		}

		return l;
	}

	public void clearStatistics()
	{
		sessionFactory.getStatistics().clear();
	}
	
	public void enableStatistics()
	{
		sessionFactory.getStatistics().setStatisticsEnabled(true);
	}
 
	public void disableStatistics()
	{
		sessionFactory.getStatistics().setStatisticsEnabled(false);
	}

}

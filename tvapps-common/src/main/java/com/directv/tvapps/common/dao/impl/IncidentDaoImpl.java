package com.directv.tvapps.common.dao.impl;
/*
 * @author Paul Hsu
 */

import java.math.BigDecimal;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.directv.tvapps.common.dao.IncidentDao;
import com.directv.tvapps.common.pojo.Incident;

@Repository("incidentDao")
public class IncidentDaoImpl extends DaoBaseImpl<Long, Incident>
		implements IncidentDao {
	public IncidentDaoImpl() {
	}

}
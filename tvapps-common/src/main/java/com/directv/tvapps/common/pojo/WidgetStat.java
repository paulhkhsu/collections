package com.directv.tvapps.common.pojo;
/*
 * @author Paul Hsu
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.directv.tvapps.common.base.BeanBase;

@Entity
@Table(name="WIDGET_STAT")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class WidgetStat extends BeanBase {
	private Long widgetId;
	private Long setupCount;
	private Long avgRating;
	
    @Id 
    @Column(name = "widget_id")
	public Long getWidgetId() {
		return widgetId;
	}
	public void setWidgetId(Long widgetId) {
		this.widgetId = widgetId;
	}
	@Column(name = "setup_count")
	public Long getSetupCount() {
		return setupCount;
	}
	public void setSetupCount(Long setupCount) {
		this.setupCount = setupCount;
	}
	@Column(name = "avg_rating")
	public Long getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(Long avgRating) {
		this.avgRating = avgRating;
	}

}

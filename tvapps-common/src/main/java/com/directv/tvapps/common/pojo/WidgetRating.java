package com.directv.tvapps.common.pojo;
/*
 * @author Paul Hsu
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="widget_rating")
@SequenceGenerator(name="widget_rating_sequence", sequenceName="widget_rating_SEQ", allocationSize=1)
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class WidgetRating extends EntityBase {
    private Long id;
    private Long userAccountId;
    private Long widgetId;
    private Integer rating;
    
    @Id @GeneratedValue (strategy=GenerationType.SEQUENCE, generator="widget_rating_sequence")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "user_account_id")
	public Long getUserAccountId() {
		return userAccountId;
	}
	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}
	@Column(name = "widget_id")
	public Long getWidgetId() {
		return widgetId;
	}
	public void setWidgetId(Long widgetId) {
		this.widgetId = widgetId;
	}
	@Column(name = "rating")
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	
}

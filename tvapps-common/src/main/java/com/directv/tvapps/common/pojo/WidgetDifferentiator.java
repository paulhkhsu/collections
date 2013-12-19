package com.directv.tvapps.common.pojo;
/*
 * @author Paul Hsu
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.directv.tvapps.common.base.BeanBase;

@Entity
@Table(name = "WIDGET_DIFFERENTIATOR")
@SequenceGenerator(name = "widget_differentiator_sequence", sequenceName = "WIDGET_DIFFERENTIATOR_SEQ", allocationSize = 1)
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class WidgetDifferentiator extends BeanBase {
	private Long id;
	private String differentiator;
	private Short seqNumber;
	private String splashUrl;
	private Widget widget;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "widget_differentiator_sequence")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "differentiator", nullable = false)
	public String getDifferentiator() {
		return differentiator;
	}
	public void setDifferentiator(String differentiator) {
		this.differentiator = differentiator;
	}
	@Column(name = "seq_number", nullable = false)
	public Short getSeqNumber() {
		return seqNumber;
	}
	public void setSeqNumber(Short seqNumber) {
		this.seqNumber = seqNumber;
	}
	@Column(name = "splash_url", nullable = true)
	public String getSplashUrl() {
		return splashUrl;
	}
	public void setSplashUrl(String splashUrl) {
		this.splashUrl = splashUrl;
	}

	@ManyToOne(targetEntity = Widget.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "WIDGET_ID")
	public Widget getWidget() {
		return widget;
	}
	public void setWidget(Widget widget) {
		this.widget = widget;
		this.widget.setWidgetDifferentiator(this);
	}

}

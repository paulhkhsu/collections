package com.directv.tvapps.common.pojo;
/*
 * @author Paul Hsu
 */

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="INCIDENT")
@SequenceGenerator(name="incident_sequence", sequenceName="INCIDENT_SEQ", allocationSize=1)
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Incident extends EntityBase {
    private Long id;
    private Widget widget;
    private UserWidget userWidget;
    private Problem problem;
    private String additionalInfo;
    
    @Id @GeneratedValue (strategy=GenerationType.SEQUENCE, generator="incident_sequence")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity=Widget.class)
    @JoinColumn(name="WIDGET_ID")
	public Widget getWidget() {
		return widget;
	}
	public void setWidget(Widget widget) {
		this.widget = widget;
	}
	
	@ManyToOne(targetEntity=UserWidget.class)
    @JoinColumn(name="USER_WIDGET_ID")
	public UserWidget getUserWidget() {
		return userWidget;
	}
	public void setUserWidget(UserWidget userWidget) {
		this.userWidget = userWidget;
	}
	
	@ManyToOne(targetEntity=Problem.class)
    @JoinColumn(name="PROBLEM_ID")
	public Problem getProblem() {
		return problem;
	}
	public void setProblem(Problem problem) {
		this.problem = problem;
	}
	
	@Column(name = "ADDITIONAL_INFO")
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	
}

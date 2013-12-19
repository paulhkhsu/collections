package com.directv.tvapps.common.pojo;
/*
 * @author Paul Hsu
 */
import java.util.Comparator;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name="USER_WIDGET")
@SequenceGenerator(name="user_widget_sequence", sequenceName="USER_WIDGET_SEQ", allocationSize=1)
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class UserWidget extends EntityBase{
	
	private Long id;
	private Widget widget;
	private Receiver receiver;
	private Integer seqNumber;
	private Boolean active;
	private String displayName;
	private Integer refreshRate;
	private String dockIconUrl;
	private String userOption;
	private Date created;
	
	public UserWidget(){
	}
	
	@Id @GeneratedValue (strategy=GenerationType.SEQUENCE, generator="user_widget_sequence")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="SEQ_NUMBER", nullable=false)
	public Integer getSeqNumber() {
        return seqNumber;
    }
    public void setSeqNumber(Integer seqNumber) {
        this.seqNumber = seqNumber;
    }
    
    @ManyToOne(targetEntity=Widget.class)
    @JoinColumn(name="widget_id")
    //@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region="com.directv.daw.widgets.domain.widget.Widget")
	public Widget getWidget() {
		return widget;
	}
	public void setWidget(Widget widget) {
		this.widget = widget;
	}
	
    @ManyToOne(targetEntity=Receiver.class)
    @JoinColumn(name="RECEIVER_ID")
	public Receiver getReceiver() {
		return receiver;
	}
	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}
	
	@Column(name = "DISPLAY_NAME", nullable = false)
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	@Column(name = "REFRESH_RATE", nullable = false)
	public Integer getRefreshRate() {
		return refreshRate;
	}
	public void setRefreshRate(Integer refreshRate) {
		this.refreshRate = refreshRate;
	}
	
	@Column(name = "CREATED", nullable = false)
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	@Column(name = "dockicon_url", nullable = true)
	public String getDockIconUrl() {
		return dockIconUrl;
	}

	public void setDockIconUrl(String dockIconUrl) {
		this.dockIconUrl = dockIconUrl;
	}

	@Column(name = "user_option", nullable = false)
	public String getUserOption() {
		return userOption;
	}

	public void setUserOption(String userOption) {
		this.userOption = userOption;
	}

	@Column(name = "ACTIVE", nullable = false)
    public Boolean isActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
	
}

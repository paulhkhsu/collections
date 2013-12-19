package com.directv.tvapps.common.pojo;
/*
 * @author Paul Hsu
 */
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
@Entity
@Table(name="RECEIVER")
@SequenceGenerator(name = "receiver_sequence", sequenceName = "RECEIVER_SEQ", allocationSize = 1)

@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Receiver extends EntityBase{
	
	private Long id;
	private String receiverId;
	private String model;
	private String serialNumber;	
	private String location;
	private String accessCardNumber;
	private boolean added;
	private boolean deleted;	
	private Date dateAdded;
	private Date dateDeleted;
	private Date justAddClick;
	private Date dockModify;
	List<UserWidget> userWidgets;
	private UserAccount userAccount;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "receiver_sequence")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    @Column(name = "rid", nullable = false)	
	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	
	@Column(name = "MODEL", nullable = false)
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	@Column(name = "SERIAL_NUMBER")
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Column(name = "LOCATION")
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Column(name = "ACCESS_CARD_NUMBER")
	public String getAccessCardNumber() {
		return accessCardNumber;
	}
	public void setAccessCardNumber(String accessCardNumber) {
		this.accessCardNumber = accessCardNumber;
	}
	
	@Column(name = "ADDED")
	public boolean isAdded() {
		return added;
	}
	public void setAdded(boolean added) {
		this.added = added;
	}
	
    @Column(name = "JUSTADD_CLICKED")
	public Date getJustAddClick() {
		return justAddClick;
	}
	public void setJustAddClick(Date justAddClick) {
		this.justAddClick = justAddClick;
	}

    @Column(name = "DOCK_MODIFIED")
	public Date getDockModify() {
		return dockModify;
	}
	public void setDockModify(Date dockModify) {
		this.dockModify = dockModify;
	}

	@Column(name = "DELETED")
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
		
//	public boolean equals(Object receiver){
//		if(receiver==null || !(receiver instanceof Receiver))
//			return false;
//		Receiver rec = (Receiver)receiver;
//		if(rec.getUserAccount() == null || userAccount == null)
//			return false;
//		boolean b = this.receiverId.equals(rec.receiverId) &&
//		this.accessCardNumber.equals(rec.accessCardNumber) &&
//		this.userAccount.getAccountId() == rec.getUserAccount().getAccountId();
//		return b;
//	}

	@Column(name = "DATE_ADDED")
    public Date getDateAdded() {
        return dateAdded;
    }
    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
	
    @Column(name = "DATE_DELETED")
	public Date getDateDeleted() {
        return dateDeleted;
    }
    public void setDateDeleted(Date dateDeleted) {
        this.dateDeleted = dateDeleted;
    }
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name="RECEIVER_ID")
    public List<UserWidget> getUserWidgets() {
        return userWidgets;
    }
    
    public void setUserWidgets(List<UserWidget> userWidgets) {
        this.userWidgets = userWidgets;
    }    
    public void addUserWidget(UserWidget userWidget) {
        if(null == this.userWidgets)
        	this.userWidgets = new ArrayList<UserWidget>();
        this.userWidgets.add(userWidget);
    }    
  
    @ManyToOne(targetEntity=UserAccount.class)
    @JoinColumn(name="USER_ACCOUNT_ID")
    public UserAccount getUserAccount() {
        return userAccount;
    }
    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
    
} 
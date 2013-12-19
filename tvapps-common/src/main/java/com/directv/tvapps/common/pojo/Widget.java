package com.directv.tvapps.common.pojo;

/*
 * @author Paul Hsu
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;

import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.FullTextFilterDef;
import org.hibernate.search.annotations.FullTextFilterDefs;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Table(name = "WIDGET")
@SequenceGenerator(name = "widget_sequence", sequenceName = "WIDGET_SEQ", allocationSize = 1)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Widget extends EntityBase {

	private Long id;
	private String creatorName;
	private String name;
	private String description;
	private boolean active;
	private short approved;
	private String classificationCode;
	private String typeCode;
	private boolean customerInfo;
	private long maxSubscriptions;
	private String additionalMetadata;
	private boolean defaultWidget;
	private String manifestUrl;
	private String secondaryUrl;
	private String defaultDockiconUrl;
	private long dockRefreshRate;
	private Date created = new Date();

	private List<WidgetImage> images = new ArrayList<WidgetImage>();
	private UserAccount userAccount;
	private Set<Category> categories = new HashSet<Category>();
	private Set<RefreshRate> refreshRates = new HashSet<RefreshRate>();
	private WidgetStat widgetStat;
    private WidgetDifferentiator widgetDifferentiator;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "widget_sequence")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "NAME", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "CREATOR_NAME", nullable = false)
	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	@Column(name = "DESCRIPTION", nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "CREATED", nullable = false)
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Column(name = "ACTIVE", nullable = false)
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Column(name = "ADDITIONAL_METADATA", nullable = true)
	public String getAdditionalMetadata() {
		return additionalMetadata;
	}

	public void setAdditionalMetadata(String additionalMetadata) {
		this.additionalMetadata = additionalMetadata;
	}

	@Column(name = "CLASSIFICATION_CODE", nullable = false)
	public String getClassificationCode() {
		return classificationCode;
	}

	public void setClassificationCode(String classificationCode) {
		this.classificationCode = classificationCode;
	}

	@Column(name = "TYPE_CODE", nullable = false)
	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	@Column(name = "CUSTOMER_INFO", nullable = false)
	public boolean getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(boolean customerInfo) {
		this.customerInfo = customerInfo;
	}

	@Column(name = "DEFAULT_WIDGET", nullable = false)
	public boolean isDefaultWidget() {
		return defaultWidget;
	}

	public void setDefaultWidget(boolean defaultWidget) {
		this.defaultWidget = defaultWidget;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	@JoinColumn(name = "WIDGET_ID")
	public List<WidgetImage> getImages() {
		return images;
	}

	public void setImages(List<WidgetImage> images) {
		this.images = images;
	}

	public void addImage(WidgetImage image) {

		if (this.images == null) {
			this.images = new ArrayList<WidgetImage>();
		}
		this.images.add(image);
	}

	@ManyToOne(targetEntity = UserAccount.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "User_ACCOUNT_ID")
	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	@Column(name = "APPROVED", nullable = false)
	public short getApproved() {
		return approved;
	}

	public void setApproved(short approved) {
		this.approved = approved;
	}

	@Column(name = "MAX_SUBSCRIPTIONS")
	public long getMaxSubscriptions() {
		return maxSubscriptions;
	}

	public void setMaxSubscriptions(long maxSubscriptions) {
		this.maxSubscriptions = maxSubscriptions;
	}

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, targetEntity = Category.class, fetch = FetchType.LAZY)
	@JoinTable(name = "CATEGORY_WIDGET", joinColumns = @JoinColumn(name = "WIDGET_ID"), inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))
	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public void addCategory(Category category) {

		if (this.categories == null) {
			this.categories = new HashSet<Category>();
		}
		this.categories.add(category);
	}

	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@Cascade (org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	@JoinColumn(name="WIDGET_ID")
	@OrderBy("refreshRate")
//	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public Set<RefreshRate> getRefreshRates() {
		return refreshRates;
	}

	public void setRefreshRates(Set<RefreshRate> refreshRates) {
		this.refreshRates = refreshRates;
	}

	public void addRefreshRate(RefreshRate refreshRate) {

		if (this.refreshRates == null) {
			this.refreshRates = new HashSet<RefreshRate>();
		}
		this.refreshRates.add(refreshRate);
	}

	@Column(name = "manifest_url")
	public String getManifestUrl() {
		return manifestUrl;
	}

	public void setManifestUrl(String manifestUrl) {
		this.manifestUrl = manifestUrl;
	}

	@Column(name = "secondary_url")
	public String getSecondaryUrl() {
		return secondaryUrl;
	}

	public void setSecondaryUrl(String secondaryUrl) {
		this.secondaryUrl = secondaryUrl;
	}

	@Column(name = "default_dockicon_url")
	public String getDefaultDockiconUrl() {
		return defaultDockiconUrl;
	}

	public void setDefaultDockiconUrl(String defaultDockiconUrl) {
		this.defaultDockiconUrl = defaultDockiconUrl;
	}

	@Column(name = "DOCK_REFRESH_RATE")
	public long getDockRefreshRate() {
		return dockRefreshRate;
	}

	public void setDockRefreshRate(long dockRefreshRate) {
		this.dockRefreshRate = dockRefreshRate;
	}

	@OneToOne(optional = false,fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "widget_id")
	public WidgetStat getWidgetStat() {
		return widgetStat;
	}

	public void setWidgetStat(WidgetStat widgetStat) {
		this.widgetStat = widgetStat;
	}
    @Transient	
	public WidgetDifferentiator getWidgetDifferentiator() {
		return widgetDifferentiator;
	}

	public void setWidgetDifferentiator(WidgetDifferentiator widgetDifferentiator) {
		this.widgetDifferentiator = widgetDifferentiator;
	}

}
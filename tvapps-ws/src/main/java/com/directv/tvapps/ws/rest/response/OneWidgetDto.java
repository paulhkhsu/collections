package com.directv.tvapps.ws.rest.response;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "widget")
@XmlAccessorType(XmlAccessType.NONE)

public class OneWidgetDto {
	@XmlElement
	private String link;
	@XmlElement
	private Long id;
	@XmlElement
	private String creatorName;
	@XmlElement
	private String name;
	@XmlElement
	private String description;
	@XmlElement
	private boolean active;
	@XmlElement
	private short approved;
	@XmlElement
	private String classificationCode;
	@XmlElement
	private String typeCode;
	@XmlElement
	private boolean customerInfo;
	@XmlElement
	private long maxSubscriptions;
	@XmlElement
	private String additionalMetadata;
	@XmlElement
	private boolean defaultWidget;
	@XmlElement
	private String manifestUrl;
	@XmlElement
	private String secondaryUrl;
	@XmlElement
	private String defaultDockiconUrl;
	@XmlElement
	private long dockRefreshRate;
	@XmlElement
	private Date created = new Date();
	@XmlElementWrapper(name="categories")
	@XmlElement(name = "category")
	Set <OneCategoryDto> categories = new HashSet<OneCategoryDto>();
	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public short getApproved() {
		return approved;
	}

	public void setApproved(short approved) {
		this.approved = approved;
	}

	public String getClassificationCode() {
		return classificationCode;
	}

	public void setClassificationCode(String classificationCode) {
		this.classificationCode = classificationCode;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public boolean isCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(boolean customerInfo) {
		this.customerInfo = customerInfo;
	}

	public long getMaxSubscriptions() {
		return maxSubscriptions;
	}

	public void setMaxSubscriptions(long maxSubscriptions) {
		this.maxSubscriptions = maxSubscriptions;
	}

	public String getAdditionalMetadata() {
		return additionalMetadata;
	}

	public void setAdditionalMetadata(String additionalMetadata) {
		this.additionalMetadata = additionalMetadata;
	}

	public boolean isDefaultWidget() {
		return defaultWidget;
	}

	public void setDefaultWidget(boolean defaultWidget) {
		this.defaultWidget = defaultWidget;
	}

	public String getManifestUrl() {
		return manifestUrl;
	}

	public void setManifestUrl(String manifestUrl) {
		this.manifestUrl = manifestUrl;
	}

	public String getSecondaryUrl() {
		return secondaryUrl;
	}

	public void setSecondaryUrl(String secondaryUrl) {
		this.secondaryUrl = secondaryUrl;
	}

	public String getDefaultDockiconUrl() {
		return defaultDockiconUrl;
	}

	public void setDefaultDockiconUrl(String defaultDockiconUrl) {
		this.defaultDockiconUrl = defaultDockiconUrl;
	}

	public long getDockRefreshRate() {
		return dockRefreshRate;
	}

	public void setDockRefreshRate(long dockRefreshRate) {
		this.dockRefreshRate = dockRefreshRate;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Set<OneCategoryDto> getCategories() {
		return categories;
	}

	public void setCategories(Set<OneCategoryDto> categories) {
		this.categories = categories;
	}
	public void addOneCategoryDto(OneCategoryDto wdt)
	{
		categories.add(wdt);
	}

}

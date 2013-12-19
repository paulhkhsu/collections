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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="WIDGET_IMAGE")
@SequenceGenerator(name="widget_image_sequence", sequenceName="WIDGET_IMAGE_SEQ", allocationSize=1)
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class WidgetImage extends EntityBase{
    public static String STB_WIDGET_DOCK_ICON = "STB_WIDGET_DOCK_ICON";
    public static String STB_WIDGET_PREF_ICON = "STB_WIDGET_PREF_ICON";
    public static String STB_WIDGET_PREVIEW = "STB_WIDGET_PREVIEW";
    public static String WEB_WIDGET_PREVIEW = "WEB_WIDGET_PREVIEW";
    public static String WEB_WIDGET_FEATURED = "WEB_WIDGET_FEATURED";
    public static String WEB_WIDGET_CATALOG_ICON = "WEB_WIDGET_CATALOG_ICON";
    public static String STB_WIDGET_IMAGE = "STB_WIDGET_IMAGE"; 
    public static String WEB_WIDGET_IMAGE = "WEB_WIDGET_IMAGE"; 

    private Long id;
    private UsageType usageType;
	private int seqNumber;
    private String format;
    private String fileName;
    private String url;
    private int width;
    private int height;
    private Long widgetId;

	@Id @GeneratedValue  (strategy=GenerationType.SEQUENCE, generator="widget_image_sequence")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

	@Column(name = "seq_number", nullable = false)
	public int getSeqNumber() {
		return seqNumber;
	}
	public void setSeqNumber(int seqNumber) {
		this.seqNumber = seqNumber;
	}

    @Column(name = "FILE_NAME", nullable = false)
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    @Column(name = "FORMAT", nullable = false)
    public String getFormat() {
        return format;
    }
    public void setFormat(String format) {
        this.format = format;
    }
    
    @Column(name = "URL", nullable = false)
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "WIDTH", nullable = true)
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    
    @Column(name = "HEIGHT", nullable = true)
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    
    @Column(name = "widget_id", nullable = false)
	public Long getWidgetId() {
		return widgetId;
	}
	public void setWidgetId(Long widgetId) {
		this.widgetId = widgetId;
	}
	@ManyToOne(targetEntity = UsageType.class, fetch = FetchType.EAGER)
    @JoinColumn (name= "usage_type_id")    
    public UsageType getUsageType() {
		return usageType;
	}
	public void setUsageType(UsageType usageType) {
		this.usageType = usageType;
	}

    
}

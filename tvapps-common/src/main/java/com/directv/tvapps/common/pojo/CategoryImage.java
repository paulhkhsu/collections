package com.directv.tvapps.common.pojo;
/*
 * @author Paul Hsu
 */

import java.math.BigDecimal;

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
@Table(name="CATEGORY_IMAGE")
@SequenceGenerator(name="category_image_sequence", sequenceName="CATEGORY_IMAGE_SEQ", allocationSize=1)
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CategoryImage extends EntityBase {
    
    private Long id;
	private int seqNumber;
    private String format;
    private String fileName;
    private String url;
    private int width;
    private int height;
    private UsageType usageType;
    private Long categoryId;
    
    
    @Id @GeneratedValue  (strategy=GenerationType.SEQUENCE, generator="category_image_sequence")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
 
	@ManyToOne(targetEntity = UsageType.class, fetch = FetchType.EAGER)
    @JoinColumn (name= "usage_type_id")    
    public UsageType getUsageType() {
		return usageType;
	}
	
    public void setUsageType(UsageType usageType) {
		this.usageType = usageType;
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

    @Column(name = "category_id", nullable = false)
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
}

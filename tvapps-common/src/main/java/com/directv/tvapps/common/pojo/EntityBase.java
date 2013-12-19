package com.directv.tvapps.common.pojo;
/*
 * @author Paul Hsu
 */

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.directv.tvapps.common.base.BeanBase;
@MappedSuperclass
public class EntityBase extends BeanBase {
    private Date updated = new Date();
    private String updatedBy = "tvapp";
   
    @Column(name = "updated", nullable = false)
    public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
    @Column(name = "updated_by", nullable = false)
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}  

}

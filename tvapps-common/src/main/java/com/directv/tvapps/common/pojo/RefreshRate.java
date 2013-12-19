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
@Table(name="REFRESH_RATE")
@SequenceGenerator(name="refresh_rate_sequence", sequenceName="REFRESH_RATE_SEQ", allocationSize=1)
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class RefreshRate extends EntityBase{
	private Long Id;
	private Integer refreshRate;
	private boolean defaultValue;

	@Id @GeneratedValue (strategy=GenerationType.SEQUENCE, generator="refresh_rate_sequence")
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
	@Column(name = "REFRESH_RATE")
	public Integer getRefreshRate() {
		return refreshRate;
	}
	public void setRefreshRate(Integer refreshRate) {
		this.refreshRate = refreshRate;
	}
	
	
	@Column(name = "is_DEFAULT")
	public boolean isDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(boolean defaultValue) {
		this.defaultValue = defaultValue;
	}
}

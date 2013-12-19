package com.directv.tvapps.common.pojo;
/*
 * @author Paul Hsu
 */
import java.math.BigDecimal;

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
@Table(name="RECEIVER_MODEL")
@SequenceGenerator(name="receiver_model_sequence", sequenceName="RECEIVER_MODEL_SEQ", allocationSize=1)
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ReceiverModel extends EntityBase {
	private Long id;
	private String model;
	private boolean supported;
	
	 @Id 
	 @GeneratedValue  (strategy=GenerationType.SEQUENCE, generator="receiver_model_sequence")
	 @Column(name="ID")
	 public Long getId() {
	       return id;
	 }
	 public void setId(Long id) {
	      this.id = id;
	 }
	 
	 
	@Column(name="MODEL")
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	@Column(name="SUPPORTED")
	public boolean isSupported() {
		return supported;
	}
	public void setSupported(boolean supported) {
		this.supported = supported;
	}

}

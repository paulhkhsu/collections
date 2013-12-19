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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name="USAGE_TYPE")
@SequenceGenerator(name="usage_type_sequence", sequenceName="USAGE_TYPE_SEQ", allocationSize=1)
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class UsageType extends EntityBase{
	
	private Long id;
	private Long parentId;
	private String name;
	private String description;
	
	public UsageType(){
	}
	
	@Id @GeneratedValue (strategy=GenerationType.SEQUENCE, generator="usage_type_sequence")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

    @Column(name = "parent_id", nullable = true)
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    @Column(name = "description", nullable = false)
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

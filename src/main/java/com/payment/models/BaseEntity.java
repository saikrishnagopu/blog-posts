package com.payment.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Version;


@MappedSuperclass
public abstract class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	
	@Column(updatable=false)
	public Date createdOn;

	@Version
	@Column(updatable=true)
	public Date lastUpdate;
	
	 @PrePersist
	 protected void onCreate() {
		 createdOn = new Date();
	  }
	
}

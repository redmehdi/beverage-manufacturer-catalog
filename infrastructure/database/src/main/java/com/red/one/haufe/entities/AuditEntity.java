package com.red.one.haufe.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * @author Redouane Mehdi
 */
//@EntityListeners(AuditingEntityListener.class)
public abstract class AuditEntity implements Serializable {

	//@Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id;
	@CreatedBy
	private String createdBy;
	@LastModifiedBy
	private String modifiedBy;
	@CreatedDate LocalDateTime createdDate;
	@LastModifiedDate LocalDateTime modifiedDate;
}

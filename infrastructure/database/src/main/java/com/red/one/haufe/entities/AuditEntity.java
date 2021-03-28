package com.red.one.haufe.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.EntityListeners;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author Redouane Mehdi
 */
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditEntity implements Serializable {

	@CreatedBy
	private String createdBy;
	@LastModifiedBy
	private String modifiedBy;
	@CreatedDate LocalDateTime createdDate;
	@LastModifiedDate LocalDateTime modifiedDate;
}

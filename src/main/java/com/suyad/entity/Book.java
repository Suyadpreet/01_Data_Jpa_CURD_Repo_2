package com.suyad.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.repository.Temporal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book
{
	@Id
	private Integer boodId;
	private String bookName;
	private Long   bookprice;
	
	
	
	@CreationTimestamp
	@Column(name = "creation_date", updatable = false)
	private LocalDate dateCeated;
	@UpdateTimestamp
	@Column(name = "updation_date", insertable = false)
	private LocalDate updatedDate;
	
	
	

}

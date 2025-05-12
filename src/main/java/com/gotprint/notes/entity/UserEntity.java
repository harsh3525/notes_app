package com.gotprint.notes.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user_details")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "email",unique = true)
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	
	@Column(name="modified_date")
	private LocalDateTime modifiedDate;
	
	@OneToMany(mappedBy = "user")
	@Builder.Default
	private List<NoteEntity> notes = new ArrayList<>();

}

package com.example.easynotes.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "itens")
@EntityListeners(AuditingEntityListener.class)

public class Item {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome_item;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_item() {
		return nome_item;
	}

	public void setNome_item(String nome_item) {
		this.nome_item = nome_item;
	}

}

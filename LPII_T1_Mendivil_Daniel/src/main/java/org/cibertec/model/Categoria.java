package org.cibertec.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;


enum Frecuencia {
    Diario, Interdiario, Semanal, Por_Stock
}

@Getter
@Setter
@Entity
@Table(name="categoria")
public class Categoria  implements Serializable{
private static final long serialVersionUID = 1L;

@Id
@GeneratedValue (strategy=GenerationType.IDENTITY)
@Column(name="id_cate")
private int idCategoria;
@Column(name = "descripcion", nullable = false)
private String descripcion;

@Enumerated(EnumType.STRING)
@Column(name="frecuencia_compra")
private Frecuencia frecuenciaCompra;

@Override
public String toString() {
	return idCategoria + "-" + descripcion + "-" + frecuenciaCompra;
}
}

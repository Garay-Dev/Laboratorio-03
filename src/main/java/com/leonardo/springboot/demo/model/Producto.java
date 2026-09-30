package com.leonardo.springboot.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_prod;
	
	private String des_prod;
	private int stk_prod;
	private double pre_prod;
	
	@ManyToOne
	@JoinColumn(name = "idcategoria")
	private Categoria categoria;

	public int getId_prod() {
		return id_prod;
	}

	public void setId_prod(int id_prod) {
		this.id_prod = id_prod;
	}

	public String getDes_prod() {
		return des_prod;
	}

	public void setDes_prod(String des_prod) {
		this.des_prod = des_prod;
	}

	public int getStk_prod() {
		return stk_prod;
	}

	public void setStk_prod(int stk_prod) {
		this.stk_prod = stk_prod;
	}

	public double getPre_prod() {
		return pre_prod;
	}

	public void setPre_prod(double pre_prod) {
		this.pre_prod = pre_prod;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}

package com.leonardo.springboot.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_usua;

    private String nom_usua;
    private String ape_usua;
    private String usr_usua;
    private String cla_usua;
    private LocalDate fna_usua;
    private int idtipo;
    private int est_usua;

    public int getCod_usua() {
        return cod_usua;
    }

    public void setCod_usua(int cod_usua) {
        this.cod_usua = cod_usua;
    }

    public String getNom_usua() {
        return nom_usua;
    }

    public void setNom_usua(String nom_usua) {
        this.nom_usua = nom_usua;
    }

    public String getApe_usua() {
        return ape_usua;
    }

    public void setApe_usua(String ape_usua) {
        this.ape_usua = ape_usua;
    }

    public String getUsr_usua() {
        return usr_usua;
    }

    public void setUsr_usua(String usr_usua) {
        this.usr_usua = usr_usua;
    }

    public String getCla_usua() {
        return cla_usua;
    }

    public void setCla_usua(String cla_usua) {
        this.cla_usua = cla_usua;
    }

    public LocalDate getFna_usua() {
        return fna_usua;
    }

    public void setFna_usua(LocalDate fna_usua) {
        this.fna_usua = fna_usua;
    }

    public int getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }

    public int getEst_usua() {
        return est_usua;
    }

    public void setEst_usua(int est_usua) {
        this.est_usua = est_usua;
    }

    @Override
    public String toString() {
        return "Usuario [cod_usua=" + cod_usua
                + ", nom_usua=" + nom_usua
                + ", ape_usua=" + ape_usua
                + ", usr_usua=" + usr_usua
                + ", cla_usua=" + cla_usua
                + ", fna_usua=" + fna_usua
                + ", idtipo=" + idtipo
                + ", est_usua=" + est_usua + "]";
    }
}
package com.example.q2.model;

import java.util.Date;

public class CidadeTemp {

    private String cidade;

    private int temp;
    private Date diaMesAno;
/*

 CREATE TABLE `cidades_temperatura`.`temperatura` (
  `CIDADE` VARCHAR(45) NOT NULL,
  `TEMPERATURA` INT NOT NULL,
  PRIMARY KEY (`CIDADE`));

* */
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Date getDiaMesAno() {
        return diaMesAno;
    }

    public void setDiaMesAno(Date anoMesDia) {
        this.diaMesAno = anoMesDia;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}

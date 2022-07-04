package com.example.q2.Service;

import com.example.q2.model.CidadeTemp;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class dataTempService {


    public CidadeTemp SetTemp(CidadeTemp cidade){
        int temp = 0;
        int min = 12;
        int max = 43;

        Random rand = new Random() ;

        for(int i = 0; i <= 50; i++){
            temp = temp + rand.nextInt(max-min) + min;
        }

        temp = (temp/50);

        cidade.setTemp(temp);

        return cidade;
    }

    public int setTempInt(){
        int temp = 0;
        int min = 12;
        int max = 43;

        Random rand = new Random() ;

        for(int i = 0; i <= 50; i++){
            temp = temp + rand.nextInt(max-min) + min;
        }

        temp = (temp/50);

        return temp;
    }


    public CidadeTemp SetDiaMesAno(CidadeTemp cidade){
        Date dt = new Date();


        cidade.setDiaMesAno(dt);

        return cidade;
    }


    public ArrayList<CidadeTemp> cincoDias(CidadeTemp cidade){

        ArrayList<CidadeTemp> listaPrevisaoCidades = new ArrayList<>();

        listaPrevisaoCidades.add(cidade);

        for (int i=0; i<5;i++){
            CidadeTemp cidadeMaisDias = new CidadeTemp();
            SetTemp(cidadeMaisDias);
            SetDiaMesAno(cidadeMaisDias);

            listaPrevisaoCidades.add(cidadeMaisDias);
        }



        return listaPrevisaoCidades;
    }
}

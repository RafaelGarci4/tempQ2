package com.example.q2.controller;

import com.example.q2.DAO.cidadesDAO;
import com.example.q2.Service.dataTempService;
import com.example.q2.factory.ConnectionFactory;
import com.example.q2.model.CidadeTemp;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    static   cidadesDAO dao ;
    dataTempService dts = new dataTempService();
    //Servlet(){
      // dts = new dataTempService();
    //}

    protected  void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

        Connection connection = null;
        try {
            connection = new ConnectionFactory().recuperarConexao();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        dao = new cidadesDAO(connection);
        CidadeTemp cidade = new CidadeTemp();
        String inputCidade = request.getParameter("cidade");

        cidade.setCidade(inputCidade);

        dts.SetTemp(cidade);
        dts.SetDiaMesAno(cidade);

        try {
            dao.insert(cidade);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(cidade.getCidade()+" "+cidade.getDiaMesAno()+" "+cidade.getTemp());
        //System.out.println(nomeClienteInput);


        Gson jview = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
        String cidadeJson = jview.toJson(cidade);
        response.setContentType("application/json");
        response.getWriter().write(cidadeJson);
    }
}

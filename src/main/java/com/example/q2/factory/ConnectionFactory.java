package com.example.q2.factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {



    public DataSource dataSource;

    public ConnectionFactory(){
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/cidades_temperatura?useTimezone=true&serverTimezone=UTC");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("Euprefirodota2");
        this.dataSource = comboPooledDataSource;
    }

    public Connection recuperarConexao() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        return this.dataSource.getConnection();

    }
}

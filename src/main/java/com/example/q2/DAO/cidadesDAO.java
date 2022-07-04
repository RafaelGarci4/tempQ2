package com.example.q2.DAO;

import com.example.q2.model.CidadeTemp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class cidadesDAO {
    private Connection connection;

    public cidadesDAO(Connection connection){
        this.connection = connection;
    }

    public void insert(CidadeTemp cidadeTemp) throws SQLException {

        String sql = "INSERT INTO temperatura (CIDADE, TEMPERATURA) VALUES (?, ?)";

        LocalDateTime data = LocalDateTime.now();
        // DateTimeFormatter  robson = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            pstm.setString(1,cidadeTemp.getCidade());
            pstm.setInt(2,cidadeTemp.getTemp());

            pstm.execute();
        }
    }
}

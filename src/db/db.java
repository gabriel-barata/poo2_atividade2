package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class db {

    private static Connection conexao;
    
    public static Properties getPropriedades() throws IOException {

        Properties propriedades = new Properties();
        FileInputStream arquivo = new FileInputStream("config/db.properties");
        propriedades.load(arquivo);
        return propriedades;
    }

    public static Connection getConexao() throws SQLException {

        if (conexao == null) {
            try {
                Properties p = db.getPropriedades();
                conexao = DriverManager.getConnection(p.getProperty("host"),
                        p.getProperty("user"),
                        p.getProperty("password"));
            } catch (IOException e) {
                e.fillInStackTrace();
            }
        }
        return conexao;
    }

    public static void fechaConexao() {
        if ( conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.fillInStackTrace();
            }
        }
    }
}

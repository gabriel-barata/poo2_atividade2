import entidades.Disciplina;
import db.db;
import entidades.DisciplinaDAO;
import entidades.DisciplinaDAOImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner console = new Scanner(System.in);
        Connection cnx = db.getConexao();
        DisciplinaDAO client = new DisciplinaDAOImpl(cnx);

        Disciplina d1 = new Disciplina("Calculo I", 72);

        client.insert(d1);

        Disciplina d2 = client.findById(1);
        System.out.println(d2.toString());

    }

}

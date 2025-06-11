package entidades;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAOImpl implements DisciplinaDAO {

    private Connection cnx;

    public DisciplinaDAOImpl(Connection cnx) {
        this.cnx = cnx;
    }

    @Override
    public void insert(Disciplina d) throws SQLException {
        PreparedStatement pst = null;
        String query = "INSERT INTO disciplina (nomedisciplina, cargahoraria) VALUES (?, ?);";

        try {
            pst = cnx.prepareStatement(query);
            pst.setString(1, d.getNomeDisciplina());
            pst.setInt(2, d.getCargaHoraria());

            if (pst.executeUpdate() >= 1) {
                System.out.println("Disciplina " + d.getNomeDisciplina() + " inserida com sucesso!");
            } else {
                System.out.println("Disciplina " + d.getNomeDisciplina() + " não pode ser inserida!");
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pst.close();
        }
    }

    @Override
    public void update(Disciplina d) throws SQLException {
        PreparedStatement pst = null;
        String query = "UPDATE disciplina SET nomedisciplina = ?, cargahoraria = ? WHERE iddisciplina=?";

        try {
            pst = cnx.prepareStatement(query);
            pst.setString(1, d.getNomeDisciplina());
            pst.setInt(2, d.getCargaHoraria());
            pst.setInt(3, d.getIdDisciplina());

            if (pst.executeUpdate() > 0) {
                System.out.println("Disciplina (id: " + d.getIdDisciplina() + ") alterada com sucesso!");
            }
            else {
                System.out.println("Não foi realizada a alteração da Disciplina!");
            }
        }
        catch(SQLException e) {
            e.fillInStackTrace();
        }
        finally {
            pst.close();
        }
    }

    @Override
    public void deleteById(Integer id) throws SQLException {
        PreparedStatement pst = null;
        String query = "DELETE FROM disciplina WHERE iddisciplina = ?";

        try {
            pst = cnx.prepareStatement(query);
            pst.setInt(1, id);

            if (pst.executeUpdate() >= 1)
                System.out.println("Disciplina excluida com sucesso!");
            else
                System.out.println("Erro: não foi possível excluir a disciplina!");
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pst.close();
        }
    }

    @Override
    public Disciplina findById(Integer id) throws SQLException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "SELECT * FROM disciplina WHERE iddisciplina = ?";

        try {
            pst = cnx.prepareStatement(query);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next())
                return new Disciplina(
                        rs.getInt("iddisciplina"),
                        rs.getString("nomedisciplina"),
                        rs.getInt("cargahoraria")
                );
        } catch (SQLException e) {
            e.fillInStackTrace();
        } finally {
            rs.close();
            pst.close();
        }
        return null;
    }

    @Override
    public List<Disciplina> findAll() throws SQLException {
        List<Disciplina> disciplinas = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;
        String query = "SELECT * FROM disciplina";

        try {
            st = cnx.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                Disciplina d = new Disciplina(
                        rs.getInt("iddisciplina"),
                        rs.getString("nomedisciplina"),
                        rs.getInt("cargahoraria")
                );
                disciplinas.add(d);
            }
        } catch (SQLException e) {
            e.fillInStackTrace();
        } finally {
            rs.close();
            st.close();
        }
        return disciplinas;
    }
}

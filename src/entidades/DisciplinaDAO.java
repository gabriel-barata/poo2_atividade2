package entidades;

import java.sql.SQLException;
import java.util.List;

public interface DisciplinaDAO {

    public void insert(Disciplina d) throws SQLException;
    public void update(Disciplina d) throws SQLException;
    public void deleteById(Integer id) throws SQLException;
    public Disciplina findById(Integer id) throws SQLException;
    public List<Disciplina> findAll() throws SQLException;

}

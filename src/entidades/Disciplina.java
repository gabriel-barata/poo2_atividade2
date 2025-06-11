package entidades;

import java.util.Objects;

public class Disciplina {

    private int idDisciplina;
    private String nomeDisciplina;
    private int cargaHoraria;

    public Disciplina(int idDisciplina, String nomeDisciplina, int cargaHoraria) {
        this.idDisciplina = idDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.cargaHoraria = cargaHoraria;
    }

    public Disciplina(String nomeDisciplina, int cargaHoraria) {
        this.nomeDisciplina = nomeDisciplina;
        this.cargaHoraria = cargaHoraria;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return idDisciplina == that.idDisciplina && cargaHoraria == that.cargaHoraria && Objects.equals(nomeDisciplina, that.nomeDisciplina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDisciplina, nomeDisciplina, cargaHoraria);
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "idDisciplina=" + idDisciplina +
                ", nomeDisciplina='" + nomeDisciplina + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }
}

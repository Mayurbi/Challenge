package dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tab_prontuario")
public class Prontuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "receitas", length = 80, nullable = false)
	private String receitas;

	@Column(name = "relatorio", length = 200, nullable = false)
	@Lob
	private String relatorio;

	@OneToOne
	private Medico medicoResponsavel;

	@Column(name = "exame", length = 80, nullable = false)
	private Exame exames;

	@OneToOne
	private Paciente nomePaciente;

//Construtores
	public Prontuario() {

	}

	public Prontuario(Long id, Paciente nomePaciente, Exame exames, String receitas, String relatorio,
			Medico medicoResponsavel) {
		this.id = id;
		this.nomePaciente = nomePaciente;
		this.exames = exames;
		this.receitas = receitas;
		this.relatorio = relatorio;
		this.medicoResponsavel = medicoResponsavel;

	}

// Getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReceitas() {
		return receitas;
	}

	public void setReceitas(String receitas) {
		this.receitas = receitas;
	}

	public String getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(String relatorio) {
		this.relatorio = relatorio;
	}

	public Medico getMedicoResponsavel() {
		return medicoResponsavel;
	}

	public void setMedicoResponsavel(Medico medicoResponsavel) {
		this.medicoResponsavel = medicoResponsavel;
	}

	public Exame getExames() {
		return exames;
	}

	public void setExames(Exame exames) {
		this.exames = exames;
	}

	public Paciente getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(Paciente nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

//Hash e equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exames == null) ? 0 : exames.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((medicoResponsavel == null) ? 0 : medicoResponsavel.hashCode());
		result = prime * result + ((nomePaciente == null) ? 0 : nomePaciente.hashCode());
		result = prime * result + ((receitas == null) ? 0 : receitas.hashCode());
		result = prime * result + ((relatorio == null) ? 0 : relatorio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prontuario other = (Prontuario) obj;
		if (exames == null) {
			if (other.exames != null)
				return false;
		} else if (!exames.equals(other.exames))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (medicoResponsavel == null) {
			if (other.medicoResponsavel != null)
				return false;
		} else if (!medicoResponsavel.equals(other.medicoResponsavel))
			return false;
		if (nomePaciente == null) {
			if (other.nomePaciente != null)
				return false;
		} else if (!nomePaciente.equals(other.nomePaciente))
			return false;
		if (receitas == null) {
			if (other.receitas != null)
				return false;
		} else if (!receitas.equals(other.receitas))
			return false;
		if (relatorio == null) {
			if (other.relatorio != null)
				return false;
		} else if (!relatorio.equals(other.relatorio))
			return false;
		return true;
	}

//ToString
	@Override
	public String toString() {
		return "Prontuario [id=" + id + ", receitas=" + receitas + ", relatorio=" + relatorio + ", medicoResponsavel="
				+ medicoResponsavel + ", exames=" + exames + ", nomePaciente=" + nomePaciente + "]";
	}

}

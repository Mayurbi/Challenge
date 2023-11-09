package dominio;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ids.PacienteId;

@Entity
@Table(name = "tab_paciente")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 3L;
	
	@EmbeddedId
	private PacienteId id;

	@Column(name = "nome", length = 60, nullable = false)
	private String nome;

	@Column(name = "email", length = 50, nullable = false)
	private String email;

	@Column(name = "senha", length = 20, nullable = false)
	private String senha;

	@Column(name = "telefone", length = 60, nullable = false)
	private String telefone;

	@Column(name = "data_nascimento", length = 60, nullable = false)
	private LocalDate dataNasc;

	@Embedded
	private Exame exame;

	@OneToOne(mappedBy = "nomePaciente")
	private Prontuario prontuario;

//Construtores
	public Paciente() {

	}

	public Paciente(PacienteId id, String nome, String email, String senha, String telefone, LocalDate dataNasc,
			Exame exame, Prontuario prontuario) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.dataNasc = dataNasc;
		this.exame = exame;
		this.prontuario = prontuario;
	}

//Getters and setters

	public PacienteId getId() {
		return id;
	}

	public void setId(PacienteId id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public Prontuario getProntuario() {
		return prontuario;
	}

	public void setProntuario(Prontuario prontuario) {
		this.prontuario = prontuario;
	}

//Hash e equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataNasc == null) ? 0 : dataNasc.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((exame == null) ? 0 : exame.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((prontuario == null) ? 0 : prontuario.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		Paciente other = (Paciente) obj;
		if (dataNasc == null) {
			if (other.dataNasc != null)
				return false;
		} else if (!dataNasc.equals(other.dataNasc))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (exame == null) {
			if (other.exame != null)
				return false;
		} else if (!exame.equals(other.exame))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (prontuario == null) {
			if (other.prontuario != null)
				return false;
		} else if (!prontuario.equals(other.prontuario))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

//ToString

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", telefone="
				+ telefone + ", dataNasc=" + dataNasc + ", exame=" + exame + ", prontuario=" + prontuario + "]";
	}
}

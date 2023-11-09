package dominio;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import enuns.EspecializacaoEnum;
import ids.MedicoId;

@Entity
@Table(name = "tab_medico")
public class Medico implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MedicoId id;

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

	@Column(name = "especializacao", nullable = false)
	@Enumerated(EnumType.STRING)
	private EspecializacaoEnum especializacao;

	@OneToOne
	@JoinColumn(name = "prontuario_id")
	private Prontuario prontuario;

//Construtores	
	public Medico() {
		super();

	}

	public Medico(MedicoId id, String nome, String email, String senha, String telefone, LocalDate dataNasc,
			EspecializacaoEnum especializacao, Prontuario prontuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.dataNasc = dataNasc;
		this.especializacao = especializacao;
		this.prontuario = prontuario;
	}

//Getters and setters
	public MedicoId getId() {
		return id;
	}

	public void setId(MedicoId id) {
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

	public EspecializacaoEnum getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(EspecializacaoEnum especializacao) {
		this.especializacao = especializacao;
	}

	public void setProntuario(Prontuario prontuario) {
		this.prontuario = prontuario;
	}

	public Prontuario getProntuario() {
		return prontuario;
	}

//Hash e equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataNasc == null) ? 0 : dataNasc.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((especializacao == null) ? 0 : especializacao.hashCode());
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
		Medico other = (Medico) obj;
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
		if (especializacao != other.especializacao)
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
		return "Medico [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", telefone="
				+ telefone + ", dataNasc=" + dataNasc + ", especializacao=" + especializacao + ", prontuario="
				+ prontuario + "]";
	}
	
}

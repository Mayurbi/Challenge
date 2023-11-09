package dominio;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import enuns.ExamesEnum;

@Embeddable
@Table(name = "tab_exame")
public class Exame {
	@Column(name = "exames", nullable = false)
	@Enumerated(EnumType.STRING)
	private ExamesEnum tipoExames;

	@Column(name = "data_exame", length = 80, nullable = false)
	private LocalDate data;

	@Column(name = "resultado", length = 80, nullable = false)
	private String resultado;

//Construtores
	public Exame() {

	}

	public Exame(ExamesEnum tipoExames, LocalDate data, String resultado) {
		this.tipoExames = tipoExames;
		this.data = data;
		this.resultado = resultado;
	}

//Getters and setters
	public ExamesEnum getTipoExames() {
		return tipoExames;
	}

	public void setTipoExames(ExamesEnum tipoExames) {
		this.tipoExames = tipoExames;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

//Hash e equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((resultado == null) ? 0 : resultado.hashCode());
		result = prime * result + ((tipoExames == null) ? 0 : tipoExames.hashCode());
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
		Exame other = (Exame) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (resultado == null) {
			if (other.resultado != null)
				return false;
		} else if (!resultado.equals(other.resultado))
			return false;
		if (tipoExames != other.tipoExames)
			return false;
		return true;
	}

//ToString
	@Override
	public String toString() {
		return "Exame [tipoExames=" + tipoExames + ", data=" + data + ", resultado=" + resultado + "]";
	}
}

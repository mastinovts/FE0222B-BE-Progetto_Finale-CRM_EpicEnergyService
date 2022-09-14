package it.epicode.be.epicenergyservice.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Fattura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "Specificare l'anno")
	private Integer anno;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Specificare la data")
	private LocalDate data;
	@NotNull(message = "Specificare l' importo")
	private BigDecimal importo;
	@NotNull(message = "Specificare il numero")
	private Integer numero;
	@Enumerated(EnumType.STRING)
	private TipoStato statoFattura;
	@ManyToOne
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property = "id")
	private Cliente cliente;
	@Override
	public String toString() {
		return "Fattura [anno=" + anno + ", data=" + data + ", importo=" + importo + ", numero=" + numero
				+ ", stato=" + statoFattura;
	}
	
}

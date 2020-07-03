package tacos;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Digits;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Taco_Order")
public class Order implements Serializable {

	@NotBlank(message="Name is required")
	private String name;

	@NotBlank(message="Street is required")
	private String street;

	@NotBlank(message="City is required")
	private String city;

	@NotBlank(message="State is required")
	private String state;

	@NotBlank(message="Zip is required")
	private String deliveryZip;

	@CreditCardNumber(message="Not a valid credit card number")
	private String ccNumber;

	@Pattern(regexp="^(0[1-9]|1[0-2])([\\\\/])([1-9][0-9])$"
			,message="Must be formatted MM/YY")
	private String ccExpiration;

	@Digits(integer=3, fraction=0, message="Invalid CVV")
	private String ccCVV;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Date placeAt;

	@PrePersist
	void placeAt(){
		this.placeAt = new Date();
	}

	@ManyToMany(targetEntity = Taco.class)
	private List<Taco> tacos = new ArrayList<>();
	public void addDesign(Taco design){
		this.tacos.add(design);
	}
}

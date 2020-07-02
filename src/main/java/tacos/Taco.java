package tacos;
import lombok.Data;
import lombok.Generated;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Data
@Entity
public class Taco {
	
	@NotNull
	@Size(min=5, message="Name must be at least 5 characters long")
	private String name;

	@ManyToMany(targetEntity = Ingredient.class)
	@Size(min=1, message="You must chooseat lease 1 ingredient")
	private List<Ingredient> ingredients;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Date createdAt;

	@PrePersist
	void createdAt(){
		this.createdAt = new Date();
	}
}

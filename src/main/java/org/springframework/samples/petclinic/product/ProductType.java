package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "product_types")
public class ProductType {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
	@NotEmpty
	@Size(min=3, max=50)
	@Column(unique = true)
    private String name;
}

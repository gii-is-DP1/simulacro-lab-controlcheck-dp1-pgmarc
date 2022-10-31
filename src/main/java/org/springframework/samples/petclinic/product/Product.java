package org.springframework.samples.petclinic.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    @NotEmpty
    @Size(min = 3, max=50)
    private String name;
    @Positive
    private double price;
    @ManyToOne(optional = false)
    private ProductType productType;
    
    public boolean isNew() {
		return this.id == null;
	}
}

package website.livemarketing.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class Promotion  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 100)
	private String name;
	
	@NotNull
	private Float value;
	
	@Size(max=1000)
	private String description;
	
	@NotNull
	@Column(name = "CREATED_TIME")
	private Long createdTime;
	
	@ManyToOne
	@JoinColumn(name ="PROMOTION_TYPE_ID")
	private PromotionType promotionType;
	
	

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "promotions")
	private Set<Product> products;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Float getValue() {
		return value;
	}


	public void setValue(Float value) {
		this.value = value;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Long getCreatedTime() {
		return createdTime;
	}


	public void setCreatedTime(Long createdTime) {
		this.createdTime = createdTime;
	}


	public PromotionType getPromotionType() {
		return promotionType;
	}


	public void setPromotionType(PromotionType promotionType) {
		this.promotionType = promotionType;
	}


	public Set<Product> getProducts() {
		return products;
	}


	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
}

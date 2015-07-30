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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="PRODUCT_TYPE")
public class ProductType implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(max = 20)
	@Column(unique = true)
	private String code;

	@NotNull
	@Size(max = 100)
	private String name;

	@Size(max = 5000)
	private String description;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;

	@NotNull
	@Column(name = "CREATED_TIME")
	private Long createdTime;

	@OneToMany(mappedBy="productType",fetch=FetchType.EAGER)
	@OrderBy("sortOrder.index ASC")
	private Set<ProductTypeImage> ProductTypeImage; 
}

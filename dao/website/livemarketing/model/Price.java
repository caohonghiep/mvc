package website.livemarketing.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class Price  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	String currency
		
	@Size(max=1000)
	private String description;
	
	@NotNull
	@Column(name = "CREATED_TIME")
	private Long createdTime;//move to log in furture
	
	@NotNull
	@Column(name = "EFFECTIVE_TIME")
	private Long effectiveTime;//move to log in furture
	
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	Product product;
	
	
	
	
}

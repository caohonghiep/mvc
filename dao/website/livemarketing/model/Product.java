package website.livemarketing.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.sun.istack.internal.NotNull;

@Entity
@Table
public class Product implements Serializable {

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
	@Column(name = "CREATED_TIME")
	private Long createdTime;

	@OneToOne
	@JoinColumn(name = "SORT_ORDER_ID")
	private SortOrder sortOrder;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	@OrderBy("UPDATED_TIME DESC")
	private Set<ProductType> types;//color, 

	@ManyToOne
	@JoinColumn(name = "TRADE_MARK")
	private TradeMark tradeMark;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	@OrderBy("createdTime DESC")//createdTime of Price is updateTime of Product
	private Set<Price> prices;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "PRODUCT_TO_PROMOTION", joinColumns = { @JoinColumn(name = "PRODUCT_ID") }, inverseJoinColumns = { @JoinColumn(name = "PROMOTION_ID") })
	@OrderBy("createdTime DESC")
	private Set<Promotion> promotions;	
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "PRODUCT_TO_TAG", joinColumns = { @JoinColumn(name = "PRODUCT_ID") }, inverseJoinColumns = { @JoinColumn(name = "TAG_ID") })
	private Set<Tag> tags;	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public SortOrder getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(SortOrder sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Price> getPrices() {
		return prices;
	}

	public void setPrices(Set<Price> prices) {
		this.prices = prices;
	}

	public Set<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(Set<Promotion> promotions) {
		this.promotions = promotions;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Set<ProductType> getTypes() {
		return types;
	}

	public void setTypes(Set<ProductType> types) {
		this.types = types;
	}
	
	

}

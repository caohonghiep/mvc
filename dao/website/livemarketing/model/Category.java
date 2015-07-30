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
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="CATEGORY")
public class Category implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 100)
	private String name;
	
	@OneToOne
	@JoinColumn(name = "SORT_ORDER_ID")
	private SortOrder sortOrder;
	
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Category parent;
	
	@OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
	@OrderBy("sortOrder.index DESC")
	private Set<Category> childs;
	
	@OneToMany(mappedBy="category",fetch=FetchType.LAZY)
	@OrderBy("sortOrder.index DESC")
	private Set<Product> products;
	
	@Size(max=1000)
	private String description;
	
	@NotNull
	@Column(name = "CREATED_TIME")
	private Long createdTime;//move to log in furture
	
	@OneToOne
	@JoinColumn(name = "AVATAR_IMAGE_ID")
	private Image avatarImage;
	
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

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public Set<Category> getChilds() {
		return childs;
	}

	public void setChilds(Set<Category> childs) {
		this.childs = childs;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
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

	public Image getAvatarImage() {
		return avatarImage;
	}

	public void setAvatarImage(Image avatarImage) {
		this.avatarImage = avatarImage;
	}

}

package website.livemarketing.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="PRODUCT_TYPE_IMAGE")
public class ProductTypeImage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "THUMBNAIL_IMAGE_ID")
	Image thumbnailImage;
	
	@OneToOne
	@JoinColumn(name = "IMAGE_ID")
	Image image;
	
	@OneToOne
	@JoinColumn(name = "ZOOM_OUT_IMAGE_ID")
	Image zoomOutImage;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "PRODUCT_TYPE_ID")
	private ProductType productType;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Image getThumbnailImage() {
		return thumbnailImage;
	}

	public void setThumbnailImage(Image thumbnailImage) {
		this.thumbnailImage = thumbnailImage;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Image getZoomOutImage() {
		return zoomOutImage;
	}

	public void setZoomOutImage(Image zoomOutImage) {
		this.zoomOutImage = zoomOutImage;
	}
	
	

}

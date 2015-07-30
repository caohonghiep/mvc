package website.livemarketing.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="PROMOTION_TYPE")
public class PromotionType implements Serializable {
	
	//cardback, discount

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(max = 100)
	private String name;
	
	@Size(max = 100)
	private String rule;

	@Size(max = 5000)
	private String description;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "MARKER_IMAGE_ID")
	private Image markerImage;
	
}

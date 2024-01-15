package cinema.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ProjectionType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String type;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Auditorium auditorium;

	@OneToMany(mappedBy = "projectionType", cascade = CascadeType.ALL)
	private List<Projection> projections = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Auditorium getAuditorium() {
		return auditorium;
	}

	public void setAuditorium(Auditorium auditorium) {
		this.auditorium = auditorium;
		if (auditorium != null && !auditorium.getProjectionTypes().contains(this)) {
			auditorium.getProjectionTypes().add(this);
		}
	}

	public List<Projection> getProjections() {
		return projections;
	}

	public void setProjections(List<Projection> projections) {
		this.projections = projections;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectionType other = (ProjectionType) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "ProjectionType [id=" + id + ", type=" + type + ", auditorium=" + auditorium.getName() + "]";
	}

	

}

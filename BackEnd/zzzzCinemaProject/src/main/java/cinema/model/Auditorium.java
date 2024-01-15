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
import javax.persistence.OneToMany;

@Entity
public class Auditorium {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@OneToMany(mappedBy = "auditorium")
	private List<ProjectionType> projectionTypes = new ArrayList<>();

	@OneToMany(mappedBy = "auditorium", cascade = CascadeType.ALL)
	private List<Seat> seats = new ArrayList<>();

	@OneToMany(mappedBy = "auditorium", cascade = CascadeType.ALL)
	private List<Projection> projections = new ArrayList<>();

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

	public List<ProjectionType> getProjectionTypes() {
		return projectionTypes;
	}

	public void setProjectionTypes(List<ProjectionType> projectionTypes) {
		this.projectionTypes = projectionTypes;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
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
		Auditorium other = (Auditorium) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Auditorium [id=" + id + ", name=" + name + "]";
	}

}

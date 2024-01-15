package cinema.model;

import java.time.LocalDateTime;
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
public class Projection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDateTime dateTime;

	@Column(nullable = false)
	private double price;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Film film;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Auditorium auditorium;

	@ManyToOne
	@JoinColumn(nullable = false)
	private ProjectionType projectionType;

	@OneToMany(mappedBy = "projection", cascade = CascadeType.ALL)
	private List<Ticket> tickets = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Auditorium getAuditorium() {
		return auditorium;
	}

	public void setAuditorium(Auditorium auditorium) {
		this.auditorium = auditorium;
		if (auditorium != null && !auditorium.getProjections().contains(this)) {
			auditorium.getProjections().add(this);
		}
	}

	public ProjectionType getProjectionType() {
		return projectionType;
	}

	public void setProjectionType(ProjectionType projectionType) {
		this.projectionType = projectionType;
		if (projectionType != null && !projectionType.getProjections().contains(this)) {
			projectionType.getProjections().add(this);
		}
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
		if (film != null && !film.getProjections().contains(this)) {
			film.getProjections().add(this);
		}
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
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
		Projection other = (Projection) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Projection [id=" + id + ", dateTime=" + dateTime + ", price=" + price + ", film=" + film.getName()
				+ ", auditorium=" + auditorium.getName() + ", projectionType=" + projectionType.getType() + "]";
	}

}

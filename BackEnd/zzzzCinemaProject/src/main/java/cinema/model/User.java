package cinema.model;

import java.util.Objects;

import javax.persistence.*;

import cinema.enumeration.UserRole;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String username;

	@Column(unique = true, nullable = false)
	private String eMail;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column(nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	private UserRole role;

	public User() {

	}

	public User(String username, String eMail, String firstName, String lastName, String password, UserRole role) {
		this.username = username;
		this.eMail = eMail;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", role=" + role + "]";
	}

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getKorisnickoIme() {
//		return korisnickoIme;
//	}
//
//	public void setKorisnickoIme(String korisnickoIme) {
//		this.korisnickoIme = korisnickoIme;
//	}
//
//	public String geteMail() {
//		return eMail;
//	}
//
//	public void seteMail(String eMail) {
//		this.eMail = eMail;
//	}
//
//	public String getIme() {
//		return ime;
//	}
//
//	public void setIme(String ime) {
//		this.ime = ime;
//	}
//
//	public String getPrezime() {
//		return prezime;
//	}
//
//	public void setPrezime(String prezime) {
//		this.prezime = prezime;
//	}
//
//	public String getLozinka() {
//		return lozinka;
//	}
//
//	public void setLozinka(String lozinka) {
//		this.lozinka = lozinka;
//	}
//
//	public UserRole getUloga() {
//		return uloga;
//	}
//
//	public void setUloga(UserRole uloga) {
//		this.uloga = uloga;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		User other = (User) obj;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		return true;
//	}
//
//	@Override
//	public String toString() {
//		return "Korisnik [id=" + id + ", ime=" + ime + ", prezime=" + prezime + "]";
//	}

}

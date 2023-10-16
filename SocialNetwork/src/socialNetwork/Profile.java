package socialNetwork;

public class Profile {
	// Attributes: Unique ID, name, last name, birthdate, gender, hometown, study places (array), workplaces (array), liked films (array), group code
	// Methods: Constructor, getters, setters, equals, toString
	private String ID;
	private String name;
	private String lastName;
	private String birthDate;
	private String gender;
	private String birthPlace;
	private String homeTown;
	private String[] studiedAt;
	private String[] workedAt;
	private String[] likedFilms;
	private String groupCode;
	
	public Profile(String ID, String name, String lastName, String birthDate, String gender, String birthPlace, String homeTown, String[] studiedAt, String[] workedAt, String[] likedFilms, String groupCode) {
		this.ID = ID.toLowerCase();
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.gender = gender.toLowerCase();
		this.birthPlace = birthPlace.toLowerCase();
		this.homeTown = homeTown.toLowerCase();
		this.studiedAt = studiedAt;
		this.workedAt = workedAt;
		this.likedFilms = likedFilms;
		this.groupCode = groupCode;
	}

	/* Getters & Setters for every attribute */
	public String getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender.toLowerCase();
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace.toLowerCase();
	}

	public String getHomeTown() {
		return homeTown;
	}

	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown.toLowerCase();
	}

	public String[] getStudiedAt() {
		return studiedAt;
	}

	public void setStudiedAt(String[] studiedAt) {
		this.studiedAt = studiedAt;
	}

	public String[] getWorkedAt() {
		return workedAt;
	}

	public void setWorkedAt(String[] workedAt) {
		this.workedAt = workedAt;
	}

	public String[] getLikedFilms() {
		return likedFilms;
	}

	public void setLikedFilms(String[] likedFilms) {
		this.likedFilms = likedFilms;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode.toLowerCase();
	}

	// TODO: equals() & toString() methods

}

package social_network;

/**
 * The Profile class represents a social network profile with various attributes such as name, birth date, gender, birth place, hometown, educational institutions, places of work, liked films, and group code.
 * The class provides methods to get and set these attributes, as well as methods to compare and represent the profile as a string.
 * 
 * @author G612389
 * @version DSA_2023_2024
 */
public class Profile {
	private final String ID;
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
	
	/**
	 * Constructs a Profile object with the given parameters.
	 *
	 * @param ID the ID of the profile
	 * @param name the first name of the profile owner
	 * @param lastName the last name of the profile owner
	 * @param birthDate the birth date of the profile owner
	 * @param gender the gender of the profile owner
	 * @param birthPlace the birth place of the profile owner
	 * @param homeTown the hometown of the profile owner
	 * @param studiedAt the schools the profile owner has studied at
	 * @param workedAt the companies the profile owner has worked at
	 * @param likedFilms the films the profile owner likes
	 * @param groupCode the group code of the profile owner
	 */
	public Profile(String ID, String name, String lastName, String birthDate, String gender, String birthPlace, String homeTown, String[] studiedAt, String[] workedAt, String[] likedFilms, String groupCode) {
		this.ID = ID;
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

	/**
	 * Returns the ID of the profile.
	 * @return the ID of the profile
	 */
	public String getID() {
		return ID;
	}

	/**
	 * Returns the name of the profile.
	 *
	 * @return the name of the profile
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the profile.
	 * 
	 * @param name the name to set for the profile
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the last name of the profile owner.
	 *
	 * @return the last name of the profile owner
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name of the profile.
	 * 
	 * @param lastName the last name to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Returns the birth date of the profile.
	 * @return the birth date of the profile
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * Sets the birth date of the profile.
	 * @param birthDate the birth date to set
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Returns the gender of the profile.
	 * @return the gender of the profile
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender of the profile.
	 * 
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender.toLowerCase();
	}

	/**
	 * Returns the birthplace of the profile owner.
	 * @return a String representing the birthplace of the profile owner.
	 */
	public String getBirthPlace() {
		return birthPlace;
	}

	/**
	 * Sets the birth place of the profile.
	 * @param birthPlace the birth place to set
	 */
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace.toLowerCase();
	}

	/**
	 * Returns the hometown of the profile owner.
	 * @return the hometown of the profile owner
	 */
	public String getHomeTown() {
		return homeTown.toLowerCase();
	}

	/**
	 * Sets the hometown of the profile.
	 * @param homeTown the hometown to set
	 */
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown.toLowerCase();
	}

	/**
	 * Returns an array of strings representing the educational institutions the user has studied at.
	 *
	 * @return an array of strings representing the educational institutions the user has studied at
	 */
	public String[] getStudiedAt() {
		return studiedAt;
	}

	/**
	 * Returns a string representation of the educational institutions the user has studied at.
	 * 
	 * @return a string representation of the educational institutions the user has studied at
	 * @see #getStudiedAt()
	 */
	public String getStudiedAtString() {
		// Create a string representation of the studied at array
		String studiedAtString = "";

		// Loop through the studied at array
		for (int i = 0; i < this.studiedAt.length; i++) {
			// Add the current educational institution to the string
			studiedAtString += this.studiedAt[i];

			// Add a comma if the current educational institution is not the last educational institution in the array
			if (i < this.studiedAt.length - 1) {
				studiedAtString += ", ";
			}
		}

		// Add a period to the end of the string
		studiedAtString += ".";

		// Return the string
		return studiedAtString;
	}

	/**
	 * Sets the educational institutions where the profile owner has studied.
	 * @param studiedAt an array of strings representing the educational institutions.
	 */
	public void setStudiedAt(String[] studiedAt) {
		this.studiedAt = studiedAt;
	}

	/**
	 * Returns an array of Strings representing the places where the user has worked.
	 *
	 * @return an array of Strings representing the places where the user has worked
	 */
	public String[] getWorkedAt() {
		return workedAt;
	}

	/**
	 * Returns a string representation of the workplaces the user has worked at.
	 * 
	 * @return a string representation of the workplaces the user has worked at
	 * @see #getWorkedAt()
	 */
	public String getWorkedAtString() {
		// Create a string representation of the worked at array
		String workedAtString = "";

		// Loop through the worked at array
		for (int i = 0; i < this.workedAt.length; i++) {
			// Add the current workplace to the string
			workedAtString += this.workedAt[i];

			// Add a comma if the current workplace is not the last workplace in the array
			if (i < this.workedAt.length - 1) {
				workedAtString += ", ";
			}
		}

		// Add a period to the end of the string
		workedAtString += ".";
		// Return the string
		return workedAtString;
	}

	/**
	 * Sets the array of strings representing the places where the user has worked.
	 * @param workedAt the array of strings representing the places where the user has worked
	 */
	public void setWorkedAt(String[] workedAt) {
		this.workedAt = workedAt;
	}

	/**
	 * Returns an array of Strings representing the names of the films that the user has liked.
	 *
	 * @return an array of Strings representing the names of the films that the user has liked
	 */
	public String[] getLikedFilms() {
		return likedFilms;
	}

	/**
	 * Returns a string representation of the films the user has liked.
	 * 
	 * @return a string representation of the films the user has liked
	 * @see #getLikedFilms()
	 */
	public String getLikedFilmsString() {
		// Sort the liked films array
		this.sortLikedFilms();

		// Create a string representation of the liked films array
		String likedFilmsString = "";

		// Loop through the liked films array
		for (int i = 0; i < this.likedFilms.length; i++) {
			// Add the current film to the string
			likedFilmsString += this.likedFilms[i];

			// Add a comma if the current film is not the last film in the array
			if (i < this.likedFilms.length - 1) {
				likedFilmsString += ", ";
			}
		}
		// Add a period to the end of the string
		likedFilmsString += ".";

		// Return the string
		return likedFilmsString;
	}

	/**
	 * Sets the array of liked films for this profile.
	 * @param likedFilms the array of liked films to set
	 */
	public void setLikedFilms(String[] likedFilms) {
		this.likedFilms = likedFilms;
	}

	/**
	 * Returns the group code of this profile.
	 * @return the group code of this profile
	 */
	public String getGroupCode() {
		return groupCode;
	}

	/**
	 * Sets the group code for this profile.
	 * 
	 * @param groupCode the group code to set
	 */
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode.toLowerCase();
	}

	/**
	 * Compares this Profile object to another object to determine if they are equal.
	 * Two Profile objects are considered equal if their ID fields are equal.
	 *
	 * @param object the object to compare to this Profile object
	 * @return true if the objects are equal, false otherwise
	 */
	@Override
	public boolean equals(Object object) {
		// Check if the object is null or not a Profile object
		if (object == null) {
			return false;
		}

		if (!(object instanceof Profile)) {
			return false;
		}
		Profile profile = (Profile) object;
		return this.ID.equals(profile.ID);
	}

	/**
	 * Returns a string representation of the Profile object.
	 * The string contains the ID, name, last name, birth date, gender, birth place, home town, 
	 * studied at, worked at, liked films, and group code of the profile.
	 * @return a string representation of the Profile object.
	 */
	@Override
	public String toString() {
		return "ID: "+this.getID()+"\nName: "+this.getName()+"\nLast Name: "+this.getLastName()+"\nBirth Date: "+this.getBirthDate()+"\nGender: "+this.getGender()+"\nBirth Place: "+this.getBirthPlace()+"\nHome Town: "+this.getHomeTown()+"\nStudied At: "+this.getStudiedAtString()+"\nWorked At: "+this.getWorkedAtString()+"\nLiked Films: "+this.getLikedFilmsString()+"\nGroup Code: "+this.getGroupCode()+"\n";
	}

	/**
	 * Returns true if this profile has the same liked films as the given profile.
	 * @param profile the profile to compare to this profile
	 * @return true if this profile has the same liked films as the given profile, false otherwise
	 */
	public boolean hasSameProfile(Profile profile) {
		// Check if the liked films arrays are the same length
		if (this.getLikedFilms().length != profile.getLikedFilms().length) {
			return false;
		}
		// Sort both liked films arrays
		this.sortLikedFilms();
		profile.sortLikedFilms();

		// Compare the liked films arrays
		for (int i = 0; i < this.getLikedFilms().length; i++) {
			if (!this.getLikedFilms()[i].equals(profile.getLikedFilms()[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Sorts the liked films of this profile by name.
	 */
	public void sortLikedFilms() {
		// Get the liked films array
		String[] likedFilms = this.getLikedFilms();

		for (int i = 0; i < likedFilms.length; i++) {
			for (int j = i + 1; j < likedFilms.length; j++) {
				// Swap the films if the current film is greater than the next film
				if (likedFilms[i].compareTo(likedFilms[j]) > 0) {
					// Create a temporary variable to store the current film
					String temp = likedFilms[i];
					// Swap the films
					likedFilms[i] = likedFilms[j];
					likedFilms[j] = temp;
				}
			}
		}
		// Set the liked films array
		this.setLikedFilms(likedFilms);
	}
}

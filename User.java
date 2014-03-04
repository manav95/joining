/**
 * Class that describes a User class
 * @author Manav Dutta
 */
public class User implements Comparable<User>
{
    private String userName;
    private String firstName;
    /**
     * This constructs a User object 
     * @param user's username
     * @param user's first name
     */
    public User(String user, String first) {
        this.userName = user;
        this.firstName = first;
    }
    /**
     * This returns the User's username
     * @return username
     */
    public String getUserName() {
        return userName;
    }
    /**
     * This returns the User's first name
     * @return firstname
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * This returns a string representation of the User object
     * @return string representing this User object
     */
    public String toString() { 
        return userName + "-" + firstName;
    }
    /**
     * This returns if this User object equals the other object
     * Based on their user names
     * @param other- the other User object
     * @return if other is equal to this User
     */
    public boolean equals(Object other) {
        if (userName.equalsIgnoreCase(((User) other).getUserName())) {
            return true;
        }
        return false;
    }
    /**
     * Returns the comparison of the other object to this
     * User based on their Usernames.
     * @param other- the other User object
     * @return the integer comparison 
     */
    public int compareTo(User other) {
        String upperUsername = userName.toUpperCase();
        String upperOtherName = other.getUserName().toUpperCase();
        return upperUsername.compareTo(upperOtherName);
        }
    }
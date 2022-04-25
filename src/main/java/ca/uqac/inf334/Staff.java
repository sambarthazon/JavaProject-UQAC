package ca.uqac.inf334;

/**
 * Abstract class for university's staff
 */
public abstract class Staff{
    String firstName;
    String lastName;
    String function;
    University university;

    /**
     * Staff's constructor
     * @param lastName staff's last name
     * @param firstName staff's first name
     * @param function staff's function
     */
    public Staff(String lastName, String firstName, String function) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.function = function;
        this.university = null;
    }

    /**
     * Set university
     * @param newUniversity staff's new university
     */
    public abstract void SetUniversity(University newUniversity);

    /**
     * Remove university
     * @param university staff's university
     */
    public abstract void RemoveUniversity(University university);


    /**
     * Override toString method
     * @return last name and first name
     */
    public String toString() {
        return "\"" + this.lastName + " " + this.firstName + "\"";
    }


    /**
     * Convert staff to JSON syntax
     * @return staff's json syntax
     */
    public abstract String toJSON();
}
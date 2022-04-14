package ca.uqac.inf334;

public abstract class Staff{
    String firstName;
    String lastName;
    String function;
    University university;

    /**
     * Staff's constructor
     * @param lastName
     * @param firstName
     * @param function
     */
    public Staff(String lastName, String firstName, String function) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.function = function;
        this.university = null;
    }

    /**
     * Set university
     */
    public abstract void SetUniversity(University newUniversity);

    /**
     * Remove university
     */
    public abstract void RemoveUniversity(University university);


    /**
     * Override toString method
     */
    public String toString() {
        return "\"" + this.lastName + " " + this.firstName + "\"";
    }


    /**
     * Convert staff to JSON syntax
     */
    public abstract String toJSON();
}
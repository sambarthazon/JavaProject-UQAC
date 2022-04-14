package ca.uqac.inf334;

public class Admin extends Staff{

    /**
     * Admin's constructor
     * @param firstName
     * @param lastName
     */
    public Admin(String lastName, String firstName) {
        super(lastName, firstName, "Admin");
    }

    /**
     * Set a new university to the admin.
     * This action also add the admin to the university's admin list. If we set a university to an admin which it already has one,
     * its attributes will be reset.
     * @param newUniversity
     */
    @Override
    public void SetUniversity(University newUniversity) {
        System.out.println("---------- Set university (admin) ----------");
        if (this.university != newUniversity) { // If admin's university isn't equal to the new university
            if (this.university != null) { // If admin's university isn't null
                final University oldUniversity = this.university;
                this.RemoveUniversity(this.university); // Remove the admin from the university
            }
            if(newUniversity != null){ // If the new university isn't null
                this.university = newUniversity;
                System.out.println("Set university to : " + this);
                newUniversity.AddAdmin(this); // Add the admin to the university
            }
        }
    }

    /**
     * Remove the university of the admin.
     * This action also remove the admin from the university's admin list.
     * @param university
     */
    @Override
    public void RemoveUniversity(University university) {
        System.out.println("---------- Remove university (admin) ----------");
        if (this.university != null) { // If admin's university is equal to the university
            this.university = null;
            System.out.println(this + " admin has no longer university.\n");
            university.RemoveAdmin(this); // Remove the admin from the university
        } else {
            System.out.println(this + " admin isn't in the university.\n");
        }
    }


    /**
     * Convert Admin to JSON syntax
     * @return str
     */
    public String toJSON(){
        String str = "\n\t\t{\n" +
                "\t\t\t\"Firstname\" : \"" + this.firstName + "\"" +
                ",\n\t\t\t\"Lastname\" : \"" + this.lastName + "\"" +
                ",\n\t\t\t\"Function\" : \"" + this.function + "\"\n\t\t}";
        return str;
    }
}

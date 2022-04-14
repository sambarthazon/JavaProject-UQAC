package ca.uqac.inf334;

public class Secretary extends Staff{

    /**
     * Secretaty's Constructor
     * @param lastName
     * @param firstName
     */
    public Secretary(String lastName, String firstName) {
        super(lastName, firstName, "Secretary");
    }


    /**
     * Set university to the secretary
     * This action also remove the secretary from the University's secretary list.
     * @param newUniversity
     */
    @Override
    public void SetUniversity(University newUniversity) {
        System.out.println("---------- Set university (secretary) ----------");
        if (this.university != newUniversity) { // If secretary's university isn't equal to the university
            if (this.university != null) { // If secretary's university isn't null
                final University oldUniversity = this.university;
                this.RemoveUniversity(this.university); // Remove the secretary's university
            }
            if (newUniversity != null) { // If the new university isn't null
                this.university = newUniversity;
                System.out.println("Set university to : " + this);
                newUniversity.AddSecretary(this); // Add the secretary to the new university
            }
        }
    }

    /**
     * Remove the university of the secretary
     * Ths action also remove the Secretary from the University.
     * @param university
     */
    @Override
    public void RemoveUniversity(University university) {
        System.out.println("---------- Remove university (secretary) ----------");
        if (this.university != null) { // If secretary's university is equal to the university
            this.university = null;
            System.out.println(this + " secretary has no longer university.\n");
            university.RemoveSecretary(this); // Remove the secretary from the university
        } else{
            System.out.println(this + " secretary isn't in the university.\n");
        }
    }


    /**
     * Convert Secretaty to JSON syntax
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
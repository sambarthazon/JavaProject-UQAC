package ca.uqac.inf334;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdminTest {

    University uqac = new University("UQAC");
    University cegep = new University("CEGEP");

    Admin admin = new Admin("1", "Admin");

    @Test
    public void TestUniversity(){
        admin.SetUniversity(uqac);
        assertEquals(uqac, admin.university);
        assertTrue(uqac.adminList.contains(admin));
        admin.SetUniversity(cegep);
    }

    @Test
    public void TestToJSON(){
        assertEquals("\n\t\t{\n" +
                "\t\t\t\"Firstname\" : \"" + admin.firstName + "\"" +
                ",\n\t\t\t\"Lastname\" : \"" + admin.lastName + "\"" +
                ",\n\t\t\t\"Function\" : \"" + admin.function + "\"\n\t\t}", admin.toJSON());
    }
}

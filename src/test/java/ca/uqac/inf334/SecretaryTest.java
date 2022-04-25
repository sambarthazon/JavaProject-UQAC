package ca.uqac.inf334;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SecretaryTest {

    University uqac = new University("UQAC");
    University cegep = new University("CEGEP");

    Secretary secretary = new Secretary("1", "Secretary");

    @Test
    public void TestUniversity(){
        secretary.SetUniversity(uqac);
        assertEquals(uqac, secretary.university);
        assertTrue(uqac.secretaryList.contains(secretary));
        secretary.SetUniversity(cegep);
    }

    @Test
    public void TestToJSON(){
        assertEquals("\n\t\t{\n" +
                "\t\t\t\"Firstname\" : \"" + secretary.firstName + "\"" +
                ",\n\t\t\t\"Lastname\" : \"" + secretary.lastName + "\"" +
                ",\n\t\t\t\"Function\" : \"" + secretary.function + "\"\n\t\t}", secretary.toJSON());
    }
}

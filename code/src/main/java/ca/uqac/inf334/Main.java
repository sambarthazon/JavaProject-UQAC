package ca.uqac.inf334;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        /*
        /**
         * University
         *
        University UQAC = new University("UQAC");
        University CEGEP = new University("CEGEP");

        /**
         * Admin
         *
        Admin patrick = new Admin("Patoche", "Patrick");
        Admin seb = new Admin("Seboche", "Seb");
        Admin fred = new Admin("Fredoche", "Fred");
        UQAC.AddAdmin(patrick);
        UQAC.AddAdmin(seb);
        UQAC.AddAdmin(fred);

        /**
         * Secretary
         *
        Secretary claudette = new Secretary("Cloclo","Claudette");
        Secretary francoise = new Secretary("Françoise","Françoise");
        UQAC.AddSecretary(claudette);
        UQAC.AddSecretary(francoise);

        /**
         * Professor
         *
        Professor cedric = new Professor("Demongivert", "Cedric");
        Professor jalves = new Professor("Jalves", "Nicacio");
        Professor mireille = new Professor("Mireille", "Mirabelle");
        UQAC.AddProfessor(cedric);
        UQAC.AddProfessor(jalves);
        UQAC.AddProfessor(mireille);

        /**
         * Room
         *
        Room pooRoom = new Room(UQAC);
        UQAC.AddRoom(pooRoom);

        /**
         * POO course
         *
        Course poo = new Course("POO");
        poo.SetUniversity(UQAC);
        poo.SetProfessor(cedric);
        poo.SetRoom(pooRoom);

        /**
         * TWA course
         *
        Course twa = new Course("TWA");
        twa.SetUniversity(UQAC);
        twa.SetProfessor(jalves);

        /**
         * Drawing course
         *
        Course draw = new Course("Draw");
        draw.SetUniversity(CEGEP);
        draw.SetProfessor(mireille);

        /**
         * Info field
         *
        Field info = new Field("Informatique");
        info.SetUniversity(UQAC);
        info.AddCourse(poo);
        info.AddCourse(twa);

        /**
         * Art field
         *
        Field art = new Field("Art");
        art.SetUniversity(UQAC);
        art.AddCourse(draw);

        /**
         * Rugby sport
         *
        Sport rugby = new Sport("Rugby", UQAC);

        /**
         * Sam student
         *
        Student sam = new Student("BARTHAZON", "Sam", "22/11/02");
        sam.SetUniversity(UQAC);
        sam.SetField(info);
        sam.AddCourse(poo);

        /**
         * Victor student
         *
        Student victor = new Student("RIVET", "Victor", "90/28/19");
        victor.SetUniversity(CEGEP);
        victor.SetField(art);
        victor.AddSport(rugby);



        File file = new File("jsonFile.json");

        String data = UQAC.toJSON();

        try(FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            //convert string to byte array
            byte[] bytes = data.getBytes();
            //write byte array to file
            bos.write(bytes);
            bos.close();
            fos.close();
            System.out.print("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

         */
    }
}
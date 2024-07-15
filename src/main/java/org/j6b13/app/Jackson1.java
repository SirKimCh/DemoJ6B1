package org.j6b13.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.j6b13.bean.Contact;
import org.j6b13.bean.StudentJ;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class Jackson1 {
    public static void main(String[] args) {
        demo1();
        demo2();
    }

    public static void demo1() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(new File("src/main/resources/Json/StudentData.json"));
            if (rootNode.isArray()) {
                for (JsonNode studentNode : rootNode) {
                    System.out.println("Name: " + studentNode.get("name").asText());
                    System.out.println("Gender: " + (studentNode.get("gender").asBoolean() ? "Male" : "Female"));
                    System.out.println("Grade: " + studentNode.get("grade").asDouble());
                    System.out.println("Contact: ");
                    System.out.println("\tPhone: " + studentNode.get("contact").get("phone").asText());
                    System.out.println("\tEmail: " + studentNode.get("contact").get("email").asText());
                    System.out.println("Subjects: ");
                    for (JsonNode subject : studentNode.get("subjects")) {
                        System.out.println("\t" + subject.asText());
                    }
                    System.out.println("-------------------");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void demo2() {
        ObjectMapper mapper = new ObjectMapper();
        StudentJ student = new StudentJ();
        student.setName("Đây là name của sinh viên");
        student.setGender(true);
        student.setGrade(90.0);
        Contact contact = new Contact();
        contact.setPhone("123456789");
        contact.setEmail("kimchiman@gmail.com");
        student.setContact(contact);
        student.setSubjects(Arrays.asList("Math", "English", "Computer"));

        try {
            // Ghi đối tượng Student vào tệp JSON
            mapper.writeValue(new File("src/main/resources/Json/StudentWriteData.json"), student);
            System.out.println("Ghi thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

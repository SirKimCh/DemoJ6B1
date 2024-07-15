package org.j6b13.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentJ {
    private String name;
    private boolean gender;
    private double grade;
    private Contact contact;
    private List<String> subjects;
}

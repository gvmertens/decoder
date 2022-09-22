package br.com.mertens.ead.authuser.dtos;

import br.com.mertens.ead.authuser.enums.CourseLevel;
import br.com.mertens.ead.authuser.enums.CourseStatus;
import lombok.Data;

import java.util.UUID;

@Data
public class CourseDto {

    private UUID courseId;
    private String name;
    private String description;
    private String imageUrl;
    private CourseStatus courseStatus;
    private UUID userInstructor;
    private CourseLevel courseLevel;

}

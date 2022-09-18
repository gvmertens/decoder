package br.com.mertens.ead.course.course.dtos;

import br.com.mertens.ead.course.course.enums.CourseLevel;
import br.com.mertens.ead.course.course.enums.CourseStatus;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
public class CourseDto {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private String imageUrl;
    @NotNull
    private CourseStatus courseStatus;
    @NotNull
    private UUID userInstructor;
    @NotNull
    private CourseLevel courseLevel;
}

package br.com.mertens.ead.course.course.services;

import br.com.mertens.ead.course.course.models.CourseModel;
import br.com.mertens.ead.course.course.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface CourseService {
    void delete(CourseModel courseModel);

    CourseModel save(CourseModel courseModel);

    Optional<CourseModel> findById(UUID courseId);

    Page<CourseModel> findAll(Specification<CourseModel> spec, Pageable pageable);

    boolean existsByCourseAndUser(UUID courseId, UUID userId);

    void saveSubscriptionUserInCourse(UUID courseId, UUID userId);

    void saveSubscriptionUserInCourseAndSendNotification(CourseModel course, UserModel user);
}

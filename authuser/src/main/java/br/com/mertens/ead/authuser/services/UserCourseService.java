package br.com.mertens.ead.authuser.services;

import br.com.mertens.ead.authuser.models.UserCourseModel;
import br.com.mertens.ead.authuser.models.UserModel;

import java.util.UUID;

public interface UserCourseService {

    boolean existsByUserAndCourseId(UserModel userModel, UUID courseId);

    UserCourseModel save(UserCourseModel userCourseModel);
}

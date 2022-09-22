package br.com.mertens.ead.authuser.services.impl;

import br.com.mertens.ead.authuser.models.UserCourseModel;
import br.com.mertens.ead.authuser.models.UserModel;
import br.com.mertens.ead.authuser.repositories.UserCourseRepository;
import br.com.mertens.ead.authuser.services.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserCourseServiceImpl implements UserCourseService {

    @Autowired
    UserCourseRepository userCourseRepository;

    @Override
    public boolean existsByUserAndCourseId(UserModel userModel, UUID courseId) {
        return userCourseRepository.existsByUserAndCourseId(userModel, courseId);
    }

    @Override
    public UserCourseModel save(UserCourseModel userCourseModel) {
        return userCourseRepository.save(userCourseModel);
    }
}

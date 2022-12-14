package br.com.mertens.ead.authuser.services;

import br.com.mertens.ead.authuser.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface UserService {

    UserModel saveUser(UserModel userModel);

    UserModel save(UserModel userModel);

    UserModel updateUser(UserModel userModel);

    UserModel updatePassword(UserModel userModel);

    List<UserModel> findAll();

    Optional<UserModel> findById(UUID userID);

    void delete(UserModel userModel);

    void deleteUser(UserModel userModel);

     boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Page<UserModel> findAll(Specification<UserModel> spec, Pageable pageable);
}

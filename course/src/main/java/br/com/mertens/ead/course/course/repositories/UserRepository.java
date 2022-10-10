package br.com.mertens.ead.course.course.repositories;

import br.com.mertens.ead.course.course.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID>, JpaSpecificationExecutor<UserModel> {
}

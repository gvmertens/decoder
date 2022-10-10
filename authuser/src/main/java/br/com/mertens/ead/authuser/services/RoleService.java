package br.com.mertens.ead.authuser.services;

import br.com.mertens.ead.authuser.enums.RoleType;
import br.com.mertens.ead.authuser.models.RoleModel;

import java.util.Optional;

public interface RoleService {
    Optional<RoleModel> findByRoleName(RoleType roleType);
}

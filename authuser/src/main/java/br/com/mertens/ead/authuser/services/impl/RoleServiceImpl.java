package br.com.mertens.ead.authuser.services.impl;

import br.com.mertens.ead.authuser.enums.RoleType;
import br.com.mertens.ead.authuser.models.RoleModel;
import br.com.mertens.ead.authuser.repositories.RoleRepository;
import br.com.mertens.ead.authuser.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Optional<RoleModel> findByRoleName(RoleType roleType) {
        return roleRepository.findByRoleName(roleType);
    }
}
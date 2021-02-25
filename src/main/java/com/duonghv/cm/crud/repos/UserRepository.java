package com.duonghv.cm.crud.repos;

import com.duonghv.cm.crud.entities.PlatformUser;
import springboot.rest.repositories.BaseRepository;

public interface UserRepository extends BaseRepository<PlatformUser, Integer> {
    PlatformUser findOneByUsername(String username);
}

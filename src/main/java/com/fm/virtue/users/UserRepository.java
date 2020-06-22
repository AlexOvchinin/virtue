package com.fm.virtue.users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

public interface UserRepository extends CrudRepository<User, Long> {
}

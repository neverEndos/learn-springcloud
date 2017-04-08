package com.endos.repository;

import com.endos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Endos on 2017/4/8.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

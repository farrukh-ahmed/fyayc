package com.fyayc.Interview.repositories;

import com.fyayc.Interview.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    List<UserEntity> findUserEntitiesByIdIn(List<Integer> ids);

}

package ru.kdv.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kdv.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}

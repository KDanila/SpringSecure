package ru.kdv.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kdv.entity.Authority;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Long> {
}

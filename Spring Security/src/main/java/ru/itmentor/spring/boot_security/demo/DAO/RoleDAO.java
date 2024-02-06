package ru.itmentor.spring.boot_security.demo.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itmentor.spring.boot_security.demo.model.Role;


@Repository
@Transactional
public interface RoleDAO extends JpaRepository<Role, Long> {
}
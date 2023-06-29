package net.oguzkaankaradag.springbootrestfulwebservices.repository;

import net.oguzkaankaradag.springbootrestfulwebservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {



}

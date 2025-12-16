package com.techlab.pedidosnow.persistence;

import com.techlab.pedidosnow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

package com.simbirsoft.homework.repositories;

import com.simbirsoft.homework.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Поиск пользователя по логину.
     *
     * @param login логин пользователя.
     * @return пользователь.
     */
    Optional<User> findByLogin(String login);

}

package com.ns.qt.repositories;

/**
 * Created by Sergey_Samarkin on 12/7/2016.
 */
import com.ns.qt.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}

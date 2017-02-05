package com.ns.qt.repositories;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Sergey_Samarkin on 12/7/2016.
 */
import com.ns.qt.entities.User;

public interface UsersRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
    
    void delete(Long id);
    
    User save(User entity);

}

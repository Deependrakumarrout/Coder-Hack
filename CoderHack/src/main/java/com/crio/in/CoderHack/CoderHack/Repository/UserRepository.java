package com.crio.in.CoderHack.CoderHack.Repository;

import com.crio.in.CoderHack.CoderHack.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

package org.mustafa.aslan.repository;

import org.mustafa.aslan.entity.Address;
import org.mustafa.aslan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}

package com.ContactManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ContactManager.entity.ContactEntity;

@Repository
public interface AppRepository extends JpaRepository<ContactEntity, Long>{

}

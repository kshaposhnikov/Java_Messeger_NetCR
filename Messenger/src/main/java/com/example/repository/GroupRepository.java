package com.example.repository;

import com.example.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository  extends JpaRepository<Group,Integer> {

    public Group findGroupByName(String name);

}

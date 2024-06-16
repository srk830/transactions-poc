package org.example.persistence2.repository2;

import org.example.persistence2.entity2.Table2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Table2Repository extends JpaRepository<Table2, Integer> {
}
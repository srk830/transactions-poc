package org.example.persistence1.repository1;

import org.example.persistence1.entity1.Table1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Table1Repository extends JpaRepository<Table1, Integer> {
}
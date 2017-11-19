package org.simple.csv_db.repository;
import org.simple.csv_db.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Employee, Long> {

    
}

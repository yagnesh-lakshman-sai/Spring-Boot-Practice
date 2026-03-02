package in.smbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.smbs.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{

}

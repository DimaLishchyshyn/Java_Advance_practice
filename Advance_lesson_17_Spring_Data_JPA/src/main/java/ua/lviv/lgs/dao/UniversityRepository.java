package ua.lviv.lgs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.University;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long>, CrudRepository<University, Long> {
	
	List<University> findByAddressOfUniversity(String addressOfUniversity);
	
	List<University> findByLevelOfAccredetation(Integer levelOfAccredetation);

}
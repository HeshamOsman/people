package embl.recruitment.task.people.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import embl.recruitment.task.people.api.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

}

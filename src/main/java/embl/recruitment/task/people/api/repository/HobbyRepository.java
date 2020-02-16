package embl.recruitment.task.people.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import embl.recruitment.task.people.api.domain.Hobby;

@Repository
public interface HobbyRepository extends JpaRepository<Hobby, Long> {

}

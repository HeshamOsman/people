package embl.recruitment.task.people.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import embl.recruitment.task.people.api.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

	Role findBySlug(String roleSlug);
}

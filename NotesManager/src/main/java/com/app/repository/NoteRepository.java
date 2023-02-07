package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Note;
import com.app.pojos.User;

public interface NoteRepository extends JpaRepository<Note, Long> {
	List<Note> findByUser(User user);
	//@Query(value = "select new com.app.pojos.Employee(firstName,lastName) from Employee e where e.salary between ?1 and ?2")
	//@Modifying
	//@Query("update Employee e set e.salary=e.salary+?1 where e.department=?2 and e.joinDate < ?3")
}

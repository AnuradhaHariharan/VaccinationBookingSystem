package BookMyVax.BookMyVax.Repository;

import BookMyVax.BookMyVax.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PersonRepository extends JpaRepository<Person,Integer> {

  Person findByEmailId(String oldEmailid);


 // List<Person> getpersonTakenBothDoses();
}

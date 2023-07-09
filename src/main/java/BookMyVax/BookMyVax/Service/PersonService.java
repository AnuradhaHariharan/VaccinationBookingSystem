package BookMyVax.BookMyVax.Service;

import BookMyVax.BookMyVax.Entity.Person;
import BookMyVax.BookMyVax.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PersonService {
@Autowired
    PersonRepository personRepository;

    public Person addPerson(Person person) {
       Person personAdded=personRepository.save(person);
       return personAdded;
    }
}

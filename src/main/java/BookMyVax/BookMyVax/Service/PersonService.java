package BookMyVax.BookMyVax.Service;

import BookMyVax.BookMyVax.Dto.RequestDto.AddPersonRequestDto;
import BookMyVax.BookMyVax.Dto.ResponseDto.AddPersonResponseDto;
import BookMyVax.BookMyVax.Entity.Person;
import BookMyVax.BookMyVax.Exception.PersonNotFoundException;
import BookMyVax.BookMyVax.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PersonService {
@Autowired
    PersonRepository personRepository;

  /* public Person addPerson(Person person) {
       Person personAdded=personRepository.save(person);
       personAdded.setDoseTwoTaken(false);
       personAdded.setDoseOneTaken(false);
       return personAdded;

    }*/
    public AddPersonResponseDto addperson(AddPersonRequestDto addPersonRequestDto){
        Person person=new Person();
        person.setGender(addPersonRequestDto.getGender());
        person.setName(addPersonRequestDto.getName());
        person.setEmailId(addPersonRequestDto.getEmailId());
        person.setAge(addPersonRequestDto.getAge());
        person.setDoseOneTaken(false);
        person.setDoseTwoTaken(false);
        Person save = personRepository.save(person);
        AddPersonResponseDto addPersonResponseDto=new AddPersonResponseDto();
        addPersonResponseDto.setName(save.getName());
        addPersonResponseDto.setMessage("Person has been added successfully");
        return addPersonResponseDto;
    }

    public String updateEmail(String oldEmailId, String newEmailId) {
      Person person=personRepository.findByEmailId(oldEmailId);
            if(person==null){
                throw new PersonNotFoundException("Sorry email does not exist");
            }
            person.setEmailId(newEmailId);
            personRepository.save(person);
            return "Email has been updated";
    }

   /* public List<Person> getPersonTakenBothDoses() {
        List<Person>personList=personRepository.getpersonTakenBothDoses();
        if(personList==null){
            throw new PersonNotFoundException("Sorry no person has taken 2 doses");
        }
        return personList;
    }*/
}
;
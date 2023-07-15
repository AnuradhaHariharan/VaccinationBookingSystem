package BookMyVax.BookMyVax.Service;

import BookMyVax.BookMyVax.Dto.RequestDto.AddPersonRequestDto;
import BookMyVax.BookMyVax.Dto.ResponseDto.AddPersonResponseDto;
import BookMyVax.BookMyVax.Entity.Person;
import BookMyVax.BookMyVax.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

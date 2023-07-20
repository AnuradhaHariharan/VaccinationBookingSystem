package BookMyVax.BookMyVax.Service;

import BookMyVax.BookMyVax.Dto.RequestDto.BookDose1RequestDto;
import BookMyVax.BookMyVax.Dto.RequestDto.BookDose2RequestDto;
import BookMyVax.BookMyVax.Entity.Dose;
import BookMyVax.BookMyVax.Entity.Person;
import BookMyVax.BookMyVax.Enum.DoseType;
import BookMyVax.BookMyVax.Exception.DoseAlreadyTakenException;
import BookMyVax.BookMyVax.Exception.PersonNotFoundException;
import BookMyVax.BookMyVax.Exception.TakeDose1FirstException;
import BookMyVax.BookMyVax.Repository.DoseRepository;
import BookMyVax.BookMyVax.Repository.PersonRepository;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {
    @Autowired
    DoseRepository doseRepository;
    @Autowired
    PersonRepository personRepository;
   // public Dose getDose1(int personId,DoseType doseType) {
      //  Optional<Person>optionalPerson =personRepository.findById(personId);
        //if(!optionalPerson.isPresent()){
          //  throw new PersonNotFoundException("Invalid Person Id");
  //      }
  //    Person person1=optionalPerson.get();
  //      if(person1.isDoseOneTaken()){
   //         throw new DoseAlreadyTakenException("Dose 1 Already Taken");
       // }
   ////    Dose dose =new Dose();
    //    dose.setVaccinId(String.valueOf(UUID.randomUUID()));
  //      dose.setDoseType(doseType);
    //    dose.setPerson(person1);
    //    person1.setDoseOneTaken(true);
       // person1.getDoses().add(dose);
                /* //     Person savedPerson=personRepository.save(person1); */
     //   return savedPerson.getDoses().get(0);
   // }
   public Dose getDose1(BookDose1RequestDto bookDose1RequestDto) {
       Optional<Person>optionalPerson =personRepository.findById(bookDose1RequestDto.getId());
       if(!optionalPerson.isPresent()){
           throw new PersonNotFoundException("Invalid Person Id");
       }
       Person person1=optionalPerson.get();
       if(person1.isDoseOneTaken()){
           throw new DoseAlreadyTakenException("Dose 1 Already Taken");
       }
       Dose dose =new Dose();
       dose.setVaccinId(String.valueOf(UUID.randomUUID()));
       dose.setDoseType(bookDose1RequestDto.getDoseType());
       dose.setPerson(person1);
       person1.setDoseOneTaken(true);
       //person1.getDoses().add(dose); //since its bidirectional dont have to add child entity
       Person savedPerson=personRepository.save(person1);
       return savedPerson.getDoses().get(0);
   }

    public Dose getDose2(BookDose1RequestDto bookDose2RequestDto) {
        Optional<Person>optionalPerson2 =personRepository.findById(bookDose2RequestDto.getId());
        if(!optionalPerson2.isPresent()){
            throw new PersonNotFoundException("Invalid Person Id");
        }
        Person person=optionalPerson2.get();
        if(!person.isDoseOneTaken()){
            throw new TakeDose1FirstException("Take Dose 1 First");
        }
        Dose dose =new Dose();
        dose.setVaccinId(String.valueOf(UUID.randomUUID()));
        dose.setDoseType(bookDose2RequestDto.getDoseType());
        dose.setPerson(person);
        person.setDoseTwoTaken(true);
        //person1.getDoses().add(dose); //since its bidirectional dont have to add child entity
        Person savedPerson=personRepository.save(person);
        return savedPerson.getDoses().get(1);
    }
}

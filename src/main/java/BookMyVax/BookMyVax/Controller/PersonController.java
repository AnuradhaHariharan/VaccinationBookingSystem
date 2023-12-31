package BookMyVax.BookMyVax.Controller;


import BookMyVax.BookMyVax.Dto.RequestDto.AddPersonRequestDto;
import BookMyVax.BookMyVax.Dto.ResponseDto.AddPersonResponseDto;
import BookMyVax.BookMyVax.Entity.Person;
import BookMyVax.BookMyVax.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

   /* @PostMapping("/add_person")
    public ResponseEntity addPerson(@RequestBody Person person){
  try {
       Person personResponse = personService.addPerson(person);
       return new ResponseEntity(personResponse, HttpStatus.ACCEPTED);
   }catch (Exception e){
       return new ResponseEntity("Email Already Exists",HttpStatus.BAD_REQUEST);
   }
    }*/
    @PostMapping("/add_person")
    public ResponseEntity addPerson(@RequestBody AddPersonRequestDto addPersonRequestDto){
        try{
            AddPersonResponseDto personResponseDto=personService.addperson(addPersonRequestDto);
            return new ResponseEntity(personResponseDto,HttpStatus.ACCEPTED);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }
   @PutMapping("/update_email")
    public ResponseEntity updateEmail(@RequestParam("oldEmail")String oldEmailId,@RequestParam("newEmail")String newEmailId){
       try{
        String response=personService.updateEmail(oldEmailId,newEmailId);
        return new ResponseEntity(response,HttpStatus.ACCEPTED);}
       catch (Exception e){
           return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
    }
   /* @GetMapping("/person_taken_bothdose")
    public ResponseEntity listOfPeopleTakenBothDose(){
        try{
        List<Person>personTakenBothDoses=personService.getPersonTakenBothDoses();
        return new ResponseEntity(personTakenBothDoses,HttpStatus.ACCEPTED);
    }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }*/
}

package BookMyVax.BookMyVax.Controller;


import BookMyVax.BookMyVax.Dto.RequestDto.BookDose1RequestDto;
import BookMyVax.BookMyVax.Entity.Dose;
import BookMyVax.BookMyVax.Enum.DoseType;
import BookMyVax.BookMyVax.Service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dose")
public class DoseController {
    @Autowired
    DoseService doseService;

   // @PostMapping("/get_dose1")
    //public ResponseEntity getDose(@RequestParam("id")int personId, @RequestParam("dose_type")DoseType doseType) {
      //  try {
        //    Dose dose = doseService.getDose1(personId, doseType);
          // return new ResponseEntity(dose, HttpStatus.CREATED);
        //}catch(Exception e){
          // return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        //}
    @PostMapping("/get_dose1")
    public ResponseEntity getDose1(@RequestBody BookDose1RequestDto bookDose1RequestDto){
        try {
              Dose dose = doseService.getDose1(bookDose1RequestDto);
             return new ResponseEntity(dose, HttpStatus.CREATED);
            }
        catch(Exception e){
             return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
            }

    }
    }


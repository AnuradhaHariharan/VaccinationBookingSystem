package BookMyVax.BookMyVax.Controller;

import BookMyVax.BookMyVax.Dto.RequestDto.AppointmentBookingRequestDto;
import BookMyVax.BookMyVax.Dto.ResponseDto.AppointmentResponseDto;
import BookMyVax.BookMyVax.Entity.Appointments;
import BookMyVax.BookMyVax.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentController{
@Autowired
AppointmentService appointmentService;
@PostMapping("book_appointment")
    public ResponseEntity BookAppointment(@RequestBody AppointmentBookingRequestDto appointmentBookingRequestDto){
        try{
            AppointmentResponseDto appointmentResponseDto= appointmentService.BookAppointment(appointmentBookingRequestDto);
            return new ResponseEntity(appointmentResponseDto, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    }



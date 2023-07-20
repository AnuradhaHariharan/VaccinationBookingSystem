package BookMyVax.BookMyVax.Service;

import BookMyVax.BookMyVax.Dto.RequestDto.AppointmentBookingRequestDto;
import BookMyVax.BookMyVax.Dto.ResponseDto.AppointmentResponseDto;
import BookMyVax.BookMyVax.Dto.ResponseDto.CenterResponseDto;
import BookMyVax.BookMyVax.Entity.Appointments;
import BookMyVax.BookMyVax.Entity.Doctor;
import BookMyVax.BookMyVax.Entity.Person;
import BookMyVax.BookMyVax.Entity.VaccinationCenter;
import BookMyVax.BookMyVax.Exception.DoctorNotFoundException;
import BookMyVax.BookMyVax.Exception.PersonNotFoundException;
import BookMyVax.BookMyVax.Repository.AppointmentRepository;
import BookMyVax.BookMyVax.Repository.DoctorRepository;
import BookMyVax.BookMyVax.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    JavaMailSender javaMailSender;
    public AppointmentResponseDto BookAppointment(AppointmentBookingRequestDto appointmentBookingRequestDto) {
        Optional<Person> optionalPerson=personRepository.findById(appointmentBookingRequestDto.getPersonId());
        if(optionalPerson==null){
            throw new PersonNotFoundException("Invalid person Id");
        }
        Optional<Doctor>optionalDoctor=doctorRepository.findById(appointmentBookingRequestDto.getPersonId());
        if(optionalDoctor==null){
            throw new DoctorNotFoundException("Invalid Doctor Id");
        }
        Person person=optionalPerson.get();
        Doctor doctor=optionalDoctor.get();

        Appointments appointments=new Appointments();
        appointments.setAppointmentId(String.valueOf(UUID.randomUUID()));
        appointments.setDoctor(doctor);
        appointments.setPerson(person);
        Appointments savedAppointments=appointmentRepository.save(appointments);
        doctor.getAppointments().add(savedAppointments);
        person.getAppointments().add(savedAppointments);
       Doctor savedDoctor= doctorRepository.save(doctor);
        Person savedPerson=personRepository.save(person);


        VaccinationCenter center=savedDoctor.getVaccinationCenter();
        String message=savedPerson.getName()+" Your Appointment has been booked with Dr."+savedDoctor.getName()+".in "+center.getAddress()+" at "+appointments.getAppointmentDate()+" .Please be on time ";
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom("springbootprojectjava@gmail.com");
        simpleMailMessage.setTo(savedPerson.getEmailId());
        simpleMailMessage.setSubject("Vaccination Booking");
        simpleMailMessage.setText(message);
        javaMailSender.send(simpleMailMessage);


        CenterResponseDto centerResponseDto=new CenterResponseDto();
        centerResponseDto.setName(center.getName());
        centerResponseDto.setCenterType(center.getCenterType());
        centerResponseDto.setAddress(centerResponseDto.getAddress());

        AppointmentResponseDto appointmentResponseDto=new AppointmentResponseDto();
        appointmentResponseDto.setPersonName(savedPerson.getName());
        appointmentResponseDto.setDoctorName(savedDoctor.getName());
        appointmentResponseDto.setAppointmentId(savedAppointments.getAppointmentId());
        appointmentResponseDto.setDate(savedAppointments.getAppointmentDate());
        appointmentResponseDto.setCenterResponseDto(centerResponseDto);
  return appointmentResponseDto;


    }
}

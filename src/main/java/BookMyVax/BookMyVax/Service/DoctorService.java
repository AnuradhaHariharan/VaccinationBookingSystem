package BookMyVax.BookMyVax.Service;

import BookMyVax.BookMyVax.Dto.RequestDto.DoctorRequestDto;
import BookMyVax.BookMyVax.Dto.ResponseDto.CenterResponseDto;
import BookMyVax.BookMyVax.Dto.ResponseDto.DoctorResponseDto;
import BookMyVax.BookMyVax.Entity.Doctor;
import BookMyVax.BookMyVax.Entity.VaccinationCenter;
import BookMyVax.BookMyVax.Exception.CenterNotFoundException;
import BookMyVax.BookMyVax.Repository.DoseRepository;
import BookMyVax.BookMyVax.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
@Autowired
    DoseRepository doseRepository;
@Autowired
    VaccinationCenterRepository vaccinationCenterRepository;
    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) {
        Optional<VaccinationCenter> vaccinationCenter= vaccinationCenterRepository.findById(doctorRequestDto.getCenterId());
        if(vaccinationCenter.isEmpty()){
            throw new CenterNotFoundException("Center Not Found");
        }
        VaccinationCenter center=vaccinationCenter.get();
        Doctor doctor=new Doctor();
        doctor.setAge(doctorRequestDto.getAge());
        doctor.setName(doctorRequestDto.getName());
        doctor.setGender(doctorRequestDto.getGender());
        doctor.setEmailId(doctorRequestDto.getEmailId());
        doctor.setVaccinationCenter(center);
        center.getDoctor().add(doctor);  //to add doctor in the list in vaccinationcenter
        VaccinationCenter savedCenter=vaccinationCenterRepository.save(center);
        List<Doctor> doctorList=savedCenter.getDoctor();
        Doctor latestDoc=doctorList.get(doctorList.size()-1);
        DoctorResponseDto responseDto=new DoctorResponseDto();
        responseDto.setName(latestDoc.getName());
        responseDto.setMessage("Congrats!! You've been Registered ");
        CenterResponseDto centerResponseDto=new CenterResponseDto();
        centerResponseDto.setCenterType(savedCenter.getCenterType());
        centerResponseDto.setAddress(savedCenter.getAddress());
        centerResponseDto.setName(savedCenter.getName());
        responseDto.setCenterResponseDto(centerResponseDto);
        return responseDto;
    }
}

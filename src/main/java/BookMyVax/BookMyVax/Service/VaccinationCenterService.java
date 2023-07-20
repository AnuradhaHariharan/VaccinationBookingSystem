package BookMyVax.BookMyVax.Service;

import BookMyVax.BookMyVax.Dto.RequestDto.CenterRequestDto;
import BookMyVax.BookMyVax.Dto.ResponseDto.CenterResponseDto;
import BookMyVax.BookMyVax.Entity.VaccinationCenter;
import BookMyVax.BookMyVax.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterService {
@Autowired
    VaccinationCenterRepository centerRepository;
    public CenterResponseDto addCenter(CenterRequestDto centerRequestDto) {
        VaccinationCenter vaccinationCenter=new VaccinationCenter();
        vaccinationCenter.setAddress(centerRequestDto.getAddress());
        vaccinationCenter.setCenterType(centerRequestDto.getCenterType());
        vaccinationCenter.setName(centerRequestDto.getName());
      VaccinationCenter center= centerRepository.save(vaccinationCenter);
      CenterResponseDto centerResponseDto=new CenterResponseDto();
      centerResponseDto.setAddress(center.getAddress());
      centerResponseDto.setCenterType(center.getCenterType());
      centerResponseDto.setName(center.getName());
      return centerResponseDto;
    }
}

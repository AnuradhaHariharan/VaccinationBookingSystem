package BookMyVax.BookMyVax.Controller;

import BookMyVax.BookMyVax.Dto.RequestDto.CenterRequestDto;
import BookMyVax.BookMyVax.Dto.ResponseDto.CenterResponseDto;
import BookMyVax.BookMyVax.Service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/center")
public class VaccinationCenterController {
    @Autowired
    VaccinationCenterService vaccinationCenterService;
    @PostMapping("/add")
        public CenterResponseDto addCenter(@RequestBody CenterRequestDto centerRequestDto){
             CenterResponseDto centerResponseDto= vaccinationCenterService.addCenter(centerRequestDto);
             return centerResponseDto;
        }
}

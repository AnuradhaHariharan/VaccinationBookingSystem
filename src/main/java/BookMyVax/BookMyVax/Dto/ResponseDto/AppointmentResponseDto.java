package BookMyVax.BookMyVax.Dto.ResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppointmentResponseDto {
    String personName;
    String doctorName;
    String appointmentId;
    Date date;
    CenterResponseDto centerResponseDto;
}

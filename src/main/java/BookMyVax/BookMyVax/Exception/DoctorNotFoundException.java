package BookMyVax.BookMyVax.Exception;

public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException (String invalid_doctor_id) {
        super(invalid_doctor_id);
    }
}

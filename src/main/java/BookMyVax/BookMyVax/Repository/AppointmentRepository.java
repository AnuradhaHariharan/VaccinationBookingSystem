package BookMyVax.BookMyVax.Repository;

import BookMyVax.BookMyVax.Entity.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointments,Integer> {
}

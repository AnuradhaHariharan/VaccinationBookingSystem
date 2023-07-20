package BookMyVax.BookMyVax.Repository;

import BookMyVax.BookMyVax.Entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter,Integer> {
}

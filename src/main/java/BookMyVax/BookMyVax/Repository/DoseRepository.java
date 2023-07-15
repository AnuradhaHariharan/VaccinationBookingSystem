package BookMyVax.BookMyVax.Repository;

import BookMyVax.BookMyVax.Entity.Dose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoseRepository extends JpaRepository<Dose,Integer> {
}

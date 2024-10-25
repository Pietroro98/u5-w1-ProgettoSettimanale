package PietroRomano.u5d5.Repository;

import PietroRomano.u5d5.entites.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {
}

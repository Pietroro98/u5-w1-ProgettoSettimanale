package PietroRomano.u5d5.Repository;

import PietroRomano.u5d5.entites.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
}

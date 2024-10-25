package PietroRomano.u5d5.Repository;

import PietroRomano.u5d5.Enum.TipoPostazione;
import PietroRomano.u5d5.entites.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

    List<Postazione> findByTipoPostazioneAndEdificioCitta(TipoPostazione tipo, String Citta);
}

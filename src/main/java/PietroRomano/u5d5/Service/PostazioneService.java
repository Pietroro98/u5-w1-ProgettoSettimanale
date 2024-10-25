package PietroRomano.u5d5.Service;

import PietroRomano.u5d5.Enum.TipoPostazione;
import PietroRomano.u5d5.Repository.PostazioneRepository;
import PietroRomano.u5d5.entites.Postazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public Postazione save(Postazione postazione){
        return postazioneRepository.save(postazione);
    }

    public List<Postazione> findByTipoAndCitta(TipoPostazione tipo, String citta) {
        return postazioneRepository.findByTipoPostazioneAndEdificioCitta(tipo, citta);
    }


}

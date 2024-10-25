package PietroRomano.u5d5.Service;

import PietroRomano.u5d5.Repository.PrenotazioneRepository;
import PietroRomano.u5d5.entites.Prenotazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public Prenotazione save(Prenotazione prenotazione){
        return prenotazioneRepository.save(prenotazione);
    }
}

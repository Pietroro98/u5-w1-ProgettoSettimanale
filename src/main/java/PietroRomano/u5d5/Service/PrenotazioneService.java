package PietroRomano.u5d5.Service;

import PietroRomano.u5d5.Repository.PrenotazioneRepository;
import PietroRomano.u5d5.entites.Prenotazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public Prenotazione save(Prenotazione prenotazione){
        List<Prenotazione> prenotazioniPerData = prenotazioneRepository.findByPostazioneAndDataPrenotazione
                (prenotazione.getPostazione(), prenotazione.getDataPrenotazione());
        if (!prenotazioniPerData.isEmpty()) {
            throw new IllegalStateException("La postazione non è disponibile per questa data");
        }
        List<Prenotazione> prenotazioniUtentePerData = prenotazioneRepository.findByUtenteAndDataPrenotazione(prenotazione.getUtente(), prenotazione.getDataPrenotazione());
        if (!prenotazioniUtentePerData.isEmpty()) {
            throw new IllegalStateException("L'utente ha già una prenotazione per questa data");
        }

        return prenotazioneRepository.save(prenotazione);
    }
}

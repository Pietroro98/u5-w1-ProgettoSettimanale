package PietroRomano.u5d5;

import PietroRomano.u5d5.Enum.TipoPostazione;
import PietroRomano.u5d5.Service.EdificioService;
import PietroRomano.u5d5.Service.PostazioneService;
import PietroRomano.u5d5.Service.PrenotazioneService;
import PietroRomano.u5d5.Service.UtenteService;
import PietroRomano.u5d5.entites.Edificio;
import PietroRomano.u5d5.entites.Postazione;
import PietroRomano.u5d5.entites.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PrenotazioneRunner implements CommandLineRunner {

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private PrenotazioneService prenotazioneService;


    @Override
    public void run(String... args) throws Exception {

        // ------------EDIFICIO-------------------------
//        Edificio edificio = new Edificio();  //nel db ci sono 2 edifici..
//        edificio.setNome("Mediolanum Forum");
//        edificio.setIndirizzo("G. di vittorio");
//        edificio.setCitta("Assago");
//        edificioService.save(edificio);

//        // Postazione Openspace
//        Postazione postazione = new Postazione();
//        postazione.setCodiceUnivoco("PST234-567");   // PST, PSP ecc del codice univoco sarebbero l'abbreviazione del tipo postazione... XD
//        postazione.setDescrizione("Postazione vicino alla finestra");
//        postazione.setTipoPostazione(TipoPostazione.OPENSPACE);
//        postazione.setNumeroMassimoOccupanti(4);
//        postazione.setEdificio(edificio);
//        postazioneService.save(postazione);
//
//        // Postazione Privata
//        Postazione postazionePrivata = new Postazione();
//        postazionePrivata.setCodiceUnivoco("PSP111-222");
//        postazionePrivata.setDescrizione("Postazione in ufficio privato");
//        postazione.setTipoPostazione(TipoPostazione.PRIVATO);
//        postazione.setNumeroMassimoOccupanti(1);
//        postazione.setEdificio(edificio);
//        postazioneService.save(postazionePrivata);
//
//        // Postazione sala riunioni
//        Postazione postazioneSalaRiunioni = new Postazione();
//        postazioneSalaRiunioni.setCodiceUnivoco("PSSR333-444");
//        postazioneSalaRiunioni.setDescrizione("Postazione in sala riunioni");
//        postazioneSalaRiunioni.setTipoPostazione(TipoPostazione.SALA_RIUNIONI);
//        postazione.setNumeroMassimoOccupanti(15);
//        postazione.setEdificio(edificio);
//        postazioneService.save(postazioneSalaRiunioni);


//        // -----------UTENTE----------------------
//        Utente utente = new Utente();
//        utente.setUsername("MrDoris");
//        utente.setNomeCompleto("Ennio Doris");
//        utente.setEmail("ennio.doris@example.com");
//        utenteService.save(utente);
        // ho creato anche il mio utente Pietro



    }
}

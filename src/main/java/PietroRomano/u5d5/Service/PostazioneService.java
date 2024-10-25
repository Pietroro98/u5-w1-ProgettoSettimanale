package PietroRomano.u5d5.Service;

import PietroRomano.u5d5.Repository.PostazioneRepository;
import PietroRomano.u5d5.entites.Postazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public Postazione save(Postazione postazione){
        return postazioneRepository.save(postazione);
    }
}

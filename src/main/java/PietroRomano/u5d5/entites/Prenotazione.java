package PietroRomano.u5d5.entites;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;

    private LocalDate dataPrenotazione;

    @Column(nullable = false)
    private boolean prenotazioneLibera;

    public Prenotazione(Long id, Utente utente, LocalDate dataPrenotazione, Postazione postazione, boolean prenotazioneLibera) {
        this.id = id;
        this.utente = utente;
        this.dataPrenotazione = dataPrenotazione;
        this.postazione = postazione;
        this.prenotazioneLibera = prenotazioneLibera;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", utente=" + utente +
                ", postazione=" + postazione +
                ", dataPrenotazione=" + dataPrenotazione +
                ", prenotazioneLibera=" + prenotazioneLibera +
                '}';
    }
}

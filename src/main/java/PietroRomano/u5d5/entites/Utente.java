package PietroRomano.u5d5.entites;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String nomeCompleto;

    private String email;

    public Utente(Long id, String username, String nomeCompleto, String email) {
        this.id = id;
        this.username = username;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

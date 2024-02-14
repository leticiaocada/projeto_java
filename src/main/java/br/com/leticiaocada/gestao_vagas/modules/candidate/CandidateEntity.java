package br.com.leticiaocada.gestao_vagas.modules.candidate;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "candidate")
public class CandidateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    //@Column(name = "nome")
    private String name;

    @NotBlank()
    @Pattern(regexp = "\\S+", message = "username inválido")
    private String username;

    @Email(message = "Inserir email válido")
    private String email;

    @Length(min = 10, max = 100)
    private String password;
    private String description;
    private String curriculo;

    @CreationTimestamp
    private LocalDateTime createdAt;
}

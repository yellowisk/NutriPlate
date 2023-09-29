package br.edu.ifsp.dsw3.nutriplate.model.domain;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", nullable = false)
    private UUID id;

    @Column(name = "occupation", nullable = false)
    @Enumerated(EnumType.STRING)
    private Occupation occupation;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "promptuary", nullable = false, unique = true)
    private String promptuary;

    @Column(name = "password", nullable = false)
    private String password;

    public User(UUID id, Occupation occupation, String username, String promptuary, String password) {
        this.id = id;
        this.occupation = occupation;
        this.username = username;
        this.promptuary = promptuary;
        this.password = password;
    }

    public User(Occupation occupation, String username, String promptuary, String password) {
        this.occupation = occupation;
        this.username = username;
        this.promptuary = promptuary;
        this.password = password;
    }

    public User() {

    }

    public static User createFromRequest(Occupation occupation, String username, String promptuary, String password) {
        return new User(occupation, username, promptuary, password);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPromptuary() {
        return promptuary;
    }

    public void setPromptuary(String promptuary) {
        this.promptuary = promptuary;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.br.Idespair.MoviesAPIWithSQL.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "reviews")
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long review_id;
    private String body;
    private LocalDateTime created;
    private LocalDateTime updated;
    @ManyToOne
    @JoinColumn(name = "imdbId", nullable = false)
    private Movie movie;

    public Review(String body, LocalDateTime created, LocalDateTime updated) {
        this.body = body;
        this.created = created;
        this.updated = updated;
    }
}

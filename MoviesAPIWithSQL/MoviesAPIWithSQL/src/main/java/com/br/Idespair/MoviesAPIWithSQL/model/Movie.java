package com.br.Idespair.MoviesAPIWithSQL.model;

import jakarta.persistence.*;
;
import lombok.Data;
import org.springframework.data.annotation.Reference;


import java.util.List;
@Entity
@Data
@Table(name = "movies")
public class Movie {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "imdbid")
        private String imdbId;
        private String title;
        @Column(name = "releasedate")
        private String releaseDate;
        @Column(name = "trailerlink")
        private String trailerLink;
        private String poster;
        private List<String> genres;
        private List<String> backdrops;
        //@OneToMany(mappedBy = "movie")
        //private List<Review> reviews;

        public Movie(String imdbId, String title, String releaseDate, String trailerLink, String poster, List<String> genres, List<String> backdrops) {
                this.imdbId = imdbId;
                this.title = title;
                this.releaseDate = releaseDate;
                this.trailerLink = trailerLink;
                this.poster = poster;
                this.genres = genres;
                this.backdrops = backdrops;
        }

        public Movie(){}
}

package dev.review.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data // Lombox tag that takes care of all getters and setters.
@AllArgsConstructor // Creates a constructor with all arguments.
@NoArgsConstructor // Creates a constructor with no arguments.
public class Movie {
  @Id
  private ObjectId id;
  private String imdbId;
  private String title;
  private String releaseDate;
  private String trailerLink;
  private String poster;
  private List<String> backdrops;
  private List<String> genres;

  // This will cause mongo to store only review ids and actual reviews will be stored as
  // a separate collection.
  @DocumentReference // Manual reference relationship.
  private List<Review> reviews;

  public Movie(String imdbId, String title, String releaseDate, String trailerLink,
               String poster, List<String> backdrops, List<String> genres) {
    this.imdbId = imdbId;
    this.title = title;
    this.releaseDate = releaseDate;
    this.trailerLink = trailerLink;
    this.poster = poster;
    this.backdrops = backdrops;
    this.genres = genres;
  }
}

@Entity
@Table(name = "movies")
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long movieId;
    
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    
    @Column(name = "genre", length = 50)
    private String genre;
    
    @Column(name = "release_year")
    private Integer releaseYear;
    
    @Column(name = "director", length = 100)
    private String director;
    
    @Column(name = "description", length = 1000)
    private String description;
    
    // Ek movie par multiple reviews ho sakte hain
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews = new ArrayList<>();
    
    // Constructors
    public Movie() {}
    
    public Movie(String title, String genre, Integer releaseYear, String director) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.director = director;
    }
    
    // Getters and Setters
    public Long getMovieId() { return movieId; }
    public void setMovieId(Long movieId) { this.movieId = movieId; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    
    public Integer getReleaseYear() { return releaseYear; }
    public void setReleaseYear(Integer releaseYear) { this.releaseYear = releaseYear; }
    
    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public List<Review> getReviews() { return reviews; }
    public void setReviews(List<Review> reviews) { this.reviews = reviews; }
    
    // Helper method
    public void addReview(Review review) {
        reviews.add(review);
        review.setMovie(this);
    }
    
    // Average rating calculate karne ka method
    public Double getAverageRating() {
        if (reviews == null || reviews.isEmpty()) {
            return 0.0;
        }
        return reviews.stream()
                .mapToDouble(Review::getRating)
                .average()
                .orElse(0.0);
    }
}

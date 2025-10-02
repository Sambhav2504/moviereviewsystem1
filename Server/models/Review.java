@Entity
@Table(name = "reviews", 
       uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "movie_id"}))
// Ek user ek movie par ek hi review likh sakta hai
public class Review {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;
    
    // Many-to-One relationship with User
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    // Many-to-One relationship with Movie
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
    
    @Column(name = "review_text", length = 2000)
    private String reviewText;
    
    @Column(name = "rating", nullable = false)
    private Integer rating; // 1-5 stars
    
    @Column(name = "review_date")
    @Temporal(TemporalType.TIMESTAMP) // Date aur time dono
    private Date reviewDate;
    
    @Column(name = "is_approved")
    private Boolean isApproved = true;
    
    // Constructors
    public Review() {}
    
    public Review(User user, Movie movie, String reviewText, Integer rating) {
        this.user = user;
        this.movie = movie;
        this.reviewText = reviewText;
        this.rating = rating;
        this.reviewDate = new Date();
        this.isApproved = true;
    }
    
    // Getters and Setters
    public Long getReviewId() { return reviewId; }
    public void setReviewId(Long reviewId) { this.reviewId = reviewId; }
    
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    
    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }
    
    public String getReviewText() { return reviewText; }
    public void setReviewText(String reviewText) { this.reviewText = reviewText; }
    
    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { 
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        this.rating = rating; 
    }
    
    public Date getReviewDate() { return reviewDate; }
    public void setReviewDate(Date reviewDate) { this.reviewDate = reviewDate; }
    
    public Boolean getIsApproved() { return isApproved; }
    public void setIsApproved(Boolean isApproved) { this.isApproved = isApproved; }
}





@Entity
@Table(name = "users") // Database mein table ka name 'users' hoga
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    @Column(name = "user_id")
    private Long userId;
    
    @Column(name = "username", unique = true, nullable = false, length = 50)
    private String username;
    
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    
    @Column(name = "join_date")
    @Temporal(TemporalType.DATE) // Sirf date store karega (without time)
    private Date joinDate;
    
    // Ek user multiple reviews likh sakta hai - ONE-TO-MANY relationship
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews = new ArrayList<>();
    
    // Constructors
    public User() {}
    
    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.joinDate = new Date();
    }
    
    // Getters and Setters
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public Date getJoinDate() { return joinDate; }
    public void setJoinDate(Date joinDate) { this.joinDate = joinDate; }
    
    public List<Review> getReviews() { return reviews; }
    public void setReviews(List<Review> reviews) { this.reviews = reviews; }
    
    // Helper method - Review add karne ke liye
    public void addReview(Review review) {
        reviews.add(review);
        review.setUser(this);
    }
}

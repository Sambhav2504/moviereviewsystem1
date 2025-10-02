package com.example.dao;

import com.example.models.Review;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import java.util.List;

public class ReviewDAO {
    // Create (Save) a Review
    public void saveReview(Review review) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(review);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Read (Get) Reviews by User ID
    public List<Review> getReviewsByUser(int userId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Review> query = session.createQuery("FROM Review WHERE user.userId = :userId", Review.class);
            query.setParameter("userId", userId);
            return query.getResultList();
        } finally {
            session.close();
        }
    }

    // Update a Review
    public void updateReview(Review review) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge(review);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Delete a Review
    public void deleteReview(int reviewId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Review review = session.get(Review.class, reviewId);
            if (review != null) session.remove(review);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}

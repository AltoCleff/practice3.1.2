package my.altocleff.practice312.dao;


import my.altocleff.practice312.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}

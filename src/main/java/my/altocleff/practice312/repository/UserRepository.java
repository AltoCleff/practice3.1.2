package my.altocleff.practice312.repository;


import my.altocleff.practice312.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

package kodilla.com.good.patterns.challenges.food2door;

import kodilla.com.good.patterns.challenges.productorderservice.User;

import java.time.LocalDateTime;

public interface OrderRepository {

    boolean createOrder(Producer producer, Product product, LocalDateTime dateOfOrder);

}

package kodilla.com.good.patterns.challenges.productorderservice;

import java.time.LocalDateTime;

public interface OrderRepository {

    boolean createOrder(User user, LocalDateTime dateOfOrder, Product product);

}

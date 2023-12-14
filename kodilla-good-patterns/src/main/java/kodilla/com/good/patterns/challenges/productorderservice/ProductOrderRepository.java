package kodilla.com.good.patterns.challenges.productorderservice;

import java.time.LocalDateTime;

public class ProductOrderRepository implements OrderRepository{

    @Override
    public boolean createOrder(User user, LocalDateTime dateOfOrder, Product product) {
        return true;
    }
}

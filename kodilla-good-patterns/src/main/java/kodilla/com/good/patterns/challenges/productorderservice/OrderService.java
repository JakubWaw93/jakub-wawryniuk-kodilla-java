package kodilla.com.good.patterns.challenges.productorderservice;

import java.time.LocalDateTime;

public interface OrderService {

    public boolean sell(User user, LocalDateTime dateOfOrder, Product product);


}

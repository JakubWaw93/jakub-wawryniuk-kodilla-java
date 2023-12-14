package kodilla.com.good.patterns.challenges.productorderservice;

import java.time.LocalDateTime;

public class ProductOrderService implements OrderService {

    public boolean sell( final User user, final LocalDateTime dateOfOrder, final Product product) {
        System.out.println("Selling " + product + " to: " + user.getName() + user.getSurname()
                + ". Date: " + dateOfOrder.toString());

        return true;
    }

}

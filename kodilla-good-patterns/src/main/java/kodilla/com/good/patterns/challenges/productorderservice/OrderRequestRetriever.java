package kodilla.com.good.patterns.challenges.productorderservice;

import java.time.LocalDateTime;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        User user = new User("Jan", "Kowalski");
        Product product = new Product("Toothbrush", 2);

        LocalDateTime dateOfOrder = LocalDateTime.of(2023, 12, 14, 17, 1);

        return new OrderRequest(user, dateOfOrder, product);
    }

}

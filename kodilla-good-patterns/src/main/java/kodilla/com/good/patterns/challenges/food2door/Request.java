package kodilla.com.good.patterns.challenges.food2door;

import java.time.LocalDateTime;

public class Request {

    private Producer producer;
    private Product product;
    private LocalDateTime dateOfRequest;

    public Request(Producer producer, Product product, LocalDateTime dateOfRequest) {
        this.producer = producer;
        this.product = product;
        this.dateOfRequest = dateOfRequest;
    }

    public Producer getProducer() {
        return producer;
    }

    public Product getProduct() {
        return product;
    }

    public LocalDateTime getDateOfRequest() {
        return dateOfRequest;
    }
}

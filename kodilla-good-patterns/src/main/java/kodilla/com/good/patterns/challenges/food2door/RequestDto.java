package kodilla.com.good.patterns.challenges.food2door;

public class RequestDto {

    private final Producer producer;
    private final boolean isBought;

    public RequestDto(Producer producer, boolean isBought) {
        this.producer = producer;
        this.isBought = isBought;
    }

    public Producer getProducer() {
        return producer;
    }

    public boolean isBought() {
        return isBought;
    }
}

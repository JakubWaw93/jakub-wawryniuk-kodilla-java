package kodilla.com.good.patterns.challenges.productorderservice;

public class OrderDto {

    private User user;
    private boolean isSold;

    public OrderDto(User user, boolean isSold) {
        this.user = user;
        this.isSold = isSold;
    }

    public User getUser() {
        return user;
    }

    public boolean isSold() {
        return isSold;
    }
}

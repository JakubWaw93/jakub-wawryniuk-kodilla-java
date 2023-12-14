package kodilla.com.good.patterns.challenges.productorderservice;

public class OrderDto {

    private User user;
    private boolean isSold;

    public OrderDto(User user, boolean isRented) {
        this.user = user;
        this.isSold = isRented;
    }

    public User getUser() {
        return user;
    }

    public boolean isSold() {
        return isSold;
    }
}

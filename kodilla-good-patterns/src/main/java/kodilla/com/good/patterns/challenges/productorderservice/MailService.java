package kodilla.com.good.patterns.challenges.productorderservice;

public class MailService implements InformationService{

    @Override
    public void inform(User user) {
        System.out.println("You have made an order.");

    }
}

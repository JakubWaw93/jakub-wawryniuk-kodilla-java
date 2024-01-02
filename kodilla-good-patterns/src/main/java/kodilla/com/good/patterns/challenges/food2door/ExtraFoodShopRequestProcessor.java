package kodilla.com.good.patterns.challenges.food2door;

public class ExtraFoodShopRequestProcessor extends RequestProcessor {

    public ExtraFoodShopRequestProcessor(InformationService informationService, OrderRepository orderRepository, OrderService orderService) {
        super(informationService, orderRepository, orderService);
    }

    @Override
    public RequestDto process(Request request) {
        //individual process for making request from this supplier
        return null;
    }
}

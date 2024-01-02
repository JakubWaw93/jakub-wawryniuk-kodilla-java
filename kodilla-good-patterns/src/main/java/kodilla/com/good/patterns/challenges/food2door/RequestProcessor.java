package kodilla.com.good.patterns.challenges.food2door;

import kodilla.com.good.patterns.challenges.productorderservice.OrderDto;

public abstract class RequestProcessor {

    private final InformationService informationService;
    private final OrderRepository orderRepository;
    private final OrderService orderService;

    public RequestProcessor(InformationService informationService, OrderRepository orderRepository, OrderService orderService) {
        this.informationService = informationService;
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    public InformationService getInformationService() {
        return informationService;
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public RequestDto process(Request request){
        boolean isBought = orderService.buy(request.getProducer(), request.getProduct(), request.getDateOfRequest());
        if (isBought) {
            informationService.inform(request.getProducer());
            orderRepository.createOrder(request.getProducer(), request.getProduct(), request.getDateOfRequest());
            return new RequestDto(request.getProducer(), true);
        } else {
            return new RequestDto(request.getProducer(), false);
        }

    }
}

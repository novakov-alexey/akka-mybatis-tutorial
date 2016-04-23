package tutorial.gateway;

import akka.actor.ActorRef;
import org.springframework.stereotype.Service;
import tutorial.om.Order;
import tutorial.om.message.CompleteBatch;
import tutorial.om.message.NewOrder;

import javax.inject.Inject;
import javax.inject.Named;

@Service
public class OrderGateway {
  @Inject
  @Named("OrderProcessor")
  private ActorRef orderProcessor;

  public Order placeOrder() {
    Order order = OrderUtil.generateRandomOrder();
    orderProcessor.tell(new NewOrder(order), ActorRef.noSender());
    return order;
  }

  public void completeBatch() {
    orderProcessor.tell(new CompleteBatch(), ActorRef.noSender());
  }
}

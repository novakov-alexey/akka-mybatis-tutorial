package tutorial.om;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//actually, this class should be immutable in production
public final class Order implements Serializable {
  private long orderId = -1;
  private LocalDateTime executionDate;
  private OrderType orderType;
  private BigDecimal executionPrice;
  private String symbol;
  private int userId;
  private int quantity;
  private List<Execution> executions = new ArrayList<>();

  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }

  public LocalDateTime getExecutionDate() {
    return executionDate;
  }

  public void setExecutionDate(LocalDateTime executionDate) {
    this.executionDate = executionDate;
  }

  public OrderType getOrderType() {
    return orderType;
  }

  public void setOrderType(OrderType orderType) {
    this.orderType = orderType;
  }

  public BigDecimal getExecutionPrice() {
    return executionPrice;
  }

  public void setExecutionPrice(BigDecimal executionPrice) {
    this.executionPrice = executionPrice;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Order order = (Order) o;
    return orderId == order.orderId &&
            userId == order.userId &&
            Objects.equal(executionDate, order.executionDate) &&
            orderType == order.orderType &&
            Objects.equal(executionPrice, order.executionPrice) &&
            Objects.equal(symbol, order.symbol);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(orderId, executionDate, orderType, executionPrice, symbol, userId);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
            .add("orderId", orderId)
            .add("executionDate", executionDate)
            .add("orderType", orderType)
            .add("executionPrice", executionPrice)
            .add("symbol", symbol)
            .add("userId", userId)
            .add("quantity", quantity)
            .add("executions", executions)
            .toString();
  }

  public List<Execution> getExecutions() {
    return executions;
  }

  public void setExecutions(List<Execution> executions) {
    this.executions = executions;
  }
}

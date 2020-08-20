package shop;

public class Shipped extends AbstractEvent {

    private Long id;
    private Double orderId;
    private String status;

    public Shipped(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Double getOrderId() {
        return orderId;
    }

    public void setOrderId(Double orderId) {
        this.orderId = orderId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

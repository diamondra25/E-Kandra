package com.example.ikandra.Model;

import java.io.Serializable;
import java.util.Objects;

public class OrderId implements Serializable {
    private Long client;
    private Long offer;

    public OrderId() {}
    public OrderId(Long client, Long offer) {
        this.client = client;
        this.offer = offer;
    }

    public Long getClient() {
        return client;
    }
    public void setClient(Long client) {
        this.client = client;
    }

    public Long getOffer() {
        return offer;
    }
    public void setOffer(Long offer) {
        this.offer = offer;
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderId)) return false;
        OrderId that = (OrderId) o;
        return Objects.equals(client, that.client) &&
               Objects.equals(offer, that.offer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, offer);
    }
}

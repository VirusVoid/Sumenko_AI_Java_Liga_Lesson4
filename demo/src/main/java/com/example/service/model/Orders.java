package com.example.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Orders {

    private int orderId;
    private String name;
    private Integer price;

  /*  @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        return result;
    }*/

    /*   @Override
       public boolean equals(Object obj) {
           if (this == obj)
               return true;
           if (obj == null)
               return false;
           if (getClass() != obj.getClass())
               return false;
           Orders other = (Orders) obj;

           if (orderId == null) {
               if (other.orderId != null)
                   return false;
           } else if (!orderId.equals(other.orderId))
               return false;

           if (name == null) {
               if (other.name != null)
                   return false;
           } else if (!name.equals(other.name))
               return false;

           if (price == null) {
               if (other.price != null)
                   return false;
           } else if (!price.equals(other.price))
               return false;

           return true;
       }
   */
    @Override
    public String toString() {
        return "Orders{" +
                "order_id=" + orderId +
                ", name='" + name + '\'' +
                ", price='" + price +
                '}';
    }
}

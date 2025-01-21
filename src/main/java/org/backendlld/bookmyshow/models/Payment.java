package org.backendlld.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Payment extends BaseModel{
    private String paymentId;
    private PaymentState status;
    private String paymentMode;
    private Double amount;
    private Date paymentDate;
}

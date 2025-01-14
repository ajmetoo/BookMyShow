package org.backendlld.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Payment extends BaseModel{
    private String paymentId;
    private String paymentStatus;
    private String paymentMode;
    private String paymentAmount;
    private String paymentDate;
}

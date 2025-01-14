package org.backendlld.bookmyshow.models;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseModel {
    @Id
    private int id;
    private Date createdAt;
    private Date updatedAt;
}

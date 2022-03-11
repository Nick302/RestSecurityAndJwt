package net.proselyte.jwtappdemo.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;


@MappedSuperclass //для него не нужно отдельной таблицы , говорим JPA
@Data
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate // дата создания
    @Column(name = "created")
    private Date created;

    @LastModifiedDate // дата обновления
    @Column(name = "updated")
    private Date updated;

    @Enumerated(EnumType.STRING) // что это енам стринговый
    @Column(name = "status")
    private Status status;
}

package com.product.product.config.exception;

import org.hibernate.annotations.Type;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;


@MappedSuperclass
public class EntityWithUUID {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private UUID id;

    public EntityWithUUID() {
        this.id = UUID.randomUUID();
    }
}

package com.main.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "dscp")
    private String dscp;

    @Column(name = "isdone")
    private boolean isDone;
}

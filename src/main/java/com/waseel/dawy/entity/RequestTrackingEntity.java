package com.waseel.dawy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "request_tracking")
public class RequestTrackingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sourceAppId;
    private String methodType;
    private String URL;
    @Lob
    private String request;
    @Lob
    private String response;
    private String remoteAddress;
}

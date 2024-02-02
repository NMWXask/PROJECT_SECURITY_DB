package com.xask.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Document {
    @Id
    @Column(name = "security_id")
    private long securityId;
    @Column(name = "health_permit")
    private LocalDate HealthPermit;
    @Column(name = "knowledge_permit")
    private LocalDate knowledgePermit;
    @Column(name = "weapon_permit")
    private LocalDate weaponPermit;
}

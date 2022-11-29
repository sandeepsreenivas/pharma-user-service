package com.pharmabms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "pharma_user_id")
public class PharmaUserId {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "current_user_id")
    private Integer currentUserId;

}

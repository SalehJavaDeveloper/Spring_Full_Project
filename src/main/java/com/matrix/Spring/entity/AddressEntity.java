package com.matrix.Spring.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
@Data
@Getter
@Setter
//@ToString(exclude = "studentEntity")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressEntity {
    @Id
    private Integer id;

    private String city;

    private String street;

    @Column(name = "POST_NUMBER")
    private Integer postNumber;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private StudentEntity studentEntity;
}

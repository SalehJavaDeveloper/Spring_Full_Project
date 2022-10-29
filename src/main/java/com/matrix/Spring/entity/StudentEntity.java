package com.matrix.Spring.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "STUDENT")
@Builder
@ToString(exclude = "addressEntity")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {
    @Id
    private Integer id;

    private String name;

    private String surname;

    private Integer age;

    @OneToOne(mappedBy = "studentEntity",cascade = CascadeType.ALL)
    private AddressEntity addressEntity;
}

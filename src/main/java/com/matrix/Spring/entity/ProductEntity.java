package com.matrix.Spring.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "home_elements")
@Getter
@Setter
public class ProductEntity {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(name = "home_latest")
    private String homeLatest;
    @Column(name = "home_view")
    private String homeView;
    @Column(name = "home_about")
    private String homeAbout;
    @Column(name = "home_about_question")
    private String homeAboutQuestion;
    @Column(name = "home_about_description")
    private String homeAboutDescription;
    @Column(name = "home_about_line1")
    private String homeAboutLine1;
    @Column(name = "home_about_line2")
    private String homeAboutLine2;
    @Column(name = "home_about_line3")
    private String homeAboutLine3;
    @Column(name = "home_about_line4")
    private String homeAboutLine4;
    @Column(name = "home_about_line5")
    private String homeAboutLine5;
    @Column(name = "home_creative")
    private String homeCreative;
    @Column(name = "home_creative_description")
    private String homeCreativeDescription;
    @Column(name = "home_score")
    private Integer homeScore;
}

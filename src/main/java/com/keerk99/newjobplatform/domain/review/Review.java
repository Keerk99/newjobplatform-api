package com.keerk99.newjobplatform.domain.review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.keerk99.newjobplatform.domain.company.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "review")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Double rating;

    @JsonIgnore
    @ManyToOne
    private Company company;
}

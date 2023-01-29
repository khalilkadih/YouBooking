package com.youcode.youbooking.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Hotels implements Serializable {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String adress;

    @ManyToOne
    @JoinColumn()
    private Ville ville;
    //if you want all room in hotel remove @JsonBackReference
    @JsonBackReference

    @OneToMany(fetch = FetchType.LAZY)
    private List<Rooms> rooms= new ArrayList<>();
    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Users manager;

   /* @Column(name = "image", length = 1000)
    private byte[] image;*/

}

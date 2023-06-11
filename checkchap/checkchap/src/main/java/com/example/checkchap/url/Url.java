package com.example.checkchap.url;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "urls")
@Entity(name = "urls")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Url{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;
}
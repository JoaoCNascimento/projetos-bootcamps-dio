package com.dio.live.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_JORNADA_TRABALHO")
public class JornadaTrabalho implements Serializable {
    @Id
    @GeneratedValue()
    private long id;
    private String descricao;
}

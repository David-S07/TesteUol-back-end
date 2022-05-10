package com.teste.uol.model;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Entity
@Table(name = "incidentes")
public class Incidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incidente_id;
    private String nome;
    private LocalDate data;

    public Incidente() {
    }

    public Long getIncidente_id() {
        return incidente_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        LocalDate dataAtual = LocalDate.now();

        if (data == null && incidente_id == 1) {
            dataAtual = LocalDate.now().minusDays(1);
            if (dataAtual.getDayOfWeek() == DayOfWeek.SUNDAY) {
                dataAtual = dataAtual.plusDays(2);
            } else if (dataAtual.getDayOfWeek() == DayOfWeek.SATURDAY) {
                dataAtual = dataAtual.plusDays(2);
            }
            data = dataAtual;
        } else if (data == null && incidente_id == 2) {
            dataAtual = LocalDate.now();
            if (dataAtual.getDayOfWeek() == DayOfWeek.SUNDAY) {
                dataAtual = dataAtual.plusDays(2);
            } else if (dataAtual.getDayOfWeek() == DayOfWeek.SATURDAY) {
                dataAtual = dataAtual.plusDays(2);
            }
            data = dataAtual;
        } else if (data == null && incidente_id > 2) {
            dataAtual = LocalDate.now().plusDays(incidente_id - 2);
            if (dataAtual.getDayOfWeek() == DayOfWeek.SUNDAY || dataAtual.getDayOfWeek() == DayOfWeek.SATURDAY) {
                dataAtual = dataAtual.plusDays(2);
            } else if (dataAtual.getDayOfWeek() == DayOfWeek.MONDAY || dataAtual.getDayOfWeek() == DayOfWeek.TUESDAY) {
                dataAtual = dataAtual.plusDays(2);
            }
            data = dataAtual;
        }
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}

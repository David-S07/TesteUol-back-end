package com.teste.uol.dto;

import com.teste.uol.model.Incidente;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class IncidenteDto {

    private String nome;
    private String data;

    public IncidenteDto(Incidente incidente) {
        this.nome = incidente.getNome();
        this.data = formatDate(incidente.getData());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    private String formatDate(LocalDate data) {

        String typeOfDay = " ";

        int diaDaSemana = data.getDayOfWeek().getValue();
        String diaSemana = DayOfWeek.of(diaDaSemana).toString();

        if (diaSemana.equals("SUNDAY") || diaSemana.equals("SATURDAY")) {
            typeOfDay = "FECHADO";
            return "Fim de semana";
        } else if ("MONDAY".equals(diaSemana)) {
            typeOfDay = "Segunda-Feira";
        } else if ("TUESDAY".equals(diaSemana)) {
            typeOfDay = "Terça-Feira";
        } else if ("WEDNESDAY".equals(diaSemana)) {
            typeOfDay = "Quarta-Feira";
        } else if ("THURSDAY".equals(diaSemana)) {
            typeOfDay = "Quinta-Feira";
        } else if ("FRIDAY".equals(diaSemana)) {
            typeOfDay = "Sexta-Feira";
        } else {
            throw new IllegalArgumentException("Dia da semana invalido ");
        }
        int diaDoMes = data.getDayOfMonth();
        int mes = data.getMonthValue();
        int ano = data.getYear();
        String formatDia = " ";
        String formatMes = "0";

        if (diaDoMes < 10) {
            formatDia = "0" + diaDoMes;
        } else {
            formatDia = "" + diaDoMes;
        }
        if (mes < 10) {
            formatMes = "0" + mes;
        } else {
            formatMes = "" + mes;
        }
        String dateFormat = typeOfDay + " (" + formatDia + "/" + formatMes + "/" + ano + ")";

        return dateFormat;
    }
}

package com.example.techsupportapi.dto;

/**
 * Objeto de Transferencia de Datos (DTO) para actualizar la persona que atiende
 * una solicitud.
 */
public class UpdateAttendedByDTO {
    private String attendedBy;

    public String getAttendedBy() {
        return attendedBy;
    }

    public void setAttendedBy(String attendedBy) {
        this.attendedBy = attendedBy;
    }
}

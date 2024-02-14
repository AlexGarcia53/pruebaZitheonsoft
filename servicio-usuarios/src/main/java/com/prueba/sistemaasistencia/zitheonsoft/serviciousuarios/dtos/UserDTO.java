package com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.dtos;

import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.enums.WorkStatus;

public class UserDTO {
    private String fullname;
    private WorkStatus workStatus;
    private String email;

    public UserDTO(String name, String lastname, WorkStatus workStatus, String email){
        this.fullname= name + " " +lastname;
        this.workStatus= workStatus;
        this.email= email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public WorkStatus getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(WorkStatus workStatus) {
        this.workStatus = workStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

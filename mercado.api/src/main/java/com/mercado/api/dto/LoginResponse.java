package com.mercado.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String mensaje;
    private Boolean exito;
    private String username;
}
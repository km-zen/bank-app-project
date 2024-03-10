package pl.markowski.konrad.bankapp.user;

import org.springframework.http.HttpStatus;

public record DeleteUserResponseDto(String message, HttpStatus status) {
}

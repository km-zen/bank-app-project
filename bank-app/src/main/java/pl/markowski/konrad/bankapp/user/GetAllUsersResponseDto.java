package pl.markowski.konrad.bankapp.user;

import java.util.Map;

public record GetAllUsersResponseDto(Map<Integer, User> users) {
}

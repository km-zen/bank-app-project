package pl.markowski.konrad.bankapp.user;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class UserMapper {

    public static User mapFromCreatedUserRequestDtoToUser(CreatedUserRequestDto request){
        return new User(request.email(), request.password());
    }

    public static CreatedUserResponseDto mapFromUserToCreatedUserResponseDto(User user){
        return new CreatedUserResponseDto(user);
    }

    public static GetUserResponseDto mapFromUserToGetUserResponseDto(User user){
        return new GetUserResponseDto(user);
    }

    public static GetAllUsersResponseDto mapFromAllUsersToGetAllUsersResponseDto(Map<Integer, User> allUsers) {
        return new GetAllUsersResponseDto(allUsers);
    }

    public static User mapFromUpdateUserRequestDtoToUser(UpdateUserRequestDto request) {
        return  new User(request.email(), request.password());
    }

    public static UpdateUserResponseDto mapFromUserToUpdatedUserResponseDto(User user) {
        return new UpdateUserResponseDto(user);
    }

    public static DeleteUserResponseDto mapFromUserToDeleteUserResponseDto(Integer id) {
        return new DeleteUserResponseDto("You deleted user with id: " + id, HttpStatus.OK);
    }
}

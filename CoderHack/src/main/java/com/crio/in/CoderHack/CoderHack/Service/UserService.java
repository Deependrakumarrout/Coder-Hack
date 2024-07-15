package com.crio.in.CoderHack.CoderHack.Service;

import com.crio.in.CoderHack.CoderHack.Request.UserDto;
import com.crio.in.CoderHack.CoderHack.Utility.FinalResponse;

public interface UserService {
    FinalResponse createUser(UserDto userRequest);
    FinalResponse getAllUserDetails();
    FinalResponse getUserDetailById(Long id);
    FinalResponse updateUserScore(Long id, int score);
    FinalResponse deleteUserById(Long id);

}



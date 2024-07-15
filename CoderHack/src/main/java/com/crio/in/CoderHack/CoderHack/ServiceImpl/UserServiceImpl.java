package com.crio.in.CoderHack.CoderHack.ServiceImpl;

import com.crio.in.CoderHack.CoderHack.Model.User;
import com.crio.in.CoderHack.CoderHack.Repository.UserRepository;
import com.crio.in.CoderHack.CoderHack.Request.UserDto;
import com.crio.in.CoderHack.CoderHack.Service.UserService;
import com.crio.in.CoderHack.CoderHack.Utility.FinalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public FinalResponse createUser(UserDto userRequest) {
        User user = new User();
        user.setUserName(userRequest.getUserName());
        user.setScore(userRequest.getScore());
        String concat = "";
        String badges = getBadges(userRequest.getScore(), concat);
        user.setBadges(badges);

        User userDetails = userRepository.save(user);

        UserDto userResponse = new UserDto();
        userResponse.setId(userDetails.getId());
        userResponse.setUserName(userDetails.getUserName());



        userResponse.setBadges(userDetails.getBadges());
        userResponse.setScore(userDetails.getScore());

        FinalResponse response = new FinalResponse();
        response.setStatus("true");
        response.setMessage("Save successfully");
        response.setObject(userResponse);
        return response;

    }

    private String getBadges(int score,String concat) {
        if(score >= 1 && score < 30) {
            concat = "Code Ninja";
        }

        else if(score >= 30 && score < 60) {
            concat = "Code Ninja, Code Champ";
        }

        else if(score >= 60 && score <= 100) {
            concat += "Code Ninja, Code Champ, Code Master";
        }else {
            concat ="";
        }

        return concat;
    }

    @Override
    public FinalResponse getAllUserDetails() {

        List<User> allUser = userRepository.findAll();

        List<UserDto> userDtos = new ArrayList<>();
        for(User user: allUser) {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setUserName(user.getUserName());
            userDto.setScore(user.getScore());
            userDto.setBadges(user.getBadges());
            userDtos.add((userDto));
        }

        FinalResponse response = new FinalResponse();
        response.setMessage("All data fetched");
        response.setStatus("true");
        response.setObject(userDtos);
        return response;
    }

    @Override
    public FinalResponse getUserDetailById(Long id) {
        Optional<User> byId = userRepository.findById(id);
        User user = byId.get();
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setUserName(user.getUserName());
        userDto.setScore(user.getScore());
        userDto.setBadges(user.getBadges());

        FinalResponse response = new FinalResponse();
        response.setMessage("All data fetched");
        response.setStatus("true");
        response.setObject(userDto);
        return response;
    }

    @Override
    public FinalResponse updateUserScore(Long id, int score) {
        Optional<User> byId = userRepository.findById(id);
        User user = byId.get();
        UserDto userDto = new UserDto();

        user.setScore(score);
        userRepository.save(user);

        userDto.setId(user.getId());
        userDto.setUserName(user.getUserName());
        userDto.setScore(user.getScore());
        userDto.setBadges(user.getBadges());

        FinalResponse response = new FinalResponse();
        response.setMessage("Updated Successfully");
        response.setStatus("true");
        response.setObject(userDto);
        return response;
    }

    @Override
    public FinalResponse deleteUserById(Long id) {
        userRepository.deleteById(id);
        FinalResponse response = new FinalResponse();
        response.setMessage("Deleted Successfully");
        response.setStatus("true");
        response.setObject(null);
        return response;
    }


}

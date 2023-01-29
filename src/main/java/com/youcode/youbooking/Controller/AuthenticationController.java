package com.youcode.youbooking.Controller;


import com.youcode.youbooking.Entity.Users;
import com.youcode.youbooking.Repository.UserRepository;
import com.youcode.youbooking.config.AuthenticationService;
import com.youcode.youbooking.config.RegisterDTO;
import com.youcode.youbooking.config.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200/")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(
            @RequestBody RegisterDTO request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<ResponseDTO> authenticate(
            @RequestBody ResponseDTO responseDTO) {
/*
        return ResponseEntity.ok(authenticationService.authenticate(responseDTO));
*/        return new ResponseEntity<>(authenticationService.authenticate(responseDTO), HttpStatus.ACCEPTED);

    }

  /*

    @PostMapping("/login")
    public ResponseEntity<?> login(ResponseDTO responseDTO){
        Optional<Users> user=userRepository.findByEmail(responseDTO.getEmail());
        if(user.isPresent() && user.get().getPassword().equals(responseDTO.getPassword())){
            return  ResponseEntity.ok(user);
        }
        return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }*/
}

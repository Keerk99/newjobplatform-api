package com.keerk99.newjobplatform.infra.security;
import com.keerk99.newjobplatform.domain.users.RegisterUser;
import com.keerk99.newjobplatform.domain.users.User;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class AuthenticationController {
    private AuthenticationManager authenticationManager;
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity userAuthenticated(@RequestBody @Valid RegisterUser registerUser) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(registerUser.username(), registerUser.password());
        var userAuthenticated = authenticationManager.authenticate(authentication);
        var JWTToken = tokenService.generateToken((User) userAuthenticated.getPrincipal());
        return ResponseEntity.ok(new DataJWTToken(JWTToken));
    }
}

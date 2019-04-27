package spring.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import spring.service.LoginService;
import spring.service.TitleService;

import java.security.Principal;

/**
 * Created by Sonad on 19.09.17.
 */
@RestController
@RequestMapping("/rest/sample")
public class SampleRestService {

    @Autowired
    LoginService loginService;

    @Autowired
    TitleService titleService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Object> loadPage() {
        return ResponseEntity.ok(titleService.listAll());

    }

    @RequestMapping(value= "/comments/{id}",method = RequestMethod.GET)
    public ResponseEntity<Object> addBook(@PathVariable("id") int id) {

        return ResponseEntity.status(HttpStatus.OK).body(titleService.listComments(id));
    }

    @RequestMapping(value = "/signup/{username}/{password}", method = RequestMethod.POST)
    public ResponseEntity<Object> signUp(@PathVariable("username") String username, @PathVariable("password") String password) {

        if (username.equals("undefined") || password.equals("undefined"))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\" : \"Invalid username or password\"}");
        if (loginService.saveUser(username, password)) return ResponseEntity.ok("{\"message\" : \"Success\"}");
        else return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\" : \"Username already in use\"}");
    }
}

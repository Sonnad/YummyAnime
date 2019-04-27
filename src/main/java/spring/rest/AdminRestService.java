package spring.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.db.model.Title;
import spring.service.AdminService;
import spring.service.LoginService;
import spring.service.TitleService;
import spring.service.UserService;

import java.security.Principal;

/**
 * Created by Sonad on 19.09.17.
 */
@RestController
@RequestMapping("/rest/admin")
public class AdminRestService {

    @Autowired
    UserService userService;

    @Autowired
    AdminService adminService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Object> loadPage() {
        return ResponseEntity.ok(userService.listAll());

    }

    @RequestMapping(value= "/add/{animeName}/{pictureLink}/{videoLink}/{translator}/{year}/{genre}/{voice}/{description}",method = RequestMethod.POST)
    public ResponseEntity<Object> addTitle(@PathVariable("animeName") String animeName,
                                          @PathVariable("pictureLink") String pictureLink,
                                          @PathVariable("videoLink") String videoLink,
                                          @PathVariable("translator") String translator,
                                          @PathVariable("year") String year,
                                          @PathVariable("genre") String genre,
                                          @PathVariable("voice") String voice,
                                          @PathVariable("description") String description
                                          ) {

        if (animeName.equals("undefined") || pictureLink.equals("undefined") || videoLink.equals("undefined") || translator.equals("undefined") || year.equals("undefined") || genre.equals("undefined") || voice.equals("undefined") || description.equals("undefined"))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\" : \"Invalid title infromation\"}");
        Title newTitle = adminService.addTitle(animeName,pictureLink,videoLink,translator,Integer.parseInt(year), genre, voice, description);

        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/genre", method = RequestMethod.GET)
    public ResponseEntity<Object> loadGenre() {
        return ResponseEntity.ok(adminService.listAllGenre());

    }
    @RequestMapping(value = "/voice", method = RequestMethod.GET)
    public ResponseEntity<Object> loadVoice() {
        return ResponseEntity.ok(adminService.listAllVoice());

    }
    @RequestMapping(value = "/delete/{userName}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteBook(@PathVariable("userName") String userName) {

        if (userService.deleteUser(userName)) {
            return ResponseEntity.ok("");
        }
        else
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\" : \"User not found\"}");
    }

    @RequestMapping(value = "/search/{titleName}", method = RequestMethod.POST)
    public ResponseEntity<Object> searchTitle(@PathVariable("titleName") String titleName) {

        Title title = adminService.searchTitle(titleName);
        if (title != null) {
            return ResponseEntity.ok(title);
        }
        else
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\" : \"Title not found\"}");
    }

    @RequestMapping(value= "/update/{id}/{animeName}/{pictureLink}/{videoLink}/{translator}/{year}/{genre}/{voice}/{description}",method = RequestMethod.POST)
    public ResponseEntity<Object> updateTitle(@PathVariable("id") String id,
                                           @PathVariable("animeName") String animeName,
                                           @PathVariable("pictureLink") String pictureLink,
                                           @PathVariable("videoLink") String videoLink,
                                           @PathVariable("translator") String translator,
                                           @PathVariable("year") String year,
                                           @PathVariable("genre") String genre,
                                           @PathVariable("voice") String voice,
                                           @PathVariable("description") String description
    ) {

        if (animeName.equals("undefined") || pictureLink.equals("undefined") || videoLink.equals("undefined") || translator.equals("undefined") || year.equals("undefined") || genre.equals("undefined") || voice.equals("undefined") || description.equals("undefined") || id.equals("undefined"))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\" : \"Invalid title infromation\"}");
        Title newTitle = adminService.addTitle(Integer.parseInt(id),animeName,pictureLink,videoLink,translator,Integer.parseInt(year), genre, voice, description);

        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/deleteTitle/{titleName}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteTitle(@PathVariable("titleName") String titleName) {

        if (titleName.equals("undefined"))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\" : \"Invalid title\"}");
        if (adminService.delete(titleName)) {
            return ResponseEntity.ok("");
        }
        else
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\" : \"Title not found\"}");
    }


}

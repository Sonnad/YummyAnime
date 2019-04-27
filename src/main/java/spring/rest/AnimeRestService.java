package spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spring.db.dao.TitleRepository;

/**
 * Created by Sonad on 05.12.17.
 */
@Controller
public class AnimeRestService {

    @Autowired
    private TitleRepository titleRepository;

    @RequestMapping(value = "anime/{name}", method = RequestMethod.GET)
    public ModelAndView books(@PathVariable("name") String name) {
        ModelAndView mav = new ModelAndView("anime");
        mav.addObject("title", titleRepository.findByName(name));
        mav.addObject("list", titleRepository.findByName(name).getCommentSet());
        return mav;
    }

}

package com.uniovi.sdi_2122_108_spring.controllers;

import com.uniovi.sdi_2122_108_spring.entities.Mark;
import org.springframework.web.bind.annotation.*;

@RestController
public class MarksController {

    @RequestMapping("/mark/list")
    public String getList() {
        return "Getting List";
    }
    @RequestMapping(value ="/mark/add", method = RequestMethod.POST)
    public String setMark(@ModelAttribute Mark mark) {
        return "Added: "+mark.getDescription()+" with score: "+ +mark.getScore()+" id: "+mark.getId() ;
    }



/** Se puede hacer así o lo de abajo
    @RequestMapping("/mark/details")
    public String getDetail(@RequestParam Long id) {
        return "Getting Details =>" + id;
    }
 */
    @RequestMapping("/mark/details/{id}")
    public String getDetail(@PathVariable Long id) {
        return "Getting Details =>" + id;
    }


}

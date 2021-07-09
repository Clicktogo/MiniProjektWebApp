package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class ConcertController {

    @Autowired
    EventService service;

    @GetMapping("/")
    public String allConcerts(Model model)  {
        model.addAttribute("concertList", service.getAllConcerts());
        return "allEvents";
    }

    @GetMapping("/event")
    public String detailPage(HttpSession session, Model model, @RequestParam int eventId)    {
        model.addAttribute("currentConcert", service.getConcertById(eventId));
        session.setAttribute("concert", service.getConcertById(eventId));

        return "masterDetailConcert";
    }



    @GetMapping("/shoppingcart")
    public String displayToShoppingCart(HttpSession session){
        return ("/shoppingCart");
    }

    @PostMapping ("/shoppingcart")
    public String addToShoppingCart(HttpSession session,Model model, @RequestParam int ticketQuantity){
        HashMap<Concert, Integer> shoppingCartList = (HashMap<Concert, Integer>)session.getAttribute("shoppingCart");
        if(shoppingCartList == null) {
            shoppingCartList = new HashMap<>();
        }
       if (service.buyTickets(session,shoppingCartList, ticketQuantity)){
           session.setAttribute("wasSuccessfulPurchase", true);
       } else {
           session.setAttribute("wasSuccessfulPurchase", false);
       }
        session.setAttribute("itemsInCart", shoppingCartList.size());
        session.setAttribute("shoppingCart", shoppingCartList);

        //need for redirect
        Concert concert = (Concert)session.getAttribute("concert");
        return "redirect:/event?eventId=" + concert.getConcertId();
    }

    @GetMapping("/sort/{sort}")
    public String sorting(Model model, @PathVariable String sort) {
        if (sort.equalsIgnoreCase("Pris"))   {
            model.addAttribute("concertList", service.sortByPrice());
        }
        else if (sort.equalsIgnoreCase("Artist"))    {
            service.sortByArtistName();
            model.addAttribute("concertList", service.sortByArtistName());
        }

        return "allEvents";
    }

    @GetMapping("/filter/{filter}")
    public String filtering(@PathVariable String filter, Model model) {
        switch (filter) {
            case "Goteborg":
                model.addAttribute("concertList", service.getCityFilteredConcerts("Göteborg"));
                break;
            case "Stockholm":
                model.addAttribute("concertList", service.getCityFilteredConcerts("Stockholm"));
                break;
            case "Malmo":
                model.addAttribute("concertList", service.getCityFilteredConcerts("Malmö"));
                break;
            case "Orebro":
                model.addAttribute("concertList", service.getCityFilteredConcerts("Örebro"));
                break;
        }

        return "allEvents";
    }
}

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    public String detailPage(Model model, @RequestParam int eventId)    {
        model.addAttribute("currentConcert", service.getConcertById(eventId));

        return "masterDetailConcert";
    }

    @PostMapping("/sort")
    public String sorting(Model model, @RequestParam String sortSelection) {
        if (sortSelection.equalsIgnoreCase("Pris"))   {
            model.addAttribute("concertList", service.sortByPrice());
        }
        else if (sortSelection.equalsIgnoreCase("Artist"))    {
            service.sortByArtistName();
            model.addAttribute("concertList", service.sortByArtistName());
        }
        return "allEvents";
    }

    @PostMapping("/filter")
    public String filter(Model model, @RequestParam String filterSelection) {
        model.addAttribute("concertList", service.getCityFilteredConcerts(filterSelection));
        return "allEvents";
    }

    @GetMapping("/shoppingcart")
    public String addToShoppingCart(HttpSession session, @RequestParam int concertId, @RequestParam int ticketQuantity){
        List<Concert> shoppingCartList = (List<Concert>) session.getAttribute("shoppingCart");

        if(shoppingCartList == null) {
            shoppingCartList = new ArrayList<>();
        }

        shoppingCartList.add(service.getConcertById(concertId));
        session.setAttribute("itemsInCart", shoppingCartList.size());
        session.setAttribute("shoppingCart", shoppingCartList);

        return ("/shoppingCart");
    }
}

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class ConcertController {

    /*@Autowired
    EventService service;*/
    @Autowired
    ConcertRepository concertRepository;

    @GetMapping("/")
    public String allConcerts(Model model, HttpSession session)  {
        model.addAttribute("concertList", (List<Concert>)concertRepository.findAll());
        session.setAttribute("wasSuccessfulPurchase", null);
        return "allEvents";
    }

    @GetMapping("/event")
    public String detailPage(HttpSession session, Model model, @RequestParam Long eventId)    {
        Concert concert = concertRepository.findById(eventId).get();
        model.addAttribute("currentConcert", concert);
        session.setAttribute("concert", concert);

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
       if (buyTickets(session,shoppingCartList, ticketQuantity)){
           session.setAttribute("wasSuccessfulPurchase", true);
       } else {
           session.setAttribute("wasSuccessfulPurchase", false);
       }
        session.setAttribute("itemsInCart", shoppingCartList.size());
        session.setAttribute("shoppingCart", shoppingCartList);

        //need for redirect
        Concert concert = (Concert)session.getAttribute("concert");
        return "redirect:/event?eventId=" + concert.getId();
    }

    @GetMapping("/sort/{sort}")
    public String sorting(Model model, @PathVariable String sort) {

        if (sort.equalsIgnoreCase("Pris"))   {
            List<Concert> concerts = concertRepository.findAllByOrderByTicketPrice();
            model.addAttribute("concertList", concerts);
        }
        else if (sort.equalsIgnoreCase("Artist"))    {
            List<Concert> concerts = concertRepository.findAllByOrderByArtist();
            model.addAttribute("concertList", concertRepository.findAllByOrderByArtist());
        }

        return "allEvents";
    }

    @GetMapping("/filter/{filter}")
    public String filtering(@PathVariable String filter, Model model) {
        switch (filter) {
            case "Goteborg":
                model.addAttribute("concertList", concertRepository.findAllByFilterByCity("Göteborg"));
                break;
            case "Stockholm":
                model.addAttribute("concertList", concertRepository.findAllByFilterByCity("Stockholm"));
                break;
            case "Malmo":
                model.addAttribute("concertList", concertRepository.findAllByFilterByCity("Malmö"));
                break;
            case "Orebro":
                model.addAttribute("concertList", concertRepository.findAllByFilterByCity("Örebro"));
                break;
        }

        return "allEvents";
    }

    public boolean buyTickets(HttpSession session, HashMap<Concert, Integer> shoppingCartList, int tickets) {
        Concert tempConcert = (Concert)session.getAttribute("concert");
        if(!tempConcert.isNotFull(tickets)) {
            session.setAttribute("buyAlert", "Misslyckades! Du försökte köpa " + tickets + " biljetter men det finns bara " + getFreeSpots(tempConcert.getArena(), tempConcert) + " biljetter kvar.");
            return false;
        }
        tempConcert.buyTicket(tickets);
        Integer tempQuantity = shoppingCartList.get(session.getAttribute("concert"));
        if(tempQuantity == null){
            shoppingCartList.put((Concert)session.getAttribute("concert"), tickets);
        } else {
            shoppingCartList.put((Concert)session.getAttribute("concert"), tickets + tempQuantity);
        }
        session.setAttribute("buyAlert", "Lyckades! Du lade till " + tickets + " biljetter till din kundkorg.");
        return true;
    }

    public int getFreeSpots(Arena arena, Concert concert) {
        return arena.getArenaCapacity() - concert.getTicketsSold();
    }
}

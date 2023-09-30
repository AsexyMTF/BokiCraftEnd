package online.boki.backend.Controller;

import online.boki.backend.Enums.StatusCodeEnum;
import online.boki.backend.Model.Ticket;
import online.boki.backend.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/ticket")
@CrossOrigin("*")
@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping
    public String submitTicket(@RequestBody Ticket ticket) {
        ticketService.addNewTicket(ticket);
        return StatusCodeEnum.Success.getValue();
    }
}

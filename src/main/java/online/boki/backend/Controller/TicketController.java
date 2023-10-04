package online.boki.backend.Controller;

import lombok.extern.slf4j.Slf4j;
import online.boki.backend.Body.FrontendBody;
import online.boki.backend.Enums.StatusCodeEnum;
import online.boki.backend.Model.Account;
import online.boki.backend.Model.Ticket;
import online.boki.backend.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/ticket")
@CrossOrigin("*")
@RestController
@Slf4j
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping
    public FrontendBody submitTicket(@RequestBody Ticket ticket) {
        try {
            ticketService.addNewTicket(ticket);
            return new FrontendBody(StatusCodeEnum.Success, "Success");
        } catch (Exception e) {
            log.error(e.toString());
            return new FrontendBody(StatusCodeEnum.Fatal, e.toString());
        }
    }

    @PostMapping("/getone")
    public FrontendBody getAskerTicket(@RequestBody Account account) {
        try {
            return ticketService.getAskerTicket(account.getUserID());
        } catch (Exception e) {
            return new FrontendBody(StatusCodeEnum.Fatal, "Error:" + e.toString());
        }
    }

    @PostMapping("/getall")
    public FrontendBody getAllTicket() {
        try {
            return ticketService.getAllTicket();
        } catch (Exception e) {
            return new FrontendBody(StatusCodeEnum.Fatal, "Error:" + e.toString());
        }
    }

    @PostMapping("/deleteone")
    public FrontendBody deleteAskerTicket(@RequestBody Ticket ticket) {
        try {
            return ticketService.deleteAskerTicket(ticket);
        } catch (Exception e) {
            return new FrontendBody(StatusCodeEnum.Fatal, "Error:" + e.toString());
        }

    }

    @PostMapping("/updateone")
    public FrontendBody updateAskerTicket(@RequestBody Ticket ticket) {
        try {
            return ticketService.updateAskerTicket(ticket);
        } catch (Exception e) {
            return new FrontendBody(StatusCodeEnum.Fatal, "Error:" + e.toString());
        }
    }
}

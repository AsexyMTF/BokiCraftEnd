package online.boki.backend.Service;

import online.boki.backend.Model.Ticket;
import online.boki.backend.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Bean
    public TicketService getTickService() {
        return new TicketService();
    }

    @Autowired
    private TicketRepository ticketRepository;

    public void addNewTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }
}

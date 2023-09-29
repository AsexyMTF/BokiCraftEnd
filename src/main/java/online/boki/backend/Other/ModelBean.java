package online.boki.backend.Other;

import online.boki.backend.Model.Ticket;
import org.springframework.context.annotation.Bean;

public class ModelBean {
    @Bean
    Ticket getTicket(){
        return  new Ticket();
    }
}

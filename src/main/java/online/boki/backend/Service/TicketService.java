package online.boki.backend.Service;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import online.boki.backend.Body.FrontendBody;
import online.boki.backend.Enums.StatusCodeEnum;
import online.boki.backend.Model.Ticket;
import online.boki.backend.Repository.AccountRepository;
import online.boki.backend.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Slf4j
@Service
public class TicketService {
    @Bean
    public TicketService getTickService() {
        return new TicketService();
    }

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private AccountRepository accountRepository;

    public void addNewTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public FrontendBody getAskerTicket(String askerName) {
        if (accountRepository.findAccountByUserID(askerName) == null)
            return new FrontendBody(StatusCodeEnum.Fatal, "找不到正确的玩家ID！");
        List<Ticket> ticketList = ticketRepository.findTicketsBySubmitUserName(askerName);
        JSONObject jsonObject = null;
        JSONArray jsonArray = new JSONArray();
        for (Ticket ticket : ticketList) {
            jsonObject = JSONObject.from(ticket);
            jsonArray.add(jsonObject);
        }
        return new FrontendBody(StatusCodeEnum.Success, jsonArray);
    }

    public FrontendBody getAllTicket() {
        List<Ticket> ticketList = ticketRepository.findAll();
        JSONObject jsonObject = null;
        JSONArray jsonArray = new JSONArray();
        for (Ticket ticket : ticketList) {
            jsonObject = JSONObject.from(ticket);
            jsonArray.add(jsonObject);
        }
        return new FrontendBody(StatusCodeEnum.Success, jsonArray);
    }

    public FrontendBody deleteAskerTicket(Ticket ticket) {
        ticketRepository.deleteById(ticket.getId());
        return new FrontendBody(StatusCodeEnum.Success, "Success");
    }

    public FrontendBody updateAskerTicket(Ticket ticket) {
        ticketRepository.save(ticket);
        return new FrontendBody(StatusCodeEnum.Success, "Success");
    }
}

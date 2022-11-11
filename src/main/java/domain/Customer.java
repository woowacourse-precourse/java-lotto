package domain;

import lotto.Lotto;

import java.util.List;


public class Customer {
    private final List<Lotto> tickets;

    public Customer(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public void printTicketsList(){
        System.out.println(tickets.size()+"개를 구매했습니다.");
        for (Lotto lotto : tickets) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

}

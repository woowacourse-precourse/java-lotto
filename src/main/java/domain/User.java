package domain;

import java.util.List;

public class User {
    private List<Lotto> lottos ;
    private int numberOfTickets;


    public User(){}

    public void buyTicket(int money) {
        if (!(money % 1000 == 0)) {
            throw new IllegalArgumentException("[ERROR] 금액이 올바르지 않습니다");
        }
        numberOfTickets = money / 1000;
    }


}

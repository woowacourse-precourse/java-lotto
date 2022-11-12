package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class User {
    private List<Lotto> lottos = new ArrayList<>();
    private int numberOfTickets;

    @Override
    public String toString() {
        return "User{" +
                "lottos=" + lottos +
                ", numberOfTickets=" + numberOfTickets +
                '}';
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public User() {
    }

    public void buyTicketMoney(int money) {
        if (!(money % 1000 == 0)) {
            throw new IllegalArgumentException("[ERROR] 금액이 올바르지 않습니다");
        }
        numberOfTickets = money / 1000;
    }

    public void buyTicket(int numberOfTickets) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }


}

package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class User {
    private static User instance = new User();
    public static User getInstance = instance;

    private List<Lotto> lottos = new ArrayList<>();
    private int numberOfTickets;
    private int money;

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
        this.money = money;
        numberOfTickets = money / 1000;
    }

    public void buyTicket(int numberOfTickets) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        for (int i = 0; i < numberOfTickets; i++) {
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}

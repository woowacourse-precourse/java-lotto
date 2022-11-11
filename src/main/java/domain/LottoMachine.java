package domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private final int money;

    public LottoMachine(int money) {
        this.money = money;
    }

    public List<Lotto> buyTickets() {
        List<Lotto> tickets = new ArrayList<>();
        int count = buyCount();
        for (int i = 0; i < count; i++) {
            tickets.add(createNumber());
        }
        return tickets;
    }

    private int buyCount() {
        return money / ConstantNumber.VALID_MONEY.getNumber();
    }

    private Lotto createNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6)
                .stream()
                .sorted()
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }
}

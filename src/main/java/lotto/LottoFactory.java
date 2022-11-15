package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.WinningNumber.REPEAT_INITIAL_VALUE;

public class LottoFactory {

    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    static final int LOTTO_SIZE_DEFAULT = 6;

    public static List<Lotto> ticket(Money money) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = REPEAT_INITIAL_VALUE; i < money.getMoney(); i++) {
            tickets.add(new Lotto(numbers()));
        }
        return tickets;
    }

    private static List<Integer> numbers() {
        List<Integer> tempTicket = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE_DEFAULT);
        Collections.sort(tempTicket);
        return tempTicket;
    }

}
package lotto.domain.lottomachine.lottoticket;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoTicketMachine {

    private int convertMoneyIntoTickets(int money) {
        return money / 1000;
    }

    private List<Integer> generateSixRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}

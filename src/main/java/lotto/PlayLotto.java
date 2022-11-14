package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayLotto {
    CreateLotto createLotto = new CreateLotto();
    public List<List<Integer>> playLottoTicketCount(Integer ticketCount) {
        List<List<Integer>> allLottoNumber = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            CreateLotto createLotto = new CreateLotto();
            Collections.sort(createLotto.createRandomBall());
            allLottoNumber.add(createLotto.createRandomBall());
        }
        return allLottoNumber;
    }

/*    public void seprateTicket(List<List<Integer>> RandomLottoTicket) {
        for (List<Integer> eachTicket : RandomLottoTicket) {

        }
    }*/

    public int compareTicketAndWinningNumber(List<Integer> ticket, String winningNumber) {
        List<Integer> winning = createLotto.winningNumber(winningNumber);
        int countWinning = 0;
        for (Integer ticketNumber : ticket) {
            if (winning.contains(ticketNumber)) {
                countWinning ++;
            }
        }
        return countWinning;
    }
    public boolean compareTicketAndBonusNumber(List<Integer> ticket, String bonus) {
        Integer bonusNumber = createLotto.bonusNumber(bonus);
        boolean countbonus = false;
        if (ticket.contains(bonusNumber)) {
            countbonus = true;
        }
        return countbonus;
    }
}

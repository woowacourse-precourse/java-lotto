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
            /*이 부분 createRandomBall 직접 받지 않도록 수정해야 할듯*/
            Collections.sort(createLotto.createRandomBall());
            allLottoNumber.add(createLotto.createRandomBall());
        }
        return allLottoNumber;
    }

    public List<Integer> allTicketCheckCorrectNumber(List<List<Integer>> RandomLottoTicket, String inputWinningNumber, String inputBonusNumber) {
        List<Integer> correctNumber = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        for (List<Integer> eachTicket : RandomLottoTicket) {
            int compareWinning = compareTicketAndWinningNumber(eachTicket, inputWinningNumber);
            boolean compareBonus = compareTicketAndBonusNumber(eachTicket, inputBonusNumber);
            int compareReward = compareReward(compareWinning, compareBonus);
            if (compareReward < 5) {
                correctNumber.set(compareReward, correctNumber.get(compareReward) + 1);
            }
        }
        return correctNumber;
    }

    public int compareTicketAndWinningNumber(List<Integer> ticket, String winningNumber) {
        List<Integer> winning = createLotto.winningNumber(winningNumber);
        int countWinning = 0;
        for (Integer ticketNumber : ticket) {
            if (winning.contains(ticketNumber)) {
                countWinning++;
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

    public int compareReward(int compareWinning, boolean compareBonus) {
        if (compareWinning == 3) {
            return 4;
        }
        if (compareWinning == 4) {
            return 3;
        }
        if (compareWinning == 5 && !compareBonus) {
            return 2;
        }
        if (compareWinning == 5 && compareBonus) {
            return 1;
        }
        if (compareWinning == 6 && !compareBonus) {
            return 0;
        }
        return 9;
    }

}

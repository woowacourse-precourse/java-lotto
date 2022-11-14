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

    public void print5th(List<Integer> countCorrectNumber) {
        System.out.printf("3개 일치 (5,000원) - " + countCorrectNumber.get(4) + "개");
    }

    public void print4th(List<Integer> countCorrectNumber) {
        System.out.printf("4개 일치 (50,000원) - " + countCorrectNumber.get(3) + "개");
    }

    public void print3rd(List<Integer> countCorrectNumber) {
        System.out.printf("5개 일치 (1,500,000원) - " + countCorrectNumber.get(2) + "개");
    }

    public void print2nd(List<Integer> countCorrectNumber) {
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countCorrectNumber.get(1) + "개");
    }

    public void print1st(List<Integer> countCorrectNumber) {
        System.out.printf("6개 일치 (2,000,000,000원) - " + countCorrectNumber.get(0) + "개");
    }

    public int profit5th(List<Integer> countCorrectNumber) {
        return countCorrectNumber.get(4) * Reward.FIFTH.getAmount();
    }

    public int profit4th(List<Integer> countCorrectNumber) {
        return countCorrectNumber.get(3) * Reward.FOURTH.getAmount();
    }

    public int profit3rd(List<Integer> countCorrectNumber) {
        return countCorrectNumber.get(2) * Reward.THIRD.getAmount();
    }

    public int profit2nd(List<Integer> countCorrectNumber) {
        return countCorrectNumber.get(1) * Reward.SECOND.getAmount();
    }

    public int profit1st(List<Integer> countCorrectNumber) {
        return countCorrectNumber.get(0) * Reward.FIFTH.getAmount();
    }

    public void printYield(int money, List<Integer> countCorrectNumber) {
        int allProfit = profit1st(countCorrectNumber) + profit2nd(countCorrectNumber) + profit3rd(countCorrectNumber) + profit4th(countCorrectNumber) + profit5th(countCorrectNumber);
        float yield = allProfit / money;
        System.out.printf("총 수익률은 " + String.format("%.1f", yield) + "입니다.");
    }
}

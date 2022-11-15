package lotto;

import java.util.ArrayList;
import java.util.List;

public class PlayLotto {
    InputNumber inputNumber = new InputNumber();

    public List<List<Integer>> allTicket(Integer ticketCount) {
        List<List<Integer>> allLottoNumber = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            CreateLotto createLotto = new CreateLotto();
            Lotto lotto = new Lotto(createLotto.createRandomBall());
            /*밑에 두줄 lotto에 포함시킬 수 있을 듯.*/
//            List<Integer> lottoNumber = createLotto.createRandomBall().sort(Comparator.naturalOrder());
            lotto.printLottoNumber();
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
        List<Integer> winning = inputNumber.winningNumber(winningNumber);
        int countWinning = 0;
        for (Integer ticketNumber : ticket) {
            if (winning.contains(ticketNumber)) {
                countWinning++;
            }
        }
        return countWinning;
    }

    public boolean compareTicketAndBonusNumber(List<Integer> ticket, String bonus) {
        Integer bonusNumber = inputNumber.bonusNumber(bonus);
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

    public void print5th(List<Integer> correctNumber) {
        System.out.printf("3개 일치 (5,000원) - " + correctNumber.get(4) + "개");
        System.out.println();
    }

    public void print4th(List<Integer> correctNumber) {
        System.out.printf("4개 일치 (50,000원) - " + correctNumber.get(3) + "개");
        System.out.println();
    }

    public void print3rd(List<Integer> correctNumber) {
        System.out.printf("5개 일치 (1,500,000원) - " + correctNumber.get(2) + "개");
        System.out.println();
    }

    public void print2nd(List<Integer> correctNumber) {
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - " + correctNumber.get(1) + "개");
        System.out.println();
    }

    public void print1st(List<Integer> correctNumber) {
        System.out.printf("6개 일치 (2,000,000,000원) - " + correctNumber.get(0) + "개");
        System.out.println();
    }

    public void printRanking(List<Integer> correctNumber) {
        print5th(correctNumber);
        print4th(correctNumber);
        print3rd(correctNumber);
        print2nd(correctNumber);
        print1st(correctNumber);
    }


    public int profit5th(List<Integer> correctNumber) {
        return correctNumber.get(4) * Reward.FIFTH.getAmount();
    }

    public int profit4th(List<Integer> correctNumber) {
        return correctNumber.get(3) * Reward.FOURTH.getAmount();
    }

    public int profit3rd(List<Integer> correctNumber) {
        return correctNumber.get(2) * Reward.THIRD.getAmount();
    }

    public int profit2nd(List<Integer> correctNumber) {
        return correctNumber.get(1) * Reward.SECOND.getAmount();
    }

    public int profit1st(List<Integer> correctNumber) {
        return correctNumber.get(0) * Reward.FIFTH.getAmount();
    }

    public double yield(Integer money, List<Integer> correctNumber) {
        double allProfit = profit1st(correctNumber) + profit2nd(correctNumber) + profit3rd(correctNumber) + profit4th(correctNumber) + profit5th(correctNumber);
        double yield = Math.round(((allProfit / money) * 100) * 10.0) / 10.0;
        System.out.println("총 수익률은 " + yield + "%입니다.");
        return yield;
    }
}

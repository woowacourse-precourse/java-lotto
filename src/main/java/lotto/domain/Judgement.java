package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class Judgement {

    private int[] result;

    public Judgement() {

        this.result = new int[6];
    }

    public int[] getResult() {

        return this.result;
    }

    public void checkWin(Set<Integer> winner, allLotto alllotto, String bonusNumber, Money money) {

        for (int i = 0; i < alllotto.sizeLotto(); i++) {
            Set<Integer> tempWinner = new HashSet<>();
            tempWinner.addAll(winner);
            Set<Integer> transfromLotto = alllotto.transformSet(alllotto.get(i));
            resultUpdate(result, checkPlaceWin(tempWinner, transfromLotto, bonusNumber, money));

        }
        printResult(this.result);
    }

    public int checkPlaceWin(Set<Integer> tempwinner, Set<Integer> transformLotto, String bonusNumber, Money money) {

        tempwinner.retainAll(transformLotto);
        Rank rank = Rank.findRank(tempwinner.size(), isContainsBonus(tempwinner, bonusNumber));
        money.sumWinningMoney(rank);
        return rank.getRank();
    }

    public boolean isContainsBonus(Set<Integer> tempwinner, String bonusNumber) {

        return tempwinner.contains(Integer.parseInt(bonusNumber));
    }

    public void resultUpdate(int[] result, int place) {

        result[place]++;
    }

    public void printResult(int[] result) {

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result[5] + "개");
        System.out.println("4개 일치 (50,000원) - " + result[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result[2] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result[1] + "개");
    }


}

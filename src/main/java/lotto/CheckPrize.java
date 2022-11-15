package lotto;

import java.util.*;

public class CheckPrize {
    private final int SIZE = 5; // 등수
    private int prize;
    private ArrayList<Integer> rankCount;

    public CheckPrize() {
        rankCount = new ArrayList<>(Collections.nCopies(SIZE, 0));
        prize = 0;
    }

    // 당첨금을 구해주고 출력하는 함수
    public int getPrize(List<Lotto> lottoList, ArrayList<Integer> winningNumber, int bonusNumber) {
        for (Lotto l : lottoList)
            calcRank(l, winningNumber, bonusNumber);

        calcPrize();
        printPrize();
        return prize;
    }

    // 번호 일치를 계산하는 함수
    private void calcRank(Lotto lotto, ArrayList<Integer> winningNumber, int bonusNumber) {
        int count = 0;
        boolean bonus = false;
        for (Integer n : lotto.getNumbers()) {
            if (winningNumber.contains(n))
                count++;
            if (n == bonusNumber)
                bonus = true;
        }

        ranking(count, bonus);
    }

    // 등수를 계산하는 함수
    private void ranking(int count, boolean bonus) {
        int rank;
        switch (count) {
            case 3:
                rank = 1;
                break;
            case 4:
                rank = 2;
                break;
            case 5:
                rank = 3;
                if (bonus)
                    rank = 4;
                break;
            case 6:
                rank = 5;
                break;
            default:
                return;
        }
        updateRank(rank);
    }

    // 등수 업데이트
    private void updateRank(int rank) {
        int count = rankCount.get(rank - 1);
        count++;
        rankCount.set(rank - 1, count);
    }

    // 당첨금을 계산하는 함수
    private void calcPrize() {
        Integer[] prizes_ = { 5000, 50000, 1500000, 30000000, 2000000000 };
        ArrayList<Integer> prizes = new ArrayList<>(Arrays.asList(prizes_));

        for(int i = 0; i < rankCount.size(); i++)
            prize += prizes.get(i) * rankCount.get(i);
    }

    private void printPrize() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + rankCount.get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + rankCount.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rankCount.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCount.get(3) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rankCount.get(4) + "개");
    }
}

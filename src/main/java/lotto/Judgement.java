package lotto;

import java.util.List;
import java.util.Set;

public class Judgement {
    public int fifthPlace;
    public int fourthPlace;
    public int thirdPlace;
    public int secondPlace;
    public int firstPlace;

    public void compare(Set<Lotto> playerLotto, List<Integer> winningNumbers, int bonusNumber) {
        for(Lotto lotto : playerLotto) {
            List<Integer> playernumbers = lotto.getNumbers();
            int correctNumber = countCorrect(playernumbers, winningNumbers);
            if (correctNumber == 3) fifthPlace++;
            else if (correctNumber == 4) fourthPlace++;
            else if (correctNumber == 5) {
                bonusResult(playernumbers, bonusNumber);
            }
            else if (correctNumber == 6) firstPlace++;
        }
    }

    public int countCorrect(List<Integer> playernumbers, List<Integer> winningNumbers) {
        int correctNumber = 0;
        for(int number : winningNumbers) {
            if (playernumbers.contains(number)) {
                correctNumber++;
            }
        }
        return correctNumber;
    }

    public void bonusResult(List<Integer> playernumbers, int bonusNumber) {
        for(int number : playernumbers) {
            if (playernumbers.contains(bonusNumber)) {
                secondPlace++;
                return;
            }
        }
        thirdPlace++;
    }

    public void winningResult(Set<Lotto> playerLotto) {
        System.out.println("당첨 통계");
        System.out.println("3개 일치 (5,000원) - " + fifthPlace + "개");
        System.out.println("4개 일치 (50,000원) - " + fourthPlace + "개");
        System.out.println("5개 일치 (1,500,000원) - " + thirdPlace + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + secondPlace + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + firstPlace + "개");
        System.out.println("총 수익률은 " + rateOfProfit(playerLotto) + "%입니다.");

    }

    public double rateOfProfit(Set<Lotto> playerLotto) {
        int profit = 5000*fifthPlace + 50000*fourthPlace + 1500000*thirdPlace
                + 30000000*secondPlace + 2000000000*firstPlace;
        double cost = playerLotto.size() * 1000;
        double rateOfProfit = profit / cost * 100;
        return rateOfProfit;
    }
}

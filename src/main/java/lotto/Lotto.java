package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import lotto.enumeration.Bonus;
import lotto.enumeration.Money;

public class Lotto {
    private final List<Integer> numbers;
    private final Stats game = new Stats();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 당첨 번호는 총 6개를 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
        if (new HashSet<>(numbers).size() != 6) {
            System.out.println("[ERROR] 로또 번호에 중복된 숫자가 있을 수 없습니다.");
            throw new IllegalArgumentException();
        }
        for (Integer number : numbers) {
            if(number < 1 || number > 45) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    private void getStats(List<Integer> issued, int bonus) {
        List<Integer> statistic = new ArrayList<>();
        statistic.add(0); 
        statistic.add(Bonus.NOT_EQUAL.statusNum());
        for (Integer issuedNumber : issued) {
            if (numbers.contains(issuedNumber)) {
                statistic.set(0, (Integer)statistic.get(0) + 1);
            }
            if (issuedNumber == bonus) {
                statistic.set(1, Bonus.EQUAL.statusNum());
            }
        }
        calculateResult(statistic);
    }

    private void calculateResult(List<Integer> statistic) {
        int equal = (Integer)statistic.get(0);
        if (equal > 2) {
            int index = equal - 3;
            if(equal == 6 || (equal == 5 && statistic.get(1).equals(Bonus.EQUAL.statusNum()))) index = equal - 2;
            game.setStats(index, game.getStats().get(index) + 1);
            game.setTotal(game.getTotal() + getMoney(equal, statistic.get(1)));
        }
    }

    private Integer getMoney(int equal, int bonusEqual) {
        if (equal == 3) return Money.THREE.amount();
        if (equal == 4) return Money.FOUR.amount();
        if (equal == 5) return Money.FIVE.amount();
        if (equal == 5 && bonusEqual == 1) return Money.FIVE_WITH_BONUS.amount();
        if (equal == 6) return Money.SIX.amount();
        System.out.println("[ERROR] 당첨 번호의 개수는 3개 이상 6개 이하여야 합니다.");
        throw new IllegalArgumentException();
    } 

    void getResult(int payAmount, Integer bonus, List<List<Integer>> publishedLottos) {   
        for (List<Integer> issued : publishedLottos) {
            getStats(issued, bonus);
        }
        printStats();
        printEarningsRate(payAmount);
    }

    private void printStats() {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (" + Money.THREE.type() + ") - " + game.getStats().get(0) + "개");
        System.out.println("4개 일치 (" + Money.FOUR.type() + ") - " + game.getStats().get(1) + "개");
        System.out.println("5개 일치 (" + Money.FIVE.type() + ") - " + game.getStats().get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + Money.FIVE_WITH_BONUS.type() + ") - " + game.getStats().get(3) + "개");
        System.out.println("6개 일치 (" + Money.SIX.type() + ") - " + game.getStats().get(4) + "개");
    }

    private void printEarningsRate(int payAmount) {
        double ratio = (double)game.getTotal()/payAmount * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", ratio) + "%입니다.");
    }
}

package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]당첨 숫자는 6가지로 입력해 주세요.");
        }
        Set<Integer> duplicateCheckSet = new HashSet<>(numbers);
        if (duplicateCheckSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR]당첨 숫자는 중복 없이 입력해 주세요.");
        }
        for (int i = 0; i < numbers.size(); i++){
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw new IllegalArgumentException("[ERROR]당첨 숫자는 1에서 45사이의 숫자를 입력해 주세요.");
            }
        }
        System.out.println(numbers);
    }

    public void lottoCheck(List<Integer> numbers, int bonusNumber, List<List<Integer>> userLotto) {
        int[] prizeCount = {0,0,0,0,0,0};

        for (int i = 0; i < userLotto.size(); i++) {
            int winCount = countWin(numbers, userLotto.get(i));
            int bonusCount = countBonus(bonusNumber,userLotto.get(i));
            prizeCount[lottoPrice(winCount,bonusCount)]++;
        }
        printPrize(prizeCount);
        printRateOfReturn(prizeCount,userLotto);
    }

    public int countWin(List<Integer> numbers, List<Integer> userLotto) {
        int winCount = 0;
        for (int j = 0; j < numbers.size(); j++) {
            if (numbers.contains(userLotto.get(j))) {
                winCount++;
            }
        }
        return winCount;
    }

    public int countBonus(int bonusNumber, List<Integer> userLotto) {
        int bounsCount = 0;
        for (int j = 0; j < numbers.size(); j++) {
            if (bonusNumber == userLotto.get(j)) {
                    bounsCount++;
            }
        }
        return bounsCount;
    }

    public int lottoPrice(int winCount, int bonusCount) {
        if (winCount == 3) {
            return 4;
        }
        if (winCount == 4) {
            return 3;
        }
        if (winCount == 5 && bonusCount == 0) {
            return 2;
        }
        if (winCount == 5 && bonusCount == 1) {
            return 1;
        }
        if (winCount == 6) {
            return 0;
        }
        return 5;
    }

    public void printPrize(int[] prizeCount) {
        System.out.println("3개 일치 (5,000원) - " + prizeCount[4]+"개");
        System.out.println("4개 일치 (50,000원) - " + prizeCount[3]+"개");
        System.out.println("5개 일치 (1,500,000원) - " + prizeCount[2]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prizeCount[1]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prizeCount[0]+"개");
    }

    public void printRateOfReturn(int[] prizeCount, List<List<Integer>> userLotto) {
        double rateOfRevenue = 0;
        double invest = userLotto.size()*1000;
        double revenue = 5000*prizeCount[4] + 50000*prizeCount[3] + 1500000*prizeCount[2] + 30000000*prizeCount[1] + 2000000000*prizeCount[0];
        rateOfRevenue = (revenue / invest) * 100;
        String roundRateOfRevenue = String.format("%.2f",rateOfRevenue);
        System.out.println("총 수익률은 "+ roundRateOfRevenue +"%입니다.");

    }
}

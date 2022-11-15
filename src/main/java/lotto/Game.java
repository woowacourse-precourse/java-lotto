package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Message.*;

public class Game {
    User user = new User();

    public List<Integer> correctLottoCount(List<List<Integer>> lottos, List<Integer> userLottos, int bonusNumber) {
        int arr[] = new int[userLottos.size()];

        for (int i = 0; i < lottos.size(); i++) {
            List<Integer> lotto = lottos.get(i);
            int number = getGrade(lotto, userLottos, bonusNumber);
            arr[number]++;
        }

        List<Integer> result = Arrays.stream(arr).boxed().collect(Collectors.toList());
        return result;
    }

    public String getRate (List<Integer> grades, int money) {
        long profit = 0;

        profit += (long) 2_000_000_000 * grades.get(1);
        profit += (long) 30_000_000 * grades.get(2);
        profit += (long) 1_500_000 * grades.get(3);
        profit += (long) 50_000 * grades.get(4);
        profit += (long) 5_000 * grades.get(5);

        double result = profit / (double) money * 100;
        return String.format("%.1f", result) + "%";
    }

    public int getGrade(List<Integer> lotto, List<Integer> input, int bonusNumber) {
        int count = 0;
        for (int i = 0; i < input.size(); i++) {
            if (lotto.contains(input.get(i))) {
                count++;
            }
            if (count == 5 && lotto.contains(bonusNumber)) {
                return 2;
            }
        }
        if (count == 6) return 1;
        if (count == 5) return 3;
        if (count == 4) return 4;
        if (count == 3) return 5;
        return 0;
    }

    public void getStatistics(List<Integer> grades, String profitRate) {
        System.out.println(STATISTICS.getMessage());
        System.out.println(FIFTH.getMessage() + grades.get(5) + COUNT.getMessage());
        System.out.println(FOURTH.getMessage() + grades.get(4) + COUNT.getMessage());
        System.out.println(THIRD.getMessage() + grades.get(3) + COUNT.getMessage());
        System.out.println(SECOND.getMessage() + grades.get(2) + COUNT.getMessage());
        System.out.println(FIRST.getMessage() + grades.get(1) + COUNT.getMessage());
        System.out.println(RATE.getMessage() + profitRate + STR.getMessage());
    }

    public void buyLotto() {
        System.out.println(INPUT_MONEY.getMessage());
        int money = user.inputMoney();
        List<List<Integer>> winLottos = Lotto.makeLotto(Lotto.count(money));
        System.out.println(Lotto.count(money) + COUNT_LOTTO.getMessage());
        for (List<Integer> winLotto : winLottos) {
            System.out.println(winLotto);
        }
        System.out.println(INPUT_LOTTO_NUMBER.getMessage());
        List<Integer> list = user.userLotto(Console.readLine());
        List<Integer> usersLotto = new Lotto(list).getNumbers();
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        int bonusNumber = user.getBonusNumber(Integer.parseInt(Console.readLine()));
        List<Integer> grades = correctLottoCount(winLottos, usersLotto, bonusNumber);
        String profitRate = getRate(grades, money);
        getStatistics(grades, profitRate);
    }
}

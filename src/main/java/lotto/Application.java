package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int money = -1;
        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR]");
            return ;
        }

        validate(money);

        int numberOfLotto = money / 1000;

        List<Lotto> lottos = perchaseLotto(numberOfLotto);
        printLottos(lottos);

        System.out.println("당첨 번호를 입력해 주세요.");
        String inputNumbers = Console.readLine();
        List<Integer> winningNumbers = stringToList(inputNumbers);
        Lotto winningLotto = new Lotto(winningNumbers);

        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Console.readLine();

        // 예외처리 필요
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        List<Integer> ranking = rank(lottos, winningLotto, bonusNumber);
        printRanking(ranking);
        printEarningRate(money, ranking);

    }

    public static void validate(int money) {
        if (money % 1000 != 0) {
            System.out.println("[ERROR]");
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public static List<Lotto> perchaseLotto(int numberOfLotto) {
        List<Lotto> result = new ArrayList<>();

        for (int i = 0; i < numberOfLotto; i++) {
            result.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        return result;
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static List<Integer> stringToList(String inputNumbers) {
        List<Integer> result = new ArrayList<>();

        String[] numbers = inputNumbers.split(",");
        for (String number : numbers) {
            result.add(Integer.parseInt(number.trim()));
        }

        return result;
    }

    public static List<Integer> rank(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        List<Integer> result = new ArrayList<>();
        int first = 0, second = 0, third = 0, forth = 0, fifth = 0;

        for (Lotto lotto : lottos) {
            if (lotto.countSameNumber(winningLotto, bonusNumber) == 3)
                fifth++;
            else if (lotto.countSameNumber(winningLotto, bonusNumber) == 4)
                forth++;
            else if (lotto.countSameNumber(winningLotto, bonusNumber) == 5)
                third++;
            else if (lotto.countSameNumber(winningLotto, bonusNumber) == 6)
                first++;
            else if (lotto.countSameNumber(winningLotto, bonusNumber) == 7)
                second++;
        }

        result.add(first);
        result.add(second);
        result.add(third);
        result.add(forth);
        result.add(fifth);

        return result;
    }

    public static void printRanking(List<Integer> ranking) {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + ranking.get(4) +"개");
        System.out.println("4개 일치 (50,000원) - " + ranking.get(3) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + ranking.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + ranking.get(1) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + ranking.get(0) + "개");
    }

    public static void printEarningRate(int money, List<Integer> ranking) {
        int earnings = 0;
        earnings += 2000000000 * ranking.get(0);
        earnings += 30000000 * ranking.get(1);
        earnings += 1500000 * ranking.get(2);
        earnings += 50000 * ranking.get(3);
        earnings += 5000 * ranking.get(4);
        System.out.println("총 수익률은 " + String.format("%.1f", (double) earnings / money * 100) + "%입니다.");
    }
}

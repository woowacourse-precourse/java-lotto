package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    private static List<Lotto> userLottos = new ArrayList<>();
    private static List<Integer> winningCount = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int cost = inputCost(Console.readLine());

        int lottoCount = PriceConfig.getLottoCountWithoutChange(cost);

        System.out.println(lottoCount + "개를 구매했습니다.");
        publishNewLotto(lottoCount);

        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto winningLotto = new Lotto(inputWinningLottoNums(Console.readLine()));
        System.out.println("보너스 번호를 입력해 주세요.");
        int winningBonus = inputWinningBonusNum(Console.readLine());

        Statistics statistics = new Statistics(winningLotto, winningBonus);

        for (int i = 0; i < userLottos.size(); i++) {
            int prize = statistics.getPrize(userLottos.get(i));
            if (prize != -1)
                winningCount.set(prize - 1, winningCount.get(prize - 1) + 1);
        }
        double yield = statistics.getYield(cost, winningCount);

        printResult(yield);
    }

    public static void publishNewLotto(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            userLottos.add(lotto);
            System.out.println(lotto);
        }
    }

    public static int inputCost(String userInput) {
        userInput = userInput.strip();
        int cost;

        try {
            cost = Integer.parseInt(userInput);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 가격은 숫자를 입력해주세요");
        }

        if (cost < 0)
            throw new IllegalArgumentException("[ERROR] 가격은 0 이상의 숫자여야만 합니다.");
        if (cost % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 가격은 1000원 단위로만 입력 가능합니다.");

        return cost;
    }

    public static List<Integer> inputWinningLottoNums(String userInput) {
        userInput = userInput.strip();
        String[] inputNums = userInput.split(",");
        List<Integer> lottoNums = new ArrayList<>();

        for (int i = 0; i < inputNums.length; i++) {
            try {
                int num = Integer.parseInt(inputNums[i]);
                lottoNums.add(num);
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("[ERROR] 로또번호에는 숫자와 ,만 입력해주세요");
            }
        }

        if (lottoNums.size() != 6)
            throw new IllegalArgumentException("[ERROR] 로또번호는 6개의 숫자를 입력해주세요");

        if (lottoNums.stream().anyMatch(x -> x > 45 || x < 1))
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        return lottoNums;
    }

    public static int inputWinningBonusNum(String userInput) {
        userInput = userInput.strip();
        int bonus;

        try {
            bonus = Integer.parseInt(userInput);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 보너스번호는 숫자를 입력해주세요");
        }

        if (bonus > 45 || bonus < 1)
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

        return bonus;
    }

    private static void printResult(double yield) {
        StringBuilder sb = new StringBuilder();

        sb.append("당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - ");
        sb.append(winningCount.get(4));
        sb.append("개\n" +
                "4개 일치 (50,000원) - ");
        sb.append(winningCount.get(3));
        sb.append("개\n" +
                "5개 일치 (1,500,000원) - ");
        sb.append(winningCount.get(2));
        sb.append("개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        sb.append(winningCount.get(1));
        sb.append("개\n" +
                "6개 일치 (2,000,000,000원) - ");
        sb.append(winningCount.get(0));
        sb.append("개\n" +
                "총 수익률은 ");
        sb.append(String.format("%,.1f", yield));
        sb.append("%입니다.");
        System.out.println(sb);
    }
}

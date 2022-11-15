package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        try {
            // TODO: 프로그램 구현
            int money = inputMoney();

            List<List<Integer>> boughtLottos = buyLottos(money);
            printLottos(boughtLottos);

            List<Integer> targetNumbers = inputTargetNumbers();
            Lotto targetLotto = new Lotto(targetNumbers); // 당첨번호 검증용
            int bonusNumber = inputBonusNumber(targetNumbers);

            printResult(boughtLottos, targetNumbers, bonusNumber, money);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printResult(List<List<Integer>> boughtLottos, List<Integer> targetNumbers,
                                    int bonusNumber, int money) {
        System.out.println("당첨 통계");
        System.out.println("---");

        Map<Prize, Integer> result = calculatePrize(boughtLottos, targetNumbers, bonusNumber);
        List<Prize> prizes = Arrays.asList(Prize.THREE, Prize.FOUR, Prize.FIVE, Prize.FIVE_BONUS, Prize.SIX);
        float profits = 0;
        for (Prize p : prizes) {
            System.out.println(p.getAnnounce() + " - " + result.getOrDefault(p, 0) + "개");
            profits += result.getOrDefault(p, 0) * p.getMoney();
        }

        System.out.println(String.format("총 수익률은 %.1f%%입니다.\n", profits / money * 100));
    }

    private static Map<Prize, Integer> calculatePrize(List<List<Integer>> boughtLottos,
                                                      List<Integer> targetNumbers, int bonusNumber) {
        Map<Prize, Integer> map = new HashMap<>(); // 3개 ~ 6개
        for (List<Integer> lotto : boughtLottos) {
            Prize result = Lotto.calculate(lotto, targetNumbers, bonusNumber);
            map.put(result, map.getOrDefault(result, 0) + 1);
        }

        return map;

    }

    private static void printLottos(List<List<Integer>> boughtLottos) {
        for (List<Integer> lotto : boughtLottos) {
            System.out.println(lotto);
        }
    }

    private static List<List<Integer>> buyLottos(int money) {
        int count = money / 1000;
        System.out.printf("\n%d개를 구매했습니다.\n", count);

        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> lotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lotto.sort(Comparator.naturalOrder());
            lottos.add(lotto);
        }

        return lottos;
    }

    private static int inputBonusNumber(List<Integer> targetNumbers) {
        System.out.println("\n보너스 번호를 입력해 주세요.");

        int bonusNumber = Integer.parseInt(Console.readLine());
        if (targetNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        }
        return bonusNumber;
    }

    private static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        int money;
        try {
            money = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자만 입력해야 합니다.");
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
        return money;
    }

    public static List<Integer> inputTargetNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");

        String[] input = Console.readLine().split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String s : input) {
            numbers.add(Integer.parseInt(s));
        }

        return numbers;
    }
}

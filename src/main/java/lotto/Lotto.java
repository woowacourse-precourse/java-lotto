package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // 예외 처리 (6개, 범위, 중복)
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        } else if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45까지의 숫자여야 합니다.");
        } else if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    // 입력 받기 (구입 금액, 당첨 번호, 보너스 번호)
    private int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
        validateMoney(money);
        return money;
    }

    private void validateMoney(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 로또 1장의 가격은 1,000원입니다.");
        } else if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 1,000원 단위로 구입 가능합니다.");
        }
    }

    private List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winingNumbers = Arrays.stream(camp.nextstep.edu.missionutils.Console.readLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validate(winingNumbers);
        return winingNumbers;
    }

    private int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
    }

    // 로또 발행
    public static List<Lotto> issueLotto(int money) {
        int count = money / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            //numbers.sort(Integer::compareTo);
            lottos.add(new Lotto(numbers));
        }
        printLottos(lottos);
        return lottos;
    }

    // 당첨 등수 확인
    private int win(Lotto winningNumbers, int bonusNumber) {
        int count = 0;
        for (int number : numbers) {
            if (winningNumbers.numbers.contains(number)) {
                count++;
            }
        }
        if (count == 6) {
            return 1;
        } else if (count == 5 && winningNumbers.numbers.contains(bonusNumber)) {
            return 2;
        }
        return 8 - count;
    }

    // 당첨 통계 출력
    public static void printStatistics(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        int[] statistics = new int[8];
        for (Lotto lotto : lottos) {
            statistics[lotto.win(winningNumbers, bonusNumber)-1]++;
        }
        System.out.println("3개 일치 (5,000원) - " + statistics[4] + "개");
        System.out.println("4개 일치 (50,000원) - " + statistics[3] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + statistics[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + statistics[1] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + statistics[0] + "개");
        System.out.println("총 수익률은 " + Statistics.calulateYield(
                statistics[0] * 2000000000 + statistics[1] * 30000000 + statistics[2] * 1500000 + statistics[3] * 50000 + statistics[4] * 5000,
                lottos.size() * 1000) + "%입니다.");
    }

    // 로또 출력
    private static void printLottos(List<Lotto> lottos) {
        System.out.println("8개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.numbers);
        }
    }
}

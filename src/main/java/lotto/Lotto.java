package lotto;

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
}

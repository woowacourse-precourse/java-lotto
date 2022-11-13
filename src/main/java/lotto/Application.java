package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int money = inputMoney();

        List<Integer> targetNumbers = inputTargetNumbers();
        Lotto targetLotto = new Lotto(targetNumbers); // 당첨번호 자동 검증
        int bonusNumber = inputBonusNumber(targetNumbers);

    }

    private static int inputBonusNumber(List<Integer> targetNumbers) {
        System.out.println("\n보너스 번호를 입력해 주세요.");

        int bonusNumber = Integer.parseInt(Console.readLine());
        if (targetNumbers.contains(bonusNumber)) {
            System.out.println("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }

    private static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        int money = Integer.parseInt(Console.readLine());
        if (money % 1000 != 0) {
            System.out.println("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
            throw new IllegalArgumentException();
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

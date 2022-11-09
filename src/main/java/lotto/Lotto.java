package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 당첨 번호는 6개만 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String str = Console.readLine();
        int bonusNum;
        try {
            bonusNum = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 보너스 번호는 숫자만 입력해주세요.");
            throw new IllegalArgumentException();
        }
        if (bonusNum < 0 || bonusNum > 45) {
            System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return bonusNum;
    }

    // TODO: 추가 기능 구현
}

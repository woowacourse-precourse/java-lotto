package lotto;

import camp.nextstep.edu.missionutils.Console;

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
            System.out.println("[ERROR] 당첨 번호는 6개만 입력해주세요.");
            throw new IllegalArgumentException();
        }
        Set<Integer> checkNumber = new HashSet<>(numbers);
        if (numbers.size() != checkNumber.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 서로 다른 숫자를 입력해주세요.");
        }
        for (int i : numbers) {
            if (i < 1 || i > 45) {
                System.out.println("[ERROR] 당첨 번호는 1부터 45까지의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String str = Console.readLine();
        return checkBonusNum(str);
    }

    public int checkBonusNum(String str) {
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
        if (numbers.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        return bonusNum;
    }
}

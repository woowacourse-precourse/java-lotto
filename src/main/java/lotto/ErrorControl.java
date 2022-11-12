package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ErrorControl {


    public void validateSeparatorAndSize(String[] input) {
        if (input.length != 6) {
            throw new MyIllegalArgumentException("[ERROR] 6개의 숫자를 ',' 로 구분해 입력해주세요.");
        }
    }

    public void validateNumberInRange(String number) {
        int convertNumber;
        try {
            convertNumber = Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            throw new MyIllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
        if (convertNumber < 1 | convertNumber > 45) {
            throw new MyIllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력해 주세요.");
        }
    }

    public int validateDuplicateNumber(List<Integer> winNumbers, int number) {
        if (winNumbers.contains(number)) {
            throw new MyIllegalArgumentException("[ERROR] 당첨 번호는 중복된 값을 가질 수 없습니다.");
        }
        return number;
    }

    public void validateNumber(String money) {
        try {
            Integer.parseInt(money);
        } catch (IllegalArgumentException e) {
            throw new MyIllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    public double validateDivideThousand(double money) {
        if (money % 1000 != 0) {
            throw new MyIllegalArgumentException("[ERROR] 1000단위의 숫자를 입력해 주세요.");
        }
        return money;
    }

    public void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new MyIllegalArgumentException("[ERROR] 로또 번호 개수는 6개여야 합니다.");
        }
    }

    public void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> numbersToCheck = new HashSet<>(numbers);
        if (numbers.size() != numbersToCheck.size()) {
            throw new MyIllegalArgumentException("[ERROR] 로또 번호는 중복된 값을 가질 수 없습니다.");
        }
    }

}
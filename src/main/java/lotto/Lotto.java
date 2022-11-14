package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> createNumbers) {
        validate(createNumbers);
        numbers = new ArrayList<>(createNumbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자만 입력 가능합니다.");
        }

        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
            }
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
            return numbers;
    }

    ///////////////////////////////////////////////////////////////////////
    private void validateOrderNumber(String userNumber) {
        if (!(userNumber.contains(","))) {
            System.out.println("[ERROR] 숫자 구분을 위한 쉼표가 필요합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void createLottoNumber(String number) {
        String[] orderNumbers = number.split(",");
        for (int i = 0; i < orderNumbers.length; i++) {
            numbers.add(Integer.valueOf(orderNumbers[i]));
        }
    }

    private void validateNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (!(numbers.get(i) >= 1 || numbers.get(i) <= 45)) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
            if (numbers.get(i) == 0) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }
}
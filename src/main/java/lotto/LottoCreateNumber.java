package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoCreateNumber {
    private final List<Integer> numbers = new ArrayList<>();
    private final String MESSAGE = "[ERROR]";

    public LottoCreateNumber(String orderNumber) {
        validateComma(orderNumber);
        createLottoNumber(orderNumber);
        validateNumbers(numbers);
        Collections.sort(numbers);
    }


    private void validateComma(String orderNumber) {

        if (!(orderNumber.contains(","))) {
            throw new IllegalArgumentException(MESSAGE + " 숫자 구분을 위한 쉼표가 필요합니다.");
        }
        int commaCount = 0;
        for (int i = 0; i < orderNumber.length(); i++) {
            if (orderNumber.charAt(i) == ',') {
                commaCount++;
            }
        }
        if (commaCount != 5) {
            throw new IllegalArgumentException(MESSAGE + " 숫자 구분을 위한 쉼표가 필요합니다.");
        }
    }

    private void createLottoNumber(String orderNumber) {
        String[] orderNumbers = orderNumber.split(",");
        try {
            for (int i = 0; i < orderNumbers.length; i++) {
                numbers.add(Integer.valueOf(orderNumbers[i]));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MESSAGE + " 숫자만 입력 가능합니다.");
        }
    }

    private void validateNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (!(numbers.get(i) >= 1 && numbers.get(i) <= 45)) {
                throw new IllegalArgumentException(MESSAGE + " 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            if (numbers.get(i) == 0) {
                throw new IllegalArgumentException(MESSAGE + " 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public List<Integer> getCreateNumber() {
        return numbers;
    }

}

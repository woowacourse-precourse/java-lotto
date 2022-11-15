package lotto;

import java.util.Collections;
import java.util.List;

import constant.Message;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        lengthCheck(numbers);
        duplicationCheck(numbers);
        ascendingOrderCheck(numbers);
        this.numbers = numbers;
    }

    private void lengthCheck(List<Integer> numbers) {
        if (isWrongSize(numbers)) {
            throw new IllegalArgumentException(Message.WrongSizeLottoNumbersMessage);
        }
    }

    private void duplicationCheck(List<Integer> numbers) {
        for (Integer num : numbers) {
            if (isDuplicated(numbers, num)) {
                throw new IllegalArgumentException(Message.DuplicationMessage);
            }
        }
    }

    private void ascendingOrderCheck(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) > numbers.get(i + 1)) {
                throw new IllegalArgumentException(Message.IsNotAscendingOrderMessage);
            }
        }
    }

    private boolean isWrongSize(List<Integer> numbers) {
        return numbers.size() != Message.LOTTOLENGTH;
    }

    private boolean isDuplicated(List<Integer> numbers, Integer num) {
        return Collections.frequency(numbers, num) != Message.ONETIME;
    }

    public List<Integer> getNumbers() {
        printLotto();
        return numbers;
    }

    // 로또 번호 안내 메시지 출력
    public void printLotto() {
        String lottoMessage = setPrintMessage();
        System.out.println(lottoMessage);
    }

    private String setPrintMessage() {
        // 괄호 추가 : [
        StringBuilder lottoNumberMessage = new StringBuilder(Message.StartSquareBrackets);

        // 로또 숫자 추가
        for (Integer num : numbers) {
            lottoNumberMessage.append(num.toString()).append(Message.CommaSpace);
        }

        // 쉼표 및 공백 제거
        lottoNumberMessage.delete(lottoNumberMessage.length() - 2, lottoNumberMessage.length());

        // 괄호 추가 : ]
        lottoNumberMessage.append(Message.EndSquareBrackets);
        return lottoNumberMessage.toString();
    }
}

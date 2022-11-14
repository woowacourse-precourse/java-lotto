package lotto.ExceptionChecker;

import java.util.List;
import java.util.NoSuchElementException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }


    public List<Integer> lottoReturn(){

        return numbers;

    }

    private void validateRange(List<Integer> numbers) {
        for (int i = 0 ; i < numbers.size() ; i++) {
            try {
                if (numbers.get(i) > 45 || numbers.get(i) == 0) {
                    throw new IllegalArgumentException();
                }

            } catch (Exception IllegalArgumentException) {
                System.out.println("[ERROR] 당첨 번호의 범위를 1~45사이에서 입력해주세요. ");
                IllegalArgumentException.printStackTrace();
                throw new NoSuchElementException();
            }
        }
    }


    private void validate(List<Integer> numbers) {

        try {
            if (numbers.size() != 6) {
                throw new IllegalArgumentException();
            }
        } catch (Exception IllegalArgumentException) {
            System.out.println("[ERROR] 6개의 숫자를 입력해주세요. ");//에러시 수행
            throw IllegalArgumentException; //최상위 클래스가 아니라면 무조건 던져주자
        }
    }



    // TODO: 추가 기능 구현
}

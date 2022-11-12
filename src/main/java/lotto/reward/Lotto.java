package lotto.reward;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Exception;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers; //인스턴스 변수

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Exception.catchException());
        }
    }

    //로또 숫자 6자리 입력하기
    private int[] inputPrizeNumbers() { //제네릭
        int[] prizeSixNumbers = new int[6];
        String memberInput = Console.readLine();
        String[] inputSixNumbers = memberInput.split(",");
        for (int i = 0; i < 6; i++){
            prizeSixNumbers[i] = Integer.parseInt(memberInput);
        }
        return prizeSixNumbers;
    }
    // TODO: 추가 기능 구현
}

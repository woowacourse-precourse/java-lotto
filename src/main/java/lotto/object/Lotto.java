package lotto.object;

import camp.nextstep.edu.missionutils.Console;
import lotto.input_output.Input;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto extends Input {
    private final List<Integer> numbers;    //로또를 시작할 때 사용자에게 입력받는 값

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    // TODO: 추가 기능 구현
    /*
    - 당첨 번호 입력 받아 numbers에 저장
     */

    public static void main(String[] args) {
        Lotto lotto = new Lotto(Lotto.returnList());
        System.out.println("numbers 사이즈: "+ lotto.numbers.size());
    }


}

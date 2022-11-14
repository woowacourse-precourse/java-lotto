package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현
    public static int amount(){
        int count=0;
        System.out.println("구입금액을 입력해 주세요.");
        try{
            count = Integer.parseInt(Console.readLine())/1000;
        }catch (NumberFormatException e){
            System.out.println(ExceptionType.numError.getName());
        }
        return count;
    }
}

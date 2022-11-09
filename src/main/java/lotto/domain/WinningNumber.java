package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    public static Lotto getWinningLotto(String number){
        List<Integer> numbers = stringToList(number);
        Lotto winningLotto = new Lotto(numbers);
        return winningLotto;
    }

    public static List<Integer> stringToList(String number){
        List<Integer> numbers = Arrays.stream(number.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return numbers;
    }

}

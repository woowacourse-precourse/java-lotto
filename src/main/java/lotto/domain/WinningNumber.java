package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    public Lotto saveWinningNumber(String input){
        List<Integer> winningNumber = numberToString(input);
        Lotto winning = new Lotto(winningNumber);
        return winning;
    }
    public List<Integer> numberToString(String input){
        List<Integer> winningNumber = Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
        return winningNumber;
    }
}

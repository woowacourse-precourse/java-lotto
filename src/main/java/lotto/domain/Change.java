package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Change {
    public static List<Integer> lottoNumber(String winningNumber) {
        List<String> newWinningNumber = Arrays.asList(winningNumber.split(","));
        List<Integer> result = new ArrayList<>();
        for (String number : newWinningNumber) {
            result.add(Integer.parseInt(number));
        }

        return result;
    }
}

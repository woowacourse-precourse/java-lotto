package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrizeNumber {

    public List<Integer> lottoNumber() {
        String inputnumber = Console.readLine();
        List<String> numbers = Arrays.asList(inputnumber.split(","));
        List<Integer> prizelotto = numbers.stream()
                .map(s -> Integer.valueOf(s))
                .collect(Collectors.toList());
        return prizelotto;
    }

}

package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PrizeNumber {

    Exception e = new Exception();
    public List<Integer> lottoNumber() {
        List<Integer> prizelotto = new ArrayList<>();
        String inputnumber = Console.readLine();
        try{
            List<String> numbers = Arrays.asList(inputnumber.split(","));
            prizelotto = numbers.stream()
                    .map(s -> Integer.valueOf(s))
                    .collect(Collectors.toList());
        } catch(Exception e){
            throw new IllegalArgumentException(Print.lottoNumberError());
        }
        return prizelotto;
    }

    public void sort(List<Integer> prizelotto){
        prizelotto.sort(Comparator.naturalOrder());
    }

    public Integer bonusNumber() {
        Integer bonus;
        try{
            bonus = Integer.valueOf(Console.readLine());
        } catch(Exception e){
            throw new IllegalArgumentException(Print.lottoNumberError());
        }
        return bonus;
    }
}

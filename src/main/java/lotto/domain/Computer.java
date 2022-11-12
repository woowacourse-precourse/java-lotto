package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.Exceptions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Computer {
    Exceptions exceptions = new Exceptions();

    public String inputNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        return numbers;
    }

    public String[] splitNumbers(String numbers) {
        String[] splitNum = new String[6];
        try {
            splitNum = numbers.split(",");
        } catch (Exception e) {
            exceptions.notSplitNumbers();
        }
        return splitNum;
    }

    public List<Integer> checkNumbers(String[] splitNum) {
        List<Integer> numbers= new ArrayList<>();
        int num = 0;
        for (String str : splitNum) {
            try {
                num = Integer.parseInt(str);
                numbers.add(num);
            } catch (Exception e) {
                exceptions.inputPriceError();
            }
            if(num<1 || num>45){
                exceptions.notScopeNumbers();
            }
        }
        return numbers;
    }

    public void checkDuplication(List<Integer> numbers){
        HashSet<Integer> set = new HashSet<>(numbers);
        if (set.size()<6) {
            exceptions.duplicationNumbers();
        }
    }
}

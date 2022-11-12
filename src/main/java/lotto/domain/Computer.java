package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.Exceptions;

import java.util.ArrayList;
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
}

package lotto.service;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class WinningNumMaker {

    public List<Integer> make() {

        List<Integer> tmp = new ArrayList<>();

        System.out.println("당첨 번호를 입력해 주세요.");

        String numbersAsString = Console.readLine();

        for (String inputString : numbersAsString.split(",")) {

            int input = toInt(inputString);
            rangeCheck(input);

            if (!tmp.contains(input)) {
                tmp.add(input);
            }
        }
        sizeCheck(tmp);

        return tmp;
    }


    private void sizeCheck(List<Integer> winningNumber) throws IllegalArgumentException {
        if (winningNumber.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
        }
    }

    private int toInt(String inputAsString) throws IllegalArgumentException {
        try {
            return Integer.parseInt(inputAsString);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정수값만 가능합니다.");
        }
    }

    private void rangeCheck(int input) throws IllegalArgumentException {
        if (input <= 0 || input > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}

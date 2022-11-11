package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class WinningNum {

    /**
     * 입력값 validation 로직 개발 필요
     * 도메인로직, 테스트 필요
     */
    List<Integer> winningNumber = new ArrayList<>();

    public List<Integer> getWinningNumber() {

        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumberAsString = Console.readLine();
        for (String inputAsString : winningNumberAsString.split(",")) {

            int input = toInt(inputAsString);
            rangeCheck(input);

            if (!winningNumber.contains(input)) {
                winningNumber.add(input);
            }
        }

        sizeCheck(winningNumber);
        return winningNumber;
    }


    private void sizeCheck(List<Integer> winningNumber) {
        if (winningNumber.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private int toInt(String inputAsString) {
        try {
            return Integer.parseInt(inputAsString);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void rangeCheck(int input) {
        if (input <= 0 || input > 45) {
            throw new IllegalArgumentException();
        }
    }
}
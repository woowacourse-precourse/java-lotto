package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Prize {
    private final List<Integer> numbers = new ArrayList<>();
    private final int bonusNumber = 0;
    private static final String INPUT_PRIZE_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public void inputPrize() {
        System.out.println(INPUT_PRIZE_NUMBER);
        String input = Console.readLine();

        //TODO: 입력 값에 대한 validation
        setNumbers(input);
    }

    public void inputBonus() {
        System.out.println(INPUT_BONUS_NUMBER);
        int input = Integer.parseInt(Console.readLine());

        //TODO: 입력 값에 대한 validation
    }

    private void setNumbers(String input) {
        String[] numbers = input.split(",");

        for (String number : numbers) {
            this.numbers.add(Integer.parseInt(number));
        }
    }
}

package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Prize {
    private static final String INPUT_PRIZE_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private final List<Integer> numbers = new ArrayList<>();
    private int bonusNumber = 0;

    public List<Integer> getPrize() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void inputPrize() {
        System.out.println("\n" + INPUT_PRIZE_NUMBER);
        String input = Console.readLine();

        //TODO: 입력 값에 대한 validation
        setNumbers(input);
    }

    public void inputBonus() {
        System.out.println("\n" + INPUT_BONUS_NUMBER);
        int input = Integer.parseInt(Console.readLine());

        //TODO: 입력 값에 대한 validation
        setBonusNumber(input);
    }

    private void setNumbers(String input) {
        String[] numbers = input.split(",");

        for (String number : numbers) {
            this.numbers.add(Integer.parseInt(number));
        }
    }

    private void setBonusNumber(int input) {
        this.bonusNumber = input;
    }
}

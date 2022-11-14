package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoAnswer {
    private Lotto winningNumber;
    private Integer bonusNumber;

    public LottoAnswer(String numbersCommand, String bonusCommand) throws IllegalArgumentException {
        List<Integer> numbers = commandToNumbers(numbersCommand);
        Integer bonus = commandToBonus(bonusCommand);

        winningNumber = new Lotto(numbers);
        bonusNumber = bonus;
    }

    private List<Integer> commandToNumbers(String numbersCommand) throws IllegalArgumentException {
        List<String> numbersString = Arrays.asList(numbersCommand.split(","));
        List<Integer> numbers = numbersString.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        return numbers;
    }

    private Integer commandToBonus(String bonusCommand) throws IllegalArgumentException {
        Integer bonus = Integer.parseInt(bonusCommand);

        return bonus;
    }
}

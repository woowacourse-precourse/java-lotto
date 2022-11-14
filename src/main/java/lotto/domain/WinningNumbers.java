package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final List<Integer> numbers;
    private final int bonus;

    public WinningNumbers(){
        numbers = initializeNumbers();
        bonus = initializeBonus();
    }

    private List<Integer> initializeNumbers(){
        System.out.println(Message.WINNING_NUMBERS_REQUEST);

        String numbersInput = Console.readLine();
        validateNumbers(numbersInput);

        List<Integer> numbers = new ArrayList<>();
        Arrays.stream(numbersInput.split(",")).forEach(v -> numbers.add(Integer.parseInt(v)));

        return numbers;
    }

    private int initializeBonus(){
        return 0;
    }

    private void validateNumbers(String numbersInput){

    }

    private void validateBonus(){

    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonus() {
        return bonus;
    }
}

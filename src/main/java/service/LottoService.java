package service;

import domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final List<Integer>numbers = new ArrayList<>();
    public Lotto createWinningNumber(String winningNumber) {
        String[] inputNumbers = winningNumber.split(",");
        for (String inputNumber : inputNumbers) {
            numbers.add(Integer.parseInt(inputNumber));
        }
        return new Lotto(numbers);
    }
}

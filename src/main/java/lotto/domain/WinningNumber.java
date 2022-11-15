package lotto.domain;

import lotto.service.Validate;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private List<Integer> number;

    private final Validate validate = new Validate();

    public WinningNumber(List<Integer> number) {
        validate(number);
        this.number = number;
    }

    public WinningNumber(String input) {
        List<Integer> winningNumber = new ArrayList<>();
        for(String s : input.split(",")) {
            validate.IsRightFormatWinningNumber(s);
            winningNumber.add(Integer.parseInt(s));
        }
        this.number = winningNumber;
    }

    public List<Integer> getWinningNumber() {
        return this.number;
    }

    private void validate(List<Integer> number) {
        validate.IsCorrectRangeWinningNumber(number);
        validate.IsDuplicatedWinningNumber(number);
        validate.IsOverLengthWinningNumber(number);
    }
}

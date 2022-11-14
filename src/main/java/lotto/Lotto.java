package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validate checkNumber = new Validate();
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LESS_SIZE_NUMBER.getErrorMessage());
        }
        checkNumber.validUserWinningNumber(numbers);
    }
    public void getResult(List<LottoPaper> lottoPapers, long money, int bonusNumber){
        long [] result = new long[8];
        String yield;
        GetRateOfReturn getRateOfReturn = new GetRateOfReturn();
        for (LottoPaper lottoPaper : lottoPapers) {
            result[lottoPaper.getResult(numbers, bonusNumber)]++;
        }
        PrintMachine.winningResult(result);
        yield = getRateOfReturn.calculateRate(result, money);
        PrintMachine.yieldOfLotto(yield);
    }
}

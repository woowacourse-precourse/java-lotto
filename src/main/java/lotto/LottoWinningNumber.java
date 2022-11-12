package lotto;

import lotto.util.InputUtil;
import lotto.util.MessageUtil;
import lotto.util.ValidationUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoWinningNumber {

    private final InputUtil inputUtil = new InputUtil();

    private final MessageUtil messageUtil = new MessageUtil();

    private final ValidationUtil validationUtil = new ValidationUtil();

    private List<Integer> winningNums;

    private Integer bonusNum;


    public LottoWinningNumber getWinningNumbersInfo() {
        this.winningNums = getWinningNumbers();
        this.bonusNum = getBonusNumbers();

        return this;
    }

    public List<Integer> getWinningNums() {
        return winningNums;
    }

    public Integer getBonusNum() {
        return bonusNum;
    }

    private List<Integer> getWinningNumbers() {
        messageUtil.printWinningInput();
        String winningNums = inputUtil.getUserInput();
        String[] winningAmount = validationUtil.validateWinningAmount(winningNums);

        return Arrays.stream(winningAmount)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int getBonusNumbers() {
        messageUtil.printBonusInput();
        int bonusNum = Integer.parseInt(inputUtil.getUserInput());
        validationUtil.validateBonusRange(bonusNum);

        return bonusNum;
    }
}

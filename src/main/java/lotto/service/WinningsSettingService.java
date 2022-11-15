package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.printer.RequestInputPrinter;
import lotto.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.error.ErrorMessage.*;

public class WinningsSettingService {

    private static final Integer SIZE = 6;

    private List<Integer> winningsNumber;

    private Integer bonusNumber;

    public List<Integer> getWinningsNumber() {
        return this.winningsNumber;
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }


    public void settingWinningsInfo() throws IllegalArgumentException {
        this.winningsNumber = bringWinningsNumber();
        this.bonusNumber = bringBonusNumber();
    }

    private Integer bringBonusNumber() throws IllegalArgumentException {
        String input = enterBonusNumber();

        bonusNumberValidate(input);
        return Integer.parseInt(input);
    }

    private List<Integer> bringWinningsNumber() throws IllegalArgumentException {
        String[] winningsNumber = enterWinningsNumber().split(",");
        winningsNumberValidate(winningsNumber);

        return Arrays.stream(winningsNumber)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private String enterBonusNumber() {
        RequestInputPrinter.bonusNumberInputGuide();
        return Console.readLine();
    }

    private String enterWinningsNumber() {
        RequestInputPrinter.winningNumberInputGuide();
        return Console.readLine();
    }

    private void bonusNumberValidate(String bonusNumber) throws IllegalArgumentException {
        bonusInWinningsNumber(bonusNumber);
        bonusNumberOverSize(bonusNumber);
        bonusNumberIsDigit(bonusNumber);
        bonusNumberRangeCheck(bonusNumber);
    }

    private void bonusInWinningsNumber(String bonusNumber) throws IllegalArgumentException {
        if (winningsNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_IN_WINNINGS_NUMBER.getMessage());
        }
    }

    private void bonusNumberOverSize(String bonusNumber) throws IllegalArgumentException {
        if (bonusNumber.isBlank() || bonusNumber.length() > 2) {
            throw new IllegalArgumentException(BONUS_NUMBER_OVERSIZE.getMessage());
        }
    }

    private void bonusNumberIsDigit(String bonusNumber) throws IllegalArgumentException {
        if (!StringUtils.isDigit(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_NOT_NUMBER.getMessage());
        }
    }

    private void bonusNumberRangeCheck(String bonusNumber) throws IllegalArgumentException {
        int number = Integer.parseInt(bonusNumber);
        if (!(1 <= number && number <= 45)) {
            throw new IllegalArgumentException(BONUS_NUMBER_OUF_OF_RANGE.getMessage());
        }
    }

    private void winningsNumberValidate(String[] winningsNumber) throws IllegalArgumentException {
        winningsNumberOverSize(winningsNumber);
        winningsNumberIsDigit(winningsNumber);
        winningsNumberRangeCheck(winningsNumber);
    }

    private void winningsNumberOverSize(String[] winningsNumber) throws IllegalArgumentException {
        if (winningsNumber.length != SIZE) {
            throw new IllegalArgumentException(WINNING_NUMBER_OVERSIZE.getMessage());
        }
    }

    private void winningsNumberIsDigit(String[] winningsNumber) throws IllegalArgumentException {
        for (int i = 0; i < SIZE; i++) {
            if (!StringUtils.isDigit(winningsNumber[i])) {
                throw new IllegalArgumentException(WINING_NUMBER_NOT_NUMBER.getMessage());
            }
        }
    }

    private void winningsNumberRangeCheck(String[] winningsNumber) throws IllegalArgumentException {
        for (int i = 0; i < SIZE; i++) {
            int number = Integer.parseInt(winningsNumber[i]);
            if (!(1 <= number && number <= 45)) {
                throw new IllegalArgumentException(WINNING_NUMBER_OUT_OF_RANGE.getMessage());
            }
        }
    }

}

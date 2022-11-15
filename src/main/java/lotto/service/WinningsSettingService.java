package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.printer.RequestInputPrinter;

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

    private void bonusNumberValidate(String bonusNumber) {
        if (bonusNumber.isBlank() || bonusNumber.length() > 2) {
            throw new IllegalArgumentException(BONUS_NUMBER_OVERSIZE.getMessage());
        }
        if (!isDigit(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_NOT_NUMBER.getMessage());
        }

    }

    private boolean isDigit(String bonusNumber) {
        return bonusNumber.chars()
            .allMatch(Character::isDigit);
    }

    private void winningsNumberValidate(String[] winningsNumber) throws IllegalArgumentException {
        if (winningsNumber.length != SIZE) {
            throw new IllegalArgumentException(WINNING_NUMBER_OVERSIZE.getMessage());
        }
        for (int i = 0; i < SIZE; i++) {
            if (!isDigit(winningsNumber[i])) {
                throw new IllegalArgumentException(WINING_NUMBER_NOT_NUMBER.getMessage());
            }
        }
    }

}

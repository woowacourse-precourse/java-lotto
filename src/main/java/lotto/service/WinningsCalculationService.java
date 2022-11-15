package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.printer.RequestInputPrinter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningsCalculationService {

    private static final Integer SIZE = 6;

    private List<Integer> winningsNumber;

    private Integer bonusNumber;

    public List<Integer> getWinningsNumber() {
        return this.winningsNumber;
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }


    public void settingWinningsInfo() {
        this.winningsNumber = bringWinningsNumber();
        this.bonusNumber = bringBonusNumber();
    }

    private Integer bringBonusNumber() throws IllegalArgumentException {
        String input = enterBonusNumber();
        if (bonusNumberValidate(input)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }

    private List<Integer> bringWinningsNumber() throws IllegalArgumentException {
        String[] winningsNumber = enterWinningsNumber().split(",");
        if(!winningsNumberValidate(winningsNumber)) {
            throw new IllegalArgumentException();
        }

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

    private boolean bonusNumberValidate(String bonusNumber) {
        if (bonusNumber.isBlank() || bonusNumber.length() > 2) {
            return false;
        }
        return isDigit(bonusNumber);
    }

    private boolean isDigit(String bonusNumber) {
        return bonusNumber.chars()
            .allMatch(Character::isDigit);
    }

    private boolean winningsNumberValidate(String[] winningsNumber) {
        if (winningsNumber.length != SIZE) {
            return false;
        }
        return true;
    }

}

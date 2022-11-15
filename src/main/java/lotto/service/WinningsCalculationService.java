package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.User;
import lotto.printer.RequestInputPrinter;
import lotto.printer.SystemGuidePrinter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningsCalculationService {

    private final Integer SIZE = 6;

    private User user;

    public WinningsCalculationService(User user) {
        this.user = user;
    }

    private List<Integer> getWinningsNumber() throws IllegalArgumentException {
        String[] winningsNumber = enterWinningsNumber().split(",");
        if(!winningsNumberValidate(winningsNumber)) {
            throw new IllegalArgumentException();
        }

        return Arrays.stream(winningsNumber)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private String enterWinningsNumber() {
        RequestInputPrinter.winningNumberInputGuide();
        return Console.readLine();
    }

    private boolean winningsNumberValidate(String[] winningsNumber) {
        if (winningsNumber.length != SIZE) {
            return false;
        }
        return true;
    }

}

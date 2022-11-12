package lotto.ui.Input;

import lotto.WinningNumber;

public interface ParameterInput {
    String read();

    int readQuantityFromMoney();
    WinningNumber readWinningNumber();

}

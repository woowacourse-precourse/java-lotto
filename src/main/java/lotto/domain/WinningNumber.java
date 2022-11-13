package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {
    private Lotto winningNumber;

    public void inputWinningNumber(String input) {
        winningNumber = new Lotto(input);
    }
}

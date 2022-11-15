package lotto;

import java.util.Collections;
import java.util.List;

public class LottoException {

    public void inputException() throws IllegalArgumentException {
        throw new IllegalArgumentException();
    }

    public void WinningException(String winningNumber) throws IllegalArgumentException {
        String[] winningNumbers = winningNumber.split(",");
        for (String number : winningNumbers) {
            int count = Collections.frequency(List.of(winningNumbers), number);
            if (count > 1) {
                throw new IllegalArgumentException();
            }
        }
    }
}

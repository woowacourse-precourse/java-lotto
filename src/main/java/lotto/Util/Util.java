package lotto.Util;

import java.util.ArrayList;
import java.util.List;
import lotto.Exception.Exception;

public class Util {

    Exception exception = new Exception();

    public List<Integer> splitStringToIntegerArray(String inputtedString) {
        List<Integer> listedinputtedString = new ArrayList<>();
        String[] unconvertedWinningNumber = inputtedString.split(",");

        for (String unconvertedWinningNumberContent : unconvertedWinningNumber) {
            listedinputtedString.add(Integer.parseInt(unconvertedWinningNumberContent));
        }

        return listedinputtedString;
    }

    public void checkNumberRange(int number) throws IllegalArgumentException {
        if (number<1||number>45) {
            exception.throwInvalidNumberRangeException();
        }
    }

    public void checkWinningNumberValidation(List<Integer> winningNumber) {
        if (winningNumber.size()!=6) {
            exception.throwInvalidSizeException();
        }
        for (int winningNumberContent : winningNumber ) {
            checkNumberRange(winningNumberContent);
        }
    }
}

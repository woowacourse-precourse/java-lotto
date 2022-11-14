package lotto.domain;

import lotto.exception.CheckBonusDuplicationException;
import lotto.exception.CheckLottoDuplicationException;
import lotto.exception.CheckNumberRangeException;

import java.util.*;

import static lotto.view.InputLottoView.printInputLottoBonusNumber;
import static lotto.view.InputLottoView.printInputLottoNumber;

public class LottoNumber {
    private static final int LOTTO_MAX_SIZE = 6;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int ZERO = 0;

    public static List<Integer> getLottoNumbers() {
        List<Integer> checkThis = makeInputToNumber(printInputLottoNumber());
        checkListRange(checkThis);
        checkDuplicateInList(checkThis);
        return checkThis;
    }

    private static List<Integer> makeInputToNumber(String lineNumber) {
        return sortListUpper(lottoStringToInt(cutInput(removeWhiteSpace(lineNumber))));
    }

    private static String removeWhiteSpace(String existWhiteSpace) {
        return existWhiteSpace.replaceAll("\\s", "");
    }

    private static String[] cutInput(String lineNumber) {
        return lineNumber.split(",");
    }

    private static List<Integer> lottoStringToInt(String[] cutInput) {
        List<Integer> cutLottoNumber = new ArrayList<>();
        for (String s : cutInput) {
            cutLottoNumber.add(Integer.parseInt(s));
        }
        return cutLottoNumber;
    }

    public static int getBonusNumber() {
        return returnBonusToInt(printInputLottoBonusNumber());
    }

    private static int returnBonusToInt(String bonusInput) {
        return Integer.parseInt(bonusInput);
    }

    public static void checkBonusDuplicate(List<Integer> lotto, int bonusNum) {
        if (lotto.contains(bonusNum))
            throw new CheckBonusDuplicationException();
    }

    public static List<Integer> sortListUpper(List<Integer> sortYet) {
        List<Integer> sortComplete = new ArrayList<>();
        Collections.sort(sortYet);
        sortComplete = sortYet;
        return sortComplete;
    }

    private static void checkListRange(List<Integer> inputLottoNumbers) {
        for (int i = 0; i < LOTTO_MAX_SIZE; i++) {
            if (inputLottoNumbers.get(i) < LOTTO_MIN_NUMBER)
                throw new CheckNumberRangeException();
            if (inputLottoNumbers.get(i) > LOTTO_MAX_NUMBER)
                throw new CheckNumberRangeException();
        }
    }

    private static void checkDuplicateInList(List<Integer> inputLottoNumbers) {
        Set<Integer> checkDuplication = new HashSet<>(inputLottoNumbers);
        if (checkDuplication.size() != inputLottoNumbers.size())
            throw new CheckLottoDuplicationException();
    }
}

package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.view.InputLottoView.printInputLottoBonusNumber;
import static lotto.view.InputLottoView.printInputLottoNumber;

public class LottoNumber {
    private static final int LOTTO_MAX_SIZE = 6;
    private static final int ZERO = 0;

    public static List<Integer> getLottoNumbers(){
        return makeInputToNumber(printInputLottoNumber());
    }

    private static List<Integer> makeInputToNumber(String lineNumber) {
        return sortListUpper(lottoStringToInt(cutInput(removeWhiteSpace(lineNumber))));
    }

    private static String removeWhiteSpace(String existWhiteSpace){
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

    public static int getBonusNumber(){
        return returnBonusToInt(printInputLottoBonusNumber());
    }

    private static int returnBonusToInt(String bonusInput) {
        return Integer.parseInt(bonusInput);
    }

    public static List<Integer> sortListUpper(List<Integer> sortYet){
        List<Integer> sortComplete = new ArrayList<>();
        Collections.sort(sortYet);
        sortComplete = sortYet;
        return sortComplete;
    }
}

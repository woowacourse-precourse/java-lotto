package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import util.message.ErrorMessage;


public class ReceiveView {
    private static final String NUMBER_REGEX = "^[0-9]*$";
    private static final String WIN_LOTTO_REGEX = "^[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+$";
    private static final String WIN_LOTTO_SEPARATE = ",";

    public static int purchaseLotto() {
        String money = Console.readLine();
        purchaseLottoValid(money);
        return Integer.parseInt(money);
    }

    public static void purchaseLottoValid(String money){
        if (!isDigit(money)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_STRING_MONEY);
        }
    }

    private static boolean isDigit(String input) {
        if (!Pattern.matches(NUMBER_REGEX, input)) {
            return false;
        }
        return true;
    }

    public static List<Integer> winLotto() {
        String inputWinLotto = Console.readLine();
        winLottoValid(inputWinLotto);
        List<Integer> winLotto = splitInputWinLotto(inputWinLotto);
        return winLotto;
    }

    private static List<Integer> splitInputWinLotto(String inputWinLotto) {
        List<Integer> winLotto = new ArrayList<>();
        String[] splitWinLotto = inputWinLotto.split(WIN_LOTTO_SEPARATE);
        for (String winLottoNum : splitWinLotto) {
            winLotto.add(Integer.parseInt(winLottoNum));
        }
        return winLotto;
    }

    public static void winLottoValid(String winLottoInput) {
        if (!isCorrectInput(winLottoInput)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_WIN_LOTTO);
        }
    }

    private static boolean isCorrectInput(String winLottoInput) {
        if (!winLottoInput.matches(WIN_LOTTO_REGEX)) {
            return false;
        }
        return true;
    }

    public static int bonusNumber() {
        String bonusNumber = Console.readLine();
        isDigit(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }





}

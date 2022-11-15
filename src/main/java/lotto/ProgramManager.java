package lotto;

import lotto.console.OutputManager;
import lotto.console.InputManager;
import lotto.manageLotto.LottoManager;

import java.util.List;
import java.util.Map;

// 로또 게임 진행자
public class ProgramManager {

    public static final int LOTTO_PRICE = 1000;

    private static int price;
    private static int numberOfLotto;
    public static List<Integer> userPredictLottoNumbers;
    public static int userPredictBonusNumber;

    public static List<List<Integer>> lotto;
    public static Map<String, Integer> lottoRankResult;
    public static float lottoRevenueRate;

    /**
     * TODO: 로또 게임 실행부
     */
    public static void playLottoGame() {
        buyLotto();

        lotto = LottoManager.generateLotto(numberOfLotto);
        OutputManager.printLotto(numberOfLotto);

        setUserPredictLottoNumbers();
        setUserPredictBonusNumber();

        lottoRankResult = LottoManager.getLottoRankResult(userPredictLottoNumbers, userPredictBonusNumber);
        lottoRevenueRate = LottoManager.getRevenueRate(price, lottoRankResult);

        OutputManager.printLottoStatistics();
    }

    private static void buyLotto() {
        OutputManager.askPrice();
        try {
            price = InputManager.getInput_price();
        } catch (IllegalArgumentException exception) {
            OutputManager.printErrorMessage_wrongPriceValue();
        }
        numberOfLotto = price / LOTTO_PRICE;
        OutputManager.printNumberOfLottoMessage(numberOfLotto);
    }

    private static void setUserPredictLottoNumbers() {
        OutputManager.askPredictLottoNumber();
        try {
            userPredictLottoNumbers = InputManager.getInput_predictLottoNumbers();
        } catch (IllegalArgumentException exception) {
            OutputManager.printErrorMessage_wrongLottoValue();
        }
    }

    private static void setUserPredictBonusNumber() {
        OutputManager.askPredictBonusNumber();
        try {
            userPredictBonusNumber = InputManager.getInput_predictBonusLottoNumber();
        } catch (IllegalArgumentException exception) {
            OutputManager.printErrorMessage_wrongBonusValue();
        }
    }

}

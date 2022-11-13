package lotto;

import java.util.List;

// 로또 게임 진행자
public class ProgramManager {

    private static final int LOTTO_PRICE = 1000;

    private static final String ASK_PRICE = "구입금액을 입력해 주세요.";
    private static final String ASK_PREDICT_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String ASK_PREDICT_LOTTO_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private static final String LOTTO_STATISTICS_MESSAGE = "당첨 통계\n---";

    private static int price;
    private static int numberOfLotto;
    private static List<Integer> userPredictLottoNumbers;
    private static List<List<Integer>> lotto;
    private static List<Integer> lottoResult;
    private static int lottoRevenueRate;

    public static void playLottoGame() {
        buyLotto();

        lotto = LottoManager.generateLotto(numberOfLotto);
        printLotto();

        getUserPredictLottoNumbers();

        getLottoStatistics();

        printLottoStatistics();
    }

    private static void buyLotto() {
        System.out.println(ASK_PRICE);
        price = UserManager.getPrice();
        numberOfLotto = price / LOTTO_PRICE;
    }

    private static void printLotto() {
    }

    private static void getUserPredictLottoNumbers() {
        // 당첨 번호 입력받기
        System.out.println(ASK_PREDICT_LOTTO_NUMBER);
        userPredictLottoNumbers = UserManager.getPredict_lottoNumber();

        // 보너스 번호 입력받기
        System.out.println(ASK_PREDICT_LOTTO_BONUS_NUMBER);
        userPredictLottoNumbers.add(UserManager.getPredict_bonusLottoNumber());
    }

    private static void getLottoStatistics() {
        lottoResult = LottoManager.getLottoResult(userPredictLottoNumbers);
        lottoRevenueRate = LottoManager.getRevenueRate(price);
    }

    private static void printLottoStatistics() {
        System.out.println(LOTTO_STATISTICS_MESSAGE);
    }

}

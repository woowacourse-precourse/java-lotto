package lotto.Message;

import lotto.LottoPlace;
import lotto.User;
import lotto.WinningResult;

import java.text.DecimalFormat;
import java.util.List;

public class NormalMessage {
    public static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String BUY_MESSAGE = "개를 구매했습니다.";
    public static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String BASE_RESULT_MESSAGE = "당첨통계" + "\n" + "---";

    public static void printMoneyInputMessage() {
        System.out.println(MONEY_INPUT_MESSAGE);
    }

    public static void printBuyMessage(User user) {
        System.out.println();
        System.out.println(user.getLottoQuantity().toString() + BUY_MESSAGE);
        System.out.println(user.makeLottoNumbers());
    }

    public static void printWinningNumberInputMessage() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
    }

    public static void printBonusNumberInputMessage() {
        System.out.println();
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public static void printResultMessage(WinningResult winningResult) {
        System.out.println();
        System.out.println(BASE_RESULT_MESSAGE);

        List<Integer> lottoWinningNumbers = winningResult.getWinningResult();
        String resultMessage = makeResultMessage(lottoWinningNumbers);
        System.out.print(resultMessage);
        System.out.print("총 수익률은 " + winningResult.getYield() + "%입니다.");
    }

    public static String makeResultMessage(List<Integer> lottoWinningNumbers) {
        final int SECOND_PLACE = 3;
        DecimalFormat formatter = new DecimalFormat("###,###,###,###,###,###");
        String resultOutput = "";
        for (int place = 0; place < lottoWinningNumbers.size(); place++) {
            resultOutput += LottoPlace.values()[place].getMatchNumbers() + "개 일치";

            // 2등
            if (place == SECOND_PLACE) {
                resultOutput += ", 보너스 볼 일치";
            }
            resultOutput += " (" + formatter.format(LottoPlace.values()[place].getWinMoney()) + "원)";
            resultOutput += " - " + lottoWinningNumbers.get(place) + "개" + "\n";
        }
        return resultOutput;
    }
}

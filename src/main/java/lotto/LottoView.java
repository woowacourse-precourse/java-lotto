package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningType;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoView {
    private static final String BUY_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BUY_NUMBER_MESSAGE = "{0}개를 구매했습니다.";
    private static final String REQUEST_WINNING_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String STATISTICS_INFO_MESSAGE = "당첨 통계\n---";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 {0,number,#.#}%입니다.";
    private static final String BLANK_LINE = "\n";
    public static final List<String> PRIZE_DESC = WinningType.getDescList();

    public static void printWinningLottoRequest() {
        System.out.println(BLANK_LINE + REQUEST_WINNING_LOTTO_MESSAGE);
    }

    public static void printBonusNumberRequest() {
        System.out.println(BLANK_LINE + REQUEST_BONUS_NUMBER_MESSAGE);
    }

    public static void printBuyRequest() {
        System.out.println(BUY_REQUEST_MESSAGE);
    }

    public static void printBuyNumber(int count) {
        String message = MessageFormat.format(BUY_NUMBER_MESSAGE, count);
        System.out.println(BLANK_LINE + message);
    }

    public static void printLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto);
        }
    }

    public static void printWinningStatistics(List<Integer> result, double returnRate) {
        System.out.println(STATISTICS_INFO_MESSAGE);
        printResultOfWin(result);
        System.out.println(MessageFormat.format(RATE_OF_RETURN_MESSAGE, returnRate));
    }

    private static void printResultOfWin(List<Integer> result) {
        for (int pride = 5; pride > 0; pride--) {
            int prideIndex = 5 - pride;
            String message = MessageFormat.format(PRIZE_DESC.get(prideIndex), result.get(prideIndex));
            System.out.println(message);
        }
    }
}
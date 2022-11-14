package lotto.domain;

import lotto.domain.Preprocessor;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Preprocessor.*;


public class Guide {
    public static void printGetMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoCount(int LottoCount) {
        System.out.println("\n" + Integer.toString(LottoCount) + "개를 구매했습니다.");
    }

    public static void printGetWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void printGetBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printBoughtLottoList(List<Lotto> boughtLotto) {
        for (Lotto lotto : boughtLotto) {
            System.out.println(lotto.getLotto());
        }
    }

    public static List<String> createLottoStatisticsMessage(List<Integer> lottoResult) {
        List<String> messages = new ArrayList<String>();
        for (Prize prize : Prize.values()) {
            if (prize == Prize.NONE) {
                break;
            }
            String message = convertIntToString(prize.getMatchingCount()) + "개 일치";
            if (prize == Prize.SECOND) {
                message += ", 보너스 볼 일치";
            }
            messages.add(message + " (" + addNumberPunctuation(prize.getPrizeMoney()) +
                    "원) - " + convertIntToString(lottoResult.get(prize.ordinal())) + "개");
        }
        return messages;
    }

    public static void printLottoStatistics(List<String> messages) {
        System.out.println("\n당첨 통계\n---");
        for (int messageIndex = messages.size() - 1; messageIndex >= 0; messageIndex--) {
            System.out.println(messages.get(messageIndex));
        }
    }

    public static void printRateOfReturn(double rateOfReturn, int decimalPlace) {
        String result = String.format("총 수익률은 %s%% 입니다.",
                getRoundDecimalPlaceNumber(rateOfReturn, decimalPlace));
        System.out.println(result);
    }
}

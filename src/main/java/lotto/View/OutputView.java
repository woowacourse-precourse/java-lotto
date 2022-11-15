package lotto.View;

import lotto.Utils.Constants.MatchNumber;
import lotto.Utils.Validator.ListValidator;

import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class OutputView {


    public static void moneyPrizes(int match, String prize, int count) {

        if (Objects.equals(prize, MatchNumber.FIVE_BONUS_MATCH.getMoneyAsString())) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n", match, prize, count);
        }
        if (!Objects.equals(prize, MatchNumber.FIVE_BONUS_MATCH.getMoneyAsString())) {
            System.out.printf("%d개 일치 (%s원) - %d개%n", match, prize, count);
        }
    }

    public static void prizes(List<Integer> moneyList) {
        moneyPrizes(3, MatchNumber.THREE_MATCH.getMoneyAsString(), Collections.frequency(moneyList, MatchNumber.THREE_MATCH.getMoneyAsInt()));
        moneyPrizes(4, MatchNumber.FOUR_MATCH.getMoneyAsString(), Collections.frequency(moneyList, MatchNumber.FOUR_MATCH.getMoneyAsInt()));
        moneyPrizes(5, MatchNumber.FIVE_MATCH.getMoneyAsString(), Collections.frequency(moneyList, MatchNumber.FIVE_MATCH.getMoneyAsInt()));
        moneyPrizes(5, MatchNumber.FIVE_BONUS_MATCH.getMoneyAsString(), Collections.frequency(moneyList, MatchNumber.FIVE_BONUS_MATCH.getMoneyAsInt()));
        moneyPrizes(6, MatchNumber.SIX_MATCH.getMoneyAsString(), Collections.frequency(moneyList, MatchNumber.SIX_MATCH.getMoneyAsInt()));
    }

    public static void yield(float yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield * 100);
    }

    public static void lottoNumber(List<List<Integer>> lottoBox) {
        for (List<Integer> lottoNumber : lottoBox) {
            ListValidator.length(lottoNumber);
//            Collections.sort(lottoNumber);
            System.out.println(lottoNumber);
        }

    }
}

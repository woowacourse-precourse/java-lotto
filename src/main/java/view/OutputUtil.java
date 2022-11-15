package view;

import domain.Lotto;
import domain.LottoRank;
import domain.Lottos;
import domain.Result;
import dto.LottoDto;
import dto.LottosDto;
import dto.ResultDto;

import java.util.List;
import java.util.Map;

public class OutputUtil {
    public static final int MIN_HIT = 3;
    public static final int MAX_HIT = 6;
    private static final String START_STATISTICS = "\n당첨통계\n---";
    private static final String PURCHASE_INPUT = "구입금액을 입력해 주세요.";
    private static String PURCHASE_RESULT = "개를 구매했습니다.";
    private static final String WINNING_NUMBER_NOTICE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NOTICE = "\n보너스 번호를 입력해 주세요.";

    public static void noticePurchase() {
        System.out.println(PURCHASE_INPUT);
    }

    public static void showPurchaseResult(LottosDto lottosDto) {
        List<Lotto> lottos = lottosDto.lottos;
        Integer size = lottos.size();

        PURCHASE_RESULT = "\n" + Integer.toString(size) + PURCHASE_RESULT;
        System.out.println(PURCHASE_RESULT);
        for (Lotto lotto : lottos) {
            LottoDto lottoDto = lotto.sendDto();
            List<Integer> numbers = lottoDto.numbers;
            System.out.println(numbers);
        }
    }

    public static void winningNumberNotice() {
        System.out.println(WINNING_NUMBER_NOTICE);
    }

    public static void noticeBonus() {
        System.out.println(BONUS_NOTICE);
    }

    public static void showResult(Result result) {
        System.out.println(START_STATISTICS);
        Map<LottoRank, Integer> statistics = result.sendDto().statistics;
        for (Map.Entry<LottoRank, Integer> pair : statistics.entrySet()) {
            LottoRank rank = pair.getKey();
            Integer number = pair.getValue();
            if (rank == LottoRank.MISS) continue;
            if (rank == LottoRank.SECOND) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%d원) - %d개\n", rank.hitNumber, rank.money, number);
                continue;
            }
            System.out.printf("%d개 일치 (%d원) - %d개\n", rank.hitNumber, rank.money, number);
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", result.calcEarningRate());
    }
}

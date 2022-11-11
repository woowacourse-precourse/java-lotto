package lotto.view;

import lotto.dto.GameResultResponseDtos;
import lotto.dto.LottosResponseDto;

import java.text.DecimalFormat;
import java.util.List;

import static lotto.dto.GameResultResponseDtos.*;
import static lotto.dto.LottosResponseDto.*;

public class OutputView {

    public static final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_ANSWER_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String WINNING_STATISTICS_MESSAGE = "당첨 통계\n" + "---";
    public static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    public static final String SAME_NUMBER_COUNT_MESSAGE = "%d개 일치";
    public static final String BONUS_NUMBER_MESSAGE = ", 보너스 볼 일치";
    public static final String WINNER_PRICE_MESSAGE = " (%s원) ";
    public static final String TOTAL_COUNT_MESSAGE = "- %d개\n";
    public static final String MONEY_DECIMAL_FORMAT = "###,###,###,###";
    public static final String EARNING_RATE_MESSAGE = "총 수익률은 %f%%입니다.";

    public static void printInputPurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE_MESSAGE);
    }

    public static void printPurchaseLottos(LottosResponseDto responseDto) {
        List<LottoResponseDto> lottoResponseDtos = responseDto.getLottoResponseDtos();
        printLottoCount(lottoResponseDtos.size());

        for (LottoResponseDto lottosResponseDto : lottoResponseDtos) {
            System.out.println(lottosResponseDto.getLottoNumber());
        }
    }

    private static void printLottoCount(int lottoCount) {
        System.out.printf(LOTTO_COUNT_MESSAGE, lottoCount);
    }

    public static void printInputAnswerNumbers() {
        System.out.println(INPUT_ANSWER_NUMBERS_MESSAGE);
    }

    public static void printInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

    public static void printWinningStatisticsMessage() {
        System.out.println(WINNING_STATISTICS_MESSAGE);
    }

    public static void printWinningStatistics(GameResultResponseDtos responseDto) {
        StringBuilder result = new StringBuilder();

        List<GameResultResponseDto> resultDtos = responseDto.getGameResultResponseDtos();
        for (GameResultResponseDto dto : resultDtos) {
            result.append(createStatisticsString(dto));
        }

        System.out.println(result);
        printEarningRate(responseDto.getEarningRate());
    }

    public static String createStatisticsString(GameResultResponseDto dto) {
        StringBuilder statistics = new StringBuilder();

        statistics.append(String.format(SAME_NUMBER_COUNT_MESSAGE, dto.getSameNumberCount()));
        if (dto.isBonus()) {
            statistics.append(BONUS_NUMBER_MESSAGE);
        }
        statistics.append(String.format(WINNER_PRICE_MESSAGE, toMoneyFormat(dto.getWinnerPrice())));
        statistics.append(String.format(TOTAL_COUNT_MESSAGE, dto.getTotalCount()));
        return statistics.toString();
    }

    public static String toMoneyFormat(int money) {
        DecimalFormat dc = new DecimalFormat(MONEY_DECIMAL_FORMAT);
        return dc.format(money);
    }

    private static void printEarningRate(double earningRate) {
        System.out.printf(EARNING_RATE_MESSAGE, earningRate);
    }
}

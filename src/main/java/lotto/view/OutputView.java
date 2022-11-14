package lotto.view;

import lotto.dto.GameResultResponseDtos;
import lotto.dto.LottoResponseDtos;

import java.text.DecimalFormat;
import java.util.List;

import static lotto.dto.GameResultResponseDtos.*;
import static lotto.dto.LottoResponseDtos.*;
import static lotto.view.OutputMessage.*;

public class OutputView {

    public static void printBlankLine() {
        System.out.println();
    }

    public static void printInputPurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE_MESSAGE.getMessage());
    }

    public static void printPurchaseLottos(LottoResponseDtos responseDto) {
        List<LottoResponseDto> lottoResponseDtos = responseDto.getLottoResponseDtos();
        printLottoCount(lottoResponseDtos.size());

        for (LottoResponseDto lottosResponseDto : lottoResponseDtos) {
            System.out.println(lottosResponseDto.getLottoNumber());
        }
    }

    private static void printLottoCount(int lottoCount) {
        System.out.printf(LOTTO_COUNT_MESSAGE.getMessage(), lottoCount);
    }

    public static void printInputAnswerNumbers() {
        System.out.println(INPUT_ANSWER_NUMBERS_MESSAGE.getMessage());
    }

    public static void printInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE.getMessage());
    }

    public static void printWinningStatisticsMessage() {
        System.out.println(WINNING_STATISTICS_MESSAGE.getMessage());
    }

    public static void printWinningStatistics(GameResultResponseDtos responseDto) {
        StringBuilder result = new StringBuilder();

        List<GameResultResponseDto> resultDtos = responseDto.getGameResultResponseDtos();
        for (GameResultResponseDto dto : resultDtos) {
            result.append(createStatisticsString(dto));
        }

        System.out.print(result);
        printEarningRate(responseDto.getEarningRate());
    }

    public static StringBuilder createStatisticsString(GameResultResponseDto dto) {
        StringBuilder statistics = new StringBuilder();

        statistics.append(String.format(SAME_NUMBER_COUNT_MESSAGE.getMessage(), dto.getSameNumberCount()));
        if (dto.hasBonus()) {
            statistics.append(BONUS_NUMBER_MESSAGE.getMessage());
        }
        statistics.append(String.format(WINNER_PRICE_MESSAGE.getMessage(), toMoneyFormat(dto.getWinnerPrice())));
        statistics.append(String.format(TOTAL_COUNT_MESSAGE.getMessage(), dto.getTotalCount()));
        return statistics;
    }

    private static String toMoneyFormat(int money) {
        DecimalFormat dc = new DecimalFormat(MONEY_DECIMAL_FORMAT.getMessage());
        return dc.format(money);
    }

    private static void printEarningRate(double earningRate) {
        System.out.printf(EARNING_RATE_MESSAGE.getMessage(), earningRate);
    }
}

package lotto.view;

import lotto.dto.LottosResponseDto;

import java.util.List;

import static lotto.dto.LottosResponseDto.*;

public class OutputView {

    public static final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_ANSWER_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String WINNING_STATISTICS_MESSAGE = "당첨 통계\n" + "---";
    public static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.\n";

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

    public static void printWinningStatistics() {
        System.out.println(WINNING_STATISTICS_MESSAGE);
    }
}

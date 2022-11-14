package lotto.view;

import static java.text.MessageFormat.format;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.LottoPrize;
import lotto.dto.LottoInformationDto;
import lotto.dto.LottoResultDto;

public enum OutputView {
    INSTANCE;

    private static final String LOTTO_COUNT_MESSAGE_FORMAT = "\n{0}개를 구매했습니다.";
    private static final String LOTTO_INFO_MESSAGE_FORMAT = "\n{0}";
    private static final String LOTTO_RESULT_MESSAGE = "\n당첨통계\n---";
    private static final String LOTTO_RESULT_MESSAGE_FORMAT = "\n{0}개 일치{1} ({2,number}원) - {3}개";
    private static final String PROFIT_RATIO_MESSAGE_FORMAT = "\n총 수익률은 {0}%입니다.";
    private static final String PROFIT_RATIO_ONE_DECIMAL_PLACE_FORMAT = "%.1f";
    private static final String BONUS_BALL_MESSAGE = ", 보너스 볼 일치";
    private static final String EMPTY_MESSAGE = "";
    private static final long EMPTY_PRIZE = 0L;
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] {0}";

    public void printLottoInformation(LottoInformationDto lottoInformationDto) {
        System.out.println(generateLottoInformation(lottoInformationDto));
    }

    private String generateLottoInformation(LottoInformationDto lottoInformationDto) {
        StringBuilder informationMessage = new StringBuilder();
        informationMessage.append(format(LOTTO_COUNT_MESSAGE_FORMAT, lottoInformationDto.getSize()));
        generateLottoInformationMessage(lottoInformationDto, informationMessage);
        return informationMessage.toString();
    }

    private void generateLottoInformationMessage(LottoInformationDto informationDto, StringBuilder infomationMessage) {
        for (List<Integer> lotto : informationDto.getLottoTicket()) {
            infomationMessage.append(format(LOTTO_INFO_MESSAGE_FORMAT, lotto));
        }
    }

    public void printLottoResult(LottoResultDto resultDto) {
        System.out.println(generateLottoResult(resultDto.getPrizeCount(), resultDto.getProfitRatio()));
    }

    private String generateLottoResult(EnumMap<LottoPrize, Long> prizeCount, double profitRatio) {
        StringBuilder resultMessage = new StringBuilder();
        resultMessage.append(LOTTO_RESULT_MESSAGE);
        generateLottoResultMessage(prizeCount, resultMessage);
        resultMessage.append(formattingProfitRatioMessage(profitRatio));
        return resultMessage.toString();
    }

    private void generateLottoResultMessage(EnumMap<LottoPrize, Long> prizeCount, StringBuilder resultMessage) {
        for (LottoPrize lottoPrize : LottoPrize.lowestPrizeOrder()) {
            resultMessage.append(formattingLottoResultMessage(prizeCount, lottoPrize));
        }
    }

    private String formattingLottoResultMessage(EnumMap<LottoPrize, Long> prizeCount, LottoPrize lottoPrize) {
        return format(
                LOTTO_RESULT_MESSAGE_FORMAT,
                lottoPrize.getMatchCount(),
                generateBonusBallMessage(lottoPrize),
                lottoPrize.getPrize(),
                prizeCount.getOrDefault(lottoPrize, EMPTY_PRIZE)
        );
    }

    private String generateBonusBallMessage(LottoPrize lottoPrize) {
        if (lottoPrize.equals(LottoPrize._2ND_PRIZE)) {
            return BONUS_BALL_MESSAGE;
        }
        return EMPTY_MESSAGE;
    }

    private String formattingProfitRatioMessage(double profitRatio) {
        return format(
                PROFIT_RATIO_MESSAGE_FORMAT,
                String.format(PROFIT_RATIO_ONE_DECIMAL_PLACE_FORMAT, profitRatio)
        );
    }

    public void printErrorMessage(String message) {
        System.out.println(format(ERROR_MESSAGE_FORMAT, message));
    }
}


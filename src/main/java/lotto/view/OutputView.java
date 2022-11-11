package lotto.view;

import lotto.domain.LottoRank;
import lotto.dto.LottoRanksDTO;
import lotto.dto.LottosDTO;
import lotto.exception.ViewClassCreateException;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OutputView {
    private static final String PAYMENT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_NUMBERS_INPUT_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String NUMBER_OF_PURCHASES_FORMAT = "%n%d개를 구매했습니다.%n";
    private static final String NEW_LINE_DELIMITER = "\n";
    private static final String COMMA_SPACE_DELIMITER = ", ";
    private static final String SQUARE_BRACKETS_PREFIX = "[";
    private static final String SQUARE_BRACKETS_SUFFIX = "]";
    private static final String WINNING_STATS_GUIDANCE_MESSAGE = "\n당첨 통계";
    private static final String DIVISION_LINE = "---";
    private static final String SECOND_RANK_FORM = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String ALL_RANK_FORM = "%d개 일치 (%s원) - %d개";
    private static final String MONEY_DECIMAL_FORM = "###,###";
    private static final String YIELD_PRINT_FORM = "총 수익률은 %.1f%%입니다.";
    
    private OutputView() {
        throw new ViewClassCreateException();
    }
    
    public static void printPaymentInputMessage() {
        System.out.println(PAYMENT_INPUT_MESSAGE);
    }
    
    public static void printWinningLottoNumbersInputMessage() {
        System.out.println(WINNING_LOTTO_NUMBERS_INPUT_MESSAGE);
    }
    
    public static void printBonusNumberInputMessage() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }
    
    public static void printLottoIssuanceResults(final LottosDTO lottosDTO) {
        final List<List<Integer>> lottos = lottosDTO.getLottos();
    
        printNumberOfPurchases(lottos);
        printLottosIssuanceResults(lottos);
    }
    
    private static void printNumberOfPurchases(final List<List<Integer>> lottos) {
        System.out.printf(NUMBER_OF_PURCHASES_FORMAT, lottos.size());
    }
    
    private static void printLottosIssuanceResults(final List<List<Integer>> lottos) {
        System.out.println(parseLottosIssuanceResults(lottos));
    }
    
    private static String parseLottosIssuanceResults(final List<List<Integer>> lottos) {
        return lottos.stream()
                .map(OutputView::parseLottoIssuanceResults)
                .collect(Collectors.joining(NEW_LINE_DELIMITER));
    }
    
    private static String parseLottoIssuanceResults(final List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(COMMA_SPACE_DELIMITER, SQUARE_BRACKETS_PREFIX, SQUARE_BRACKETS_SUFFIX));
    }
    
    public static void printWinningStats(final LottoRanksDTO lottoRanksDTO) {
        final List<LottoRank> lottoRanks = lottoRanksDTO.getLottoRanks();
    
        printWinningStatsGuidanceMessage();
        printDivisionLine();
        printCoreWinningStats(lottoRanks);
    }
    
    private static void printWinningStatsGuidanceMessage() {
        System.out.println(WINNING_STATS_GUIDANCE_MESSAGE);
    }
    
    private static void printDivisionLine() {
        System.out.println(DIVISION_LINE);
    }
    
    private static void printCoreWinningStats(final List<LottoRank> lottoRanks) {
        System.out.println(parseWinningStats(lottoRanks));
    }
    
    private static String parseWinningStats(final List<LottoRank> lottoRanks) {
        return Arrays.stream(LottoRank.values())
                .filter(Predicate.not(LottoRank::isMiss))
                .sorted(Comparator.reverseOrder())
                .map(lottoRank -> parsePerWinningStats(lottoRanks, lottoRank))
                .collect(Collectors.joining(NEW_LINE_DELIMITER));
    }
    
    private static String parsePerWinningStats(final List<LottoRank> lottoRanks, final LottoRank lottoRank) {
        final int countOfSameLottoNumber = lottoRank.countOfSameLottoNumber();
        final String prizeMoneyDisplay = prizeMoneyDisplay(lottoRank);
        final int countOfMatchingLottoRank = countOfMatchingLottoRank(lottoRanks, lottoRank);
        
        if (isSecond(lottoRank)) {
            return String.format(SECOND_RANK_FORM, countOfSameLottoNumber, prizeMoneyDisplay, countOfMatchingLottoRank);
        }
        return String.format(ALL_RANK_FORM, countOfSameLottoNumber, prizeMoneyDisplay, countOfMatchingLottoRank);
    }
    
    private static String prizeMoneyDisplay(final LottoRank lottoRank) {
        return moneyDecimalFormat().format(prizeMoney(lottoRank));
    }
    
    private static int prizeMoney(final LottoRank lottoRank) {
        return lottoRank.prizeMoney();
    }
    
    private static DecimalFormat moneyDecimalFormat() {
        return new DecimalFormat(MONEY_DECIMAL_FORM);
    }
    
    private static int countOfMatchingLottoRank(final List<LottoRank> lottoRanks, final LottoRank lottoRankToCompare) {
        return (int) lottoRanks.stream()
                .filter(lottoRank -> lottoRank == lottoRankToCompare)
                .count();
    }
    
    private static boolean isSecond(final LottoRank lottoRank) {
        return lottoRank.isSecond();
    }
    
    public static void printYield(final double yield) {
        System.out.printf(YIELD_PRINT_FORM, yield);
    }
}

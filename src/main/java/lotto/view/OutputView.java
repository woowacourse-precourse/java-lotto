package lotto.view;

import lotto.dto.LottosDTO;
import lotto.exception.ViewClassCreateException;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String PAYMENT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_NUMBERS_INPUT_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    
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
    
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        System.out.println(lottos.stream()
                .map(OutputView::parseLottoIssuanceResults)
                .collect(Collectors.joining("\n")));
    }
    
    private static String parseLottoIssuanceResults(final List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}

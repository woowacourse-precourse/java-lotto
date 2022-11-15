package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoConsole {

    public String buyingAskMessage() {
        return "구입금액을 입력해 주세요.";
    }

    public String boughtLottoMessage(List<List<Integer>> lottos) {
        String countMessage = this.countMessage(lottos);
        String lottoNumbersMessage = this.lottoNumbersMeesage(lottos);

        List<String> messages = Arrays.asList(countMessage, lottoNumbersMessage);
        String joined = String.join("\n", messages);

        return joined;
    }

    private String countMessage(List<List<Integer>> lottos) {
        int count = lottos.size();
        String countMessage = String.format("%d개를 구매했습니다.", count);

        return countMessage;
    }

    /**
     * e.g. List<List<Integer>>[[1, 2, 3, 4, 5], [1, 2, 3, 4, 5]] -> [1, 2, 3, 4, 5]\n[1, 2, 3, 4, 5]
     */
    private String lottoNumbersMeesage(List<List<Integer>> lottos) {
        var joinedMessage = lottos.stream().map(this::stringOfLottoNumbers).collect(Collectors.joining("\n"));

        return joinedMessage;
    }

    /**
     * e.g. List<Integer>[1, 2, 3, 4, 5] -> [1, 2, 3, 4, 5]
     */
    private String stringOfLottoNumbers(List<Integer> lotto) {
        var joinedMessage = lotto.stream().map(String::valueOf).collect(Collectors.joining(", "));

        return "[" + joinedMessage + "]";
    }

    public String winningNumbersAskMessage() {
        return "당첨 번호를 입력해 주세요.";
    }

    public String bonusNumbersAskMessage() {
        return "보너스 번호를 입력해 주세요.";
    }

    public String messageOfNumbersWhetherItWonOrNot(
        int numberOfCorrectDigits,
        boolean bonusMatched,
        int prize,
        int numberOfWinning
    ) {
        if (numberOfCorrectDigits == 5 && bonusMatched) {
            return String.format(
                "%d개 일치, 보너스 볼 일치 (%,d원) - %d개",
                numberOfCorrectDigits,
                prize,
                numberOfWinning
            );
        }

        return String.format("%d개 일치 (%,d원) - %d개", numberOfCorrectDigits, prize, numberOfWinning);
    }

    public String winningStatisticsHeaderMessage() {
        return "당첨 통계\n---";
    }

    public String roiMessage(double roi) {
        return String.format("총 수익률은 %3.1f%%입니다.", roi);
    }
}

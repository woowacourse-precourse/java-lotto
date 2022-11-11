package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

public class LottoGameView {

    private ViewValidator viewValidator;

    public LottoGameView(ViewValidator viewValidator) {
        this.viewValidator = viewValidator;
    }

    public int inputMoney() {
        System.out.println("구매금액을 입력해 주세요.");
        String money = Console.readLine();

        viewValidator.validateNumberType(money);
        viewValidator.validateUnitOf1000(money);

        return Integer.parseInt(money);
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();

        return viewValidator.getValidNumbers(winningNumbers);
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputNumber = Console.readLine();

        viewValidator.validateNumberType(inputNumber);

        return Integer.parseInt(inputNumber);
    }
    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> printSortedLotto(lotto.getNumbers()));
    }

    public void printSortedLotto(List<Integer> lotto) {
        System.out.println(getSortedByAscend(lotto));
    }

    public void printWinningResult(List<LottoRank> ranks) {
        Map<LottoRank, Integer> rankCount = getRankCount(ranks);

        System.out.println("당첨 통계");
        System.out.println("---");
        Arrays.stream(WinningResultMessage.values())
                .forEach(message -> message.print(rankCount.getOrDefault(message.getLottoRank(), 0)));
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + String.format("%.1f", rateOfReturn) + "%입니다.");
    }

    private List<Integer> getSortedByAscend(List<Integer> lotto) {
        return lotto.stream()
                .sorted(Comparator.comparing(Integer::valueOf))
                .collect(Collectors.toList());
    }

    private Map<LottoRank, Integer> getRankCount(List<LottoRank> ranks) {
        Map<LottoRank, Integer> rankCount = new HashMap<>();
        ranks.forEach(lottoRank -> rankCount.put(lottoRank, rankCount.getOrDefault(lottoRank, 0) + 1));
        return rankCount;
    }
}

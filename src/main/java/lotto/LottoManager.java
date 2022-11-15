package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoManager {
    private Money input;
    private Money benefit;
    private final LottoList lottos = new LottoList();
    private AnswerNumberList answerNumbers;
    private final List<LottoResult> kindOfResult = List.of(LottoResult.FIFTH, LottoResult.FOURTH, LottoResult.THIRD,
            LottoResult.SECOND, LottoResult.FIRST);
    private final Map<String, Long> lottoResultMap = generateLottoResultMap();


    private Long getAmountOfMoney() {
        String amountOfMoney = Console.readLine();
        try {
            return Long.valueOf(amountOfMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private void pickLottoNumbers() {
        Long amountOfLotto = input.getAmountOfLotto();
        for (int i = 0; i < amountOfLotto; i++) {
            this.lottos.generateLotto();
        }
        System.out.println(amountOfLotto + "개를 구매했습니다.");
    }

    public void buyLotto() {
        Long amountOfMoney = getAmountOfMoney();
        this.input = new Money(amountOfMoney);
        pickLottoNumbers();
        lottos.printLottoList();
    }

    private List<Long> parseAnswerNumbers(String answerNumberString) {
        return Arrays.stream(answerNumberString.split(",")).map(Long::valueOf).collect(Collectors.toList());
    }

    public void generateAnswerNumbers() {
        String answerNumberString = Console.readLine();
        List<Long> answerLongNumbers = parseAnswerNumbers(answerNumberString);
        String bonusNumberString = Console.readLine();
        Long bonusNumber = Long.valueOf(bonusNumberString);
        this.answerNumbers = new AnswerNumberList(answerLongNumbers, bonusNumber);
    }

    private Map<String, Long> generateLottoResultMap() {
        HashMap<String, Long> map = new HashMap<>();
        for (var kind : Objects.requireNonNull(kindOfResult)) {
            map.put(kind.name(), 0L);
        }
        map.put(LottoResult.NOTHING.name(), 0L);
        return map;
    }

    private void checkWinningsInLottoList() {
        List<Lotto> lottoList = lottos.getLottoList();
        for (var lotto : lottoList) {
            LottoResult lottoResult = answerNumbers.checkLottoWinning(lotto);
            lottoResultMap.replace(lottoResult.name(), lottoResultMap.get(lottoResult.name()) + 1);
        }
    }

    private void printResultMap() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (var kind : kindOfResult) {
            System.out.println(kind.getMessage() + " - " + lottoResultMap.get(kind.name()) + "개");
        }
    }

    private Long getResultCompensation() {
        long sum = 0L;
        for (var kind : kindOfResult) {
            sum += kind.getCompensation() * lottoResultMap.get(kind.name());
        }
        return sum;
    }

    private Double getBenefitRatio() {
        return input.getRatio(benefit);
    }

    private void printBenefitRatio() {
        System.out.println("총 수익률은 " + Math.round(getBenefitRatio() * 10) / 10.0 + "%입니다.");
    }

    public void printStatistics() {
        checkWinningsInLottoList();
        printResultMap();
        benefit = new Money(getResultCompensation());
        printBenefitRatio();
    }
}

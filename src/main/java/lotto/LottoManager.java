package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoManager {
    private Money input;
    private Money benefit;
    private final LottoList lottos = new LottoList();
    private AnswerNumberList answerNumbers;
    private final Map<LottoResult, Long> lottoResultMap = generateLottoResultMap();
    private final List<LottoResult> kindOfResult = List.of(LottoResult.FIFTH, LottoResult.FOURTH, LottoResult.THIRD,
            LottoResult.SECOND, LottoResult.FIRST);

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

    private Map<LottoResult, Long> generateLottoResultMap() {
        return new java.util.HashMap<>(Map.of(
                LottoResult.FIRST, 0L,
                LottoResult.SECOND, 0L,
                LottoResult.THIRD, 0L,
                LottoResult.FOURTH, 0L,
                LottoResult.FIFTH, 0L
        ));
    }

    private void checkWinningsInLottoList() {
        List<Lotto> lottoList = lottos.getLottoList();
        for (var lotto : lottoList) {
            LottoResult lottoResult = answerNumbers.checkLottoWinning(lotto);
            lottoResultMap.replace(lottoResult, lottoResultMap.get(lottoResult) + 1);
        }
    }

    private void printResultMap() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for(var kind: kindOfResult){
            System.out.println(kind.getMessage()+ " - "+lottoResultMap.get(kind)+"개");
        }
    }

    private Long getResultCompensation(){
        Long sum = 0L;
        for(var kind: kindOfResult){
            sum += kind.getCompensation()*lottoResultMap.get(kind);
        }
        return sum;
    }
    public void printStatistics() {
        checkWinningsInLottoList();
        printResultMap();
        Long resultCompensation = getResultCompensation();

    }
}

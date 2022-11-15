package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/*

    구입금액을 입력해 주세요.
    8000

    8개를 구매했습니다.
    [8, 21, 23, 41, 42, 43] 
    [3, 5, 11, 16, 32, 38] 
    [7, 11, 16, 35, 36, 44] 
    [1, 8, 11, 31, 41, 42] 
    [13, 14, 16, 38, 42, 45] 
    [7, 11, 30, 40, 42, 43] 
    [2, 13, 22, 32, 38, 45] 
    [1, 3, 5, 14, 22, 45]

    당첨 번호를 입력해 주세요.
    1,2,3,4,5,6

    보너스 번호를 입력해 주세요.
    7

    당첨 통계
    ---
    3개 일치 (5,000원) - 1개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 0개
    총 수익률은 62.5%입니다.

 */
public class Application {

    private int bonusNumber;
    private Lotto winner;
    private LottoConsole console;
    private LottoNumberGenerator numberGenerator;
    private LottoPurchaseValidator purchaseValidator;
    private WinningNumberValidator winningNumberValidator;

    public static void main(String[] args) {
        new Application().run();
    }

    public Application() {
        this.console = new LottoConsole();
        this.numberGenerator = new LottoNumberGenerator();
        this.purchaseValidator = new LottoPurchaseValidator();
        this.winningNumberValidator = new WinningNumberValidator();
    }

    public void run() {
        // Buying Round
        this.prompt(this.console.buyingAskMessage()); // 8,000
        String buyingAmount = Console.readLine();
        int numberOfLottos = parseNumberOfLottos(buyingAmount); // 8
        List<List<Integer>> lottos = autoGeneraetedLottos(numberOfLottos);
        this.prompt(this.console.boughtLottoMessage(lottos)); // 각 로또의 넘버를 getter로 제공해야 함

        // Winning Input Round
        this.prompt(this.console.winningNumbersAskMessage()); // 1,2,3,4,5,6
        this.parseWinningLottoNumbers();
        this.prompt(this.console.bonusNumbersAskMessage()); // 7
        this.bonusNumber = this.parseBonusNumber();

        // Statistics Round
        this.console.winningStatisticsHeaderMessage();

        // 각 단위 별로 맞힌 개수를 제공해야 함.
        // Lotto 끼리 일치 개수와 보너스 번호 일치 여부를 반환하면 될 듯?
        // 5개 + 보너스면 7개로 취급
        var winnerMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < lottos.size(); i++) {
            var boughtLotto = new Lotto(lottos.get(i));
            var sameDigits = this.winner.numberOfSameDigits(boughtLotto);
            var bonusMatched = boughtLotto.hasBonusNumber(this.bonusNumber);

            if (sameDigits == 5 && bonusMatched) {
                sameDigits = 7;
            }
            winnerMap.putIfAbsent(sameDigits, 0);
            winnerMap.put(sameDigits, winnerMap.get(sameDigits) + 1);
        }

        // 출력
        this.prompt(this.console.messageOfNumbersWhetherItWonOrNot(3, false, 5000, winnerMap.get(3)));
        this.prompt(this.console.messageOfNumbersWhetherItWonOrNot(4, false, 50000, winnerMap.get(4)));
        this.prompt(this.console.messageOfNumbersWhetherItWonOrNot(5, false, 1500000, winnerMap.get(5)));
        this.prompt(this.console.messageOfNumbersWhetherItWonOrNot(5, true, 30000000, winnerMap.get(7)));
        this.prompt(this.console.messageOfNumbersWhetherItWonOrNot(6, false, 2000000000, winnerMap.get(6)));
    }

    private void parseWinningLottoNumbers() {
        String winningNumbersString = Console.readLine();
        this.winningNumberValidator.validate(winningNumbersString);
        var winningNumbers = Arrays
            .asList(winningNumbersString.split(","))
            .stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        this.winner = new Lotto(winningNumbers);
    }

    private int parseBonusNumber() {
        var bonusNumberString = Console.readLine();
        String regexEnforcingNumberBetween1to45 = "^([1-4][0-5]|[1-9])$";
        if (bonusNumberString.matches(regexEnforcingNumberBetween1to45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return Integer.parseInt(bonusNumberString);
    }

    private void prompt(String message) {
        System.out.println(message);
    }

    private int parseNumberOfLottos(String buyingAmount) {
        purchaseValidator.validate(buyingAmount);

        return Integer.parseInt(buyingAmount) / 1000;
    }

    private List<List<Integer>> autoGeneraetedLottos(int numberOfLottos) {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            var lotto = numberGenerator.numbers();
            lottos.add(lotto);
        }
        return lottos;
    }
}

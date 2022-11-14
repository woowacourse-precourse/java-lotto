package lotto;

import java.util.List;
import java.util.Map;

public class LottoStore {
    private int money;
    private int purchaseNumber;
    private double profits;

    private int bonusNumber;
    private Lotto winningLotto;
    private List<Lotto> userLotto;
    private LottoMaker lottoMaker = new LottoMaker();
    private LottoStatistics lottoStatistics = new LottoStatistics();

    public void printInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printInputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printUserLotto() {
        System.out.printf("%d개를 구미했습니다.", purchaseNumber);
        for (Lotto lotto : userLotto) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printProfits() {
        Map<String, List<Integer>> countMatchingMoney = lottoStatistics.getCountMatchingMoney();
        profits = lottoStatistics.getProfits(userLotto, winningLotto, bonusNumber, money);
        System.out.println("탕첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개",countMatchingMoney.get("3").get(1));
        System.out.printf("4개 일치 (50,000원) - %d개",countMatchingMoney.get("4").get(1));
        System.out.printf("5개 일치 (1,500,000원) - %d개",countMatchingMoney.get("5").get(1));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개",countMatchingMoney.get("bonus").get(1));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개",countMatchingMoney.get("6").get(1));
        System.out.printf("총 수익률은 %.1f입니다.", profits);
    }

    public void makePurchaseNumber(int money) {
        this.money = money;
        purchaseNumber = money / 1000;
    }

    public void makeUserLotto() {
        lottoMaker.makeRandomLottoNumbers(purchaseNumber);
        userLotto = lottoMaker.makeUserLotto();
    }

    public void makeWinningLotto(List<Integer> winningLottoNumber) {
        winningLotto = new Lotto(winningLottoNumber);
    }

    public void makeBonusNumber(int number) {
        validateDuplicateBonusNumber(number);
        this.bonusNumber = number;
    }

    private void validateDuplicateBonusNumber(int number) {
        if (winningLotto.existsNumber(number)) {
            throw new IllegalArgumentException(Error.DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }
}

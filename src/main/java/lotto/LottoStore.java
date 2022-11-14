package lotto;

import java.util.List;

public class LottoStore {
    private int money;
    private int purchaseNumber;

    private int bonusNumber;
    private Lotto winningLotto;
    private List<Lotto> userLotto;
    private LottoMaker lottoMaker = new LottoMaker();

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

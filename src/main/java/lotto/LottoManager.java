package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class LottoManager {
    private int money;
    private List<Lotto> userLottos = new ArrayList<>();
    private Lotto prizeLotto;
    private int bonusNum;
    private final ScreenPrinter printer;

    public LottoManager(ScreenPrinter printer) {
        this.printer = printer;
        money = 0;
        userLottos.clear();
        bonusNum = 0;
        prizeLotto = null;
    }

    public void playLotto() {
        inputMoney();
        publishLotto();
        showReceipt();
        inputPrizeNums();
        inputBonusNum();
        showResult();
    }

    private void showResult() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateResult(userLottos, prizeLotto, bonusNum);
        lottoResult.calYield(money);
        printer.showResult(lottoResult);
    }

    private void inputBonusNum() {
        this.bonusNum = printer.inputBonusNum();
        validateBonusNum(bonusNum);
    }

    private void validateBonusNum(int bonusNum) {
        if(bonusNum < 1 || bonusNum > 45){
            System.out.println("[ERROR] 로또 번호는 1과 45 사이의 숫자여야 합니다.");
            throw new NoSuchElementException();
        }


        if(prizeLotto.hasContain(bonusNum)) {
            System.out.println("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다");
            throw new NoSuchElementException();
        }
    }

    private void inputPrizeNums() {
        List<Integer> prizeNums = printer.inputPrizeNums();
        validatePrizeNums(prizeNums);
        prizeLotto = new Lotto(prizeNums);
    }

    private void validatePrizeNums(List<Integer> prizeNums) {
        for (Integer prizeNum : prizeNums) {
            if(prizeNum < 1 || prizeNum > 45) {
                System.out.println("[ERROR] 로또 번호는 1과 45 사이의 숫자여야 합니다.");
                throw new NoSuchElementException();
            }
        }
    }

    private void showReceipt() {
        printer.showReceipt(userLottos);
    }

    private void publishLotto() {
        for (int i = 0; i < (money / 1000); i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            userLottos.add(lotto);
        }
    }

    private void inputMoney() {
        money = printer.inputMoney();
        validateMoney();
    }

    private void validateMoney() {
        if(money % 1000 != 0 || money < 0) {
            System.out.println("[ERROR] 구입 금액은 1000단위로 입력해주세요");
            throw new NoSuchElementException();
        }
    }
}

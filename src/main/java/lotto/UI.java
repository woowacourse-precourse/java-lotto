package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Hit;
import lotto.domain.LottoLogic;

import java.util.List;

public class UI {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_LOTTO_MESSAGE = "개를 구매했습니다.";
    private static final String PRIZE_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private LottoLogic lottoLogic;

    public String moneyInput() {
        System.out.println(MONEY_INPUT_MESSAGE);
        return Console.readLine();
    }

    public void lottoByMoney(String moneyInput) {
        lottoLogic = new LottoLogic(moneyInput);
    }

    public void printNumberOfLotto() {
        System.out.println(this.lottoLogic.getNumberOfLotto() + PURCHASE_LOTTO_MESSAGE);
    }

    public void printLottoNumber() {
        for (int i = 0; i < this.lottoLogic.getMyLottos().size(); i++) {
            System.out.println(this.lottoLogic.getMyLottos().get(i).getNumbers());
        }
    }

    public List<String> prizeNumbersInput() {
        System.out.println(PRIZE_INPUT_MESSAGE);
        String prizeNumberInput = Console.readLine();
        return sliceInputNumber(prizeNumberInput);
    }

    public void setPrizeNumbers(List<String> prizeNumbers) {
        this.lottoLogic.setPrizeNumbers(prizeNumbers);
    }

    public String bonusNumberInput() {
        System.out.println(BONUS_INPUT_MESSAGE);
        return Console.readLine();
    }

    public void setBonusNumber(String bonusInput) {
        this.lottoLogic.setBonusNumber(bonusInput);
    }

    public List<String> sliceInputNumber(String value) {
        return List.of(value.split(","));
    }

    public void printLottoResult() {
        this.lottoLogic.calculateResult();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(Hit.THREEHIT.getMessage() + " (" + Hit.THREEHIT.getMoney() + ") - " + this.lottoLogic.getThreeHit() + "개");
        System.out.println(Hit.FOURHIT.getMessage() + " (" + Hit.FOURHIT.getMoney() + ") - " + this.lottoLogic.getFourHit() + "개");
        System.out.println(Hit.FIVEHIT.getMessage() + " (" + Hit.FIVEHIT.getMoney() + ") - " + this.lottoLogic.getFiveHit() + "개");
        System.out.println(Hit.FIVEHITANDBONUS.getMessage() + " (" + Hit.FIVEHITANDBONUS.getMoney() + ") - " + this.lottoLogic.getFiveHitAndBonus() + "개");
        System.out.println(Hit.SIXHIT.getMessage() + " (" + Hit.SIXHIT.getMoney() + ") - " + this.lottoLogic.getSixHit() + "개");
        System.out.println("총 수익률은 " + this.lottoLogic.getEarningRate() + "%입니다.");
    }
}
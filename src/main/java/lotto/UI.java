package lotto;

import camp.nextstep.edu.missionutils.Console;
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
        System.out.println("3개 일치 (5,000원) - " + this.lottoLogic.getThreeHit() + "개");
        System.out.println("4개 일치 (50,000원) - " + this.lottoLogic.getFourHit() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + this.lottoLogic.getFiveHit() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + this.lottoLogic.getFiveHitAndBonus() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + this.lottoLogic.getSixHit() + "개");
        System.out.println("총 수익률은 " + this.lottoLogic.getEarningRate() + "%입니다.");
    }
}
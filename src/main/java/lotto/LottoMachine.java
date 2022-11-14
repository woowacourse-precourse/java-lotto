package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private List<Lotto> lottoList;
    private WinningNumber winningNumber;

    private long investment;
    private long reward;
    private int[] result = new int[6];
    private static final long[] rewardList = {5000L, 50000L, 1500000L, 30000000L, 200000000L};
    private static final String[] resultWords = {"3개 일치 (5,000원)", "4개 일치 (50,000원)", "5개 일치 (1,500,000원)",
            "5개 일치, 보너스 볼 일치 (30,000,000원)", "6개 일치 (2,000,000,000원)"};

    private static final long lottoPrice = 1000;

    public LottoMachine(String input) {
        buyLotto(input);
    }

    public void buyLotto(String input) {
        validatePrice(input);
        lottoList = new ArrayList<>();
        for (int i = 0; i < investment / lottoPrice; i++) {
            lottoList.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    private void validatePrice(String price) {
        for (int i = 0; i < price.length(); i++) {
            if (!Character.isDigit(price.charAt(i))) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_AMOUNT_FORMAT_ERROR);
            }
        }
        investment = Long.parseLong(price);
        if (investment % lottoPrice != 0 || investment / lottoPrice <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_AMOUNT_UNIT_ERROR);
        }
    }

    public void evaluate() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Lotto lotto : lottoList) {
            result[winningNumber.judge(lotto).ordinal()]++;
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(resultWords[i] + " - " + result[i] + "개");
            reward += rewardList[i] * result[i];
        }
        System.out.println("총 수익률은 " + String.format("%.1f", (float) (reward * 100) / investment) + "%입니다.");
    }

    public int getLottoCount() {
        return lottoList.size();
    }

    public void setWinningNumber(WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
    }
}

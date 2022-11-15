package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.text.DecimalFormat;
import java.util.List;


public class Buyer {
    private static final DecimalFormat numberFormat = new DecimalFormat("###,###");
    private List<Lotto> myLottos;
    private Store store;

    Buyer(Store store) {
        this.store = store;
    }

    // 입력된 돈으로 로또를 구입한다.
    public void buyLotto(int seedMoney) {
        this.myLottos = store.sellLotto(seedMoney);
    }

    public int inputSeedMoney() {
        printInputSeedMoney();
        String input = Console.readLine();
        validateSeedMoney(input);
        return Integer.parseInt(input);
    }

    private void printInputSeedMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private void validateSeedMoney(String input) {
        // 숫자로만 이루어져있지 않으면 예외 발생
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정수로만 이루어져야합니다.");
        }
    }

    public LottoResult checkPrize(List<Lotto> lottos) {
        LottoResult lottoResult = requestPrizeToStore(lottos);
        printPrize(lottoResult);
        return lottoResult;
    }

    private LottoResult requestPrizeToStore(List<Lotto> lottos) {
        return store.checkPrize(lottos);
    }

    private void printPrize(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = Prize.values().length - 1; i >= 0; i--) {
            Prize prize = Prize.values()[i];

            // 출력할 내용들을 정리
            int mathcing = prize.getMatching();
            String bonusBall = bonusBallSentence(prize);
            String priceWithFormat = numberFormat.format(prize.getPrizeMoney());
            int count = result.countPrize(prize);

            System.out.println(
                    mathcing + "개 일치" + bonusBall + " (" + priceWithFormat + "원) - " + count + "개"
            );
        }
    }

    private String bonusBallSentence(Prize prize) {
        if (prize.getBonus()) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

    public float checkRate(int seedMoney, int lastMoney) {
        float rate = calcRate(seedMoney, lastMoney);
        rate = roundRate(rate);
        printRate(rate);
        return rate;
    }

    private float calcRate(int seedMoney, int lastMoney) {
        float rate = (float) lastMoney / seedMoney * 100;
        rate = roundRate(rate);
        return rate;
    }

    private float roundRate(float f) {
        int r = Math.round(f * 100);
        return (float) r / 100;
    }

    private void printRate(float rate) {
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }

    public List<Lotto> getMyLottos() {
        return myLottos;
    }
}
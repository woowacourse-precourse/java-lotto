package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

/**
 * 로또 프로그램 사용자의 행동 반영
 * 로또 구매
 * 당첨 번호 확인
 * 수익률 반영
 */
public class Customer {
    private List<Lotto> lottos;
    private int willingToPay;
    private int earning;

    public Customer() {
        willingToPay = 0;
        earning = 0;
    }

    public void buyLotto(LottoStore lottoStore) {
        getWillingToPay();
        this.lottos = lottoStore.sellLotto(this.willingToPay);
        checkNumbersOfLottos(this.lottos);
    }

    private void getWillingToPay() {
        System.out.print("구입금액을 입력해 주세요: ");
        String willingToPay = readLine();
        validate(willingToPay);
        this.willingToPay = Integer.parseInt(willingToPay);
    }

    private void checkNumbersOfLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    private void validate(String number) {
        if (!number.matches("^[0-9]+$")) {
            System.out.println("[ERROR] 구매 금액은 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(number) % 1000 != 0) {
            System.out.println("[ERROR] 구매 금액은 1000원 단위여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}

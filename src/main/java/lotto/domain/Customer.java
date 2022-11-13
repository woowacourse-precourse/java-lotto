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
    private Bag bag;

    public Customer(Bag bag) {
        this.bag = bag;
    }

    public int pay() {
        System.out.print("구입금액을 입력해 주세요: ");
        String willingToPay = readLine();
        validate(willingToPay);
        return Integer.parseInt(willingToPay);
    }

    public void buy(List<Lotto> lottos, Receipt receipt) {
        bag.setLottos(lottos);
        bag.setReceipt(receipt);
    }

    public List<Lotto> getLottos() {
        return bag.getLottos();
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

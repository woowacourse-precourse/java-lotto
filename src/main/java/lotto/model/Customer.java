package lotto.model;



import java.util.List;

/**
 * 로또 구매자
 * 구매한 로또 관리
 */
public class Customer {
    private int money;
    private List<Lotto> lottos;

    public int pay() {
        return money;
    }

    public void setMoney(String money) {
        validate(money);
        this.money = Integer.parseInt(money);
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private static void validate(String number) {
        if (!number.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자여야 합니다.");
        }
        if (Integer.parseInt(number) % Constants.MONEY_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위여야 합니다.");
        }
    }
}

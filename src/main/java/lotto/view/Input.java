package lotto.view;

public class Input {

    /**
     * 복권 구매(Money)
     * */
    int inputMoney(int Money) {
        vaildMoney(Money);
        int ticket=Money%1000;
        return ticket;
    }

    void vaildMoney(int Money) {
        if (Money%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위로 입력할 수 있습니다.");
        }
    }
}

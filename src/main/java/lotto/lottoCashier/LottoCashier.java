package lotto.lottoCashier;

import java.util.List;

public interface LottoCashier {
    public void validateReceivedMoney(String money);
    public int calculateNumberOfLottos(int money);
}

package lotto.io;

public class StaffTellerImpl implements  StaffTeller{
    @Override
    public void tellPurchasedNumberOfLotto(int numberOfLottoPurchased) {
        System.out.printf("%d개를 구매했습니다.%n", numberOfLottoPurchased);
    }
}

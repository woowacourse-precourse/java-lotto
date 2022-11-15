package lotto;

public class Application {
    public static void main(String[] args) {

        int userMoney = Util.inputUserMoney();

        int userLottoCnt = Lotto.numberOfLottoAvailable(userMoney);

        System.out.println("userLottoCnt = " + userLottoCnt);
    }
}

package lotto;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        LottoMachine lottoMachine = new LottoMachine();

        try {
            user.inputPurchaseMoney();
            user.purchaseLotto();

            lottoMachine.inputWinningNumber();
            lottoMachine.inputBonusNumber();

            Result.compareLottoNumber(user.myLotto, lottoMachine.winningNumber, lottoMachine.bonusNumber, user.money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
            return;
        }
    }
}

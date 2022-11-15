package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            Output.purchaseEventMessage();
            Money money = new Money(Input.input());
            Output.blankLine();

            NumberOfLotto numberOfLotto = new NumberOfLotto(money);
            Output.afterPurchaseEventMessage(numberOfLotto.getNumberOfLotto());
            Lottos lottos = new Lottos(numberOfLotto);
            Output.blankLine();

            Output.winNumberEventMessage();
            String winNumbers = Input.input();
            Output.blankLine();
            Output.bonusNumberEventMessage();
            String bonusNumber = Input.input();
            WinningNumbers winningNumbers = new WinningNumbers(winNumbers, bonusNumber);
            Output.blankLine();

            Compute compute = new Compute(lottos, winningNumbers, money);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

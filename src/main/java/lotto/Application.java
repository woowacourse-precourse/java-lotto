package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            Output.purchaseEventMessage();
            Money money = new Money();
            Output.blankLine();
            NumberOfLotto numberOfLotto = new NumberOfLotto(money);
            Output.afterPurchaseEventMessage(numberOfLotto.getNumberOfLotto());
            Lottos lottos = new Lottos(numberOfLotto);
            Output.blankLine();
            Output.winNumberEventMessage();
            WinningNumbers winningNumbers = new WinningNumbers();
            Output.blankLine();
            Compute compute = new Compute(lottos, winningNumbers, money);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

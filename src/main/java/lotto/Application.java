package lotto;

public class Application {
    private static Money purchaseAmount() {
        Output.purchaseEventMessage();
        Money money = new Money(Input.input());
        Output.blankLine();

        return money;
    }

    private static NumberOfLotto buyLotto(Money money) {
        NumberOfLotto numberOfLotto = new NumberOfLotto(money.getMoney());
        Output.numberOfPurchaseEventMessage(numberOfLotto.getNumberOfLotto());

        return numberOfLotto;
    }

    private static Lottos issueLotto(NumberOfLotto numberOfLotto) {
        Lottos lottos = new Lottos(numberOfLotto);
        Output.issuedLottosEventMessage(lottos.getLottos());
        Output.blankLine();

        return lottos;
    }

    private static WinningNumbers setWinningNumbers() {
        Output.winNumberEventMessage();
        String winNumbers = Input.input();
        Output.blankLine();
        Output.bonusNumberEventMessage();
        String bonusNumber = Input.input();
        WinningNumbers winningNumbers = new WinningNumbers(winNumbers, bonusNumber);
        Output.blankLine();

        return winningNumbers;
    }

    private static void computeRecord(Lottos lottos, WinningNumbers winningNumbers, Money money) {
        Compute compute = new Compute(lottos, winningNumbers, money);
        Output.winRecordEventMessage(compute.getWinRecords());
        Output.profitEventMessage(compute.getProfit());
    }

    public static void main(String[] args) {
        try {
            Money money = purchaseAmount();
            NumberOfLotto numberOfLotto = buyLotto(money);
            Lottos lottos = issueLotto(numberOfLotto);
            WinningNumbers winningNumbers = setWinningNumbers();
            computeRecord(lottos, winningNumbers, money);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

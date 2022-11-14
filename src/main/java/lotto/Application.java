package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            Money money = new Money();
            System.out.println();
            NumberOfLotto numberOfLotto = new NumberOfLotto(money);
            Lottos lottos = new Lottos(numberOfLotto);
            System.out.println();
            WinningNumbers winningNumbers = new WinningNumbers();
            System.out.println();
            Compute compute = new Compute(lottos, winningNumbers, money);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

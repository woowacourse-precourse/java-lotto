package lotto;


public class Application {
    public static void main(String[] args) {
        UI ui = new UI();
        ui.inputCost();

        User user = new User(ui.getCost());
        ui.inputWinning();

        Lotto lotto = new Lotto(ui.getWinningNumbers());
        ui.inputBonus();
        lotto.validateBonus(ui.getBonus());
        user.makeLottoNumbers();

        user.checkWinning(lotto.getNumbers(), ui.getBonus());

    }
}

package lotto;


public class Application {
    public static void main(String[] args) {
        UI ui = new UI();
        ui.inputCost();

        User user = new User(ui.getCost());
        ui.showCostCount();
        user.makeLottoNumbers();
        ui.showLottoNumbers(user.getLottoNumbers());

        ui.inputWinning();
        Lotto lotto = new Lotto(ui.getWinningNumbers());

        ui.inputBonus();
        lotto.validateBonus(ui.getBonus());

        user.checkWinning(lotto.getNumbers(), ui.getBonus());
        ui.showWinning(user.getFirst(), user.getSecond(), user.getThird(), user.getFourth(), user.getFifth());
        ui.showYield(user.calculateYield());
    }
}

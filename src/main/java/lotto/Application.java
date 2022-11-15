package lotto;


public class Application {
    private UI ui;
    private User user;
    private Lotto lotto;

    public Application() {
        this.ui = new UI();
    }

    private void inputCost() {
        this.ui.inputCost();
        this.user = new User(this.ui.getCost());
        this.ui.showCostCount();
    }

    private void makeLottoNumbers() {
        this.user.makeLottoNumbers();
        this.ui.showLottoNumbers(this.user.getLottoNumbers());
    }

    private void makeWinningNumbers() {
        this.ui.inputWinning();
        this.lotto = new Lotto(this.ui.getWinningNumbers());
    }

    private void makeBonusNumber() {
        this.ui.inputBonus();
        this.lotto.validateBonus(this.ui.getBonus());
    }

    private void showResult() {
        this.user.checkWinning(this.lotto.getNumbers(), this.ui.getBonus());
        this.ui.showWinning(this.user.getFirst(), this.user.getSecond(), this.user.getThird(), this.user.getFourth(), this.user.getFifth());
    }

    private void showYield() {
        this.ui.showYield(this.user.calculateYield());
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.inputCost();
        app.makeLottoNumbers();
        app.makeWinningNumbers();
        app.makeBonusNumber();
        app.showResult();
        app.showYield();
    }
}

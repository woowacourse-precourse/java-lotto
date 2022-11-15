package lotto.game;

import lotto.game.view.View;

public class Controller {
    private final View view;
    private final Service service;

    public Controller() {
        view = new View();
        service = new Service();
    }

    public void run() {
        try {
            purchase();
            generateDrawAndBonus();
            calculate();
        } catch (IllegalArgumentException ignored) {
        }
    }

    private void purchase() {
        view.outputQuantity(
                service.generateQuantity(
                        view.inputPurchaseAmount()));
        service.generateLottos()
                .forEach(lotto ->
                        view.outputLottoNumbers(lotto.toString()));
    }

    private void generateDrawAndBonus() {
        service.generateDraw(
                view.inputDrawNumbers());
        service.generateBonus(
                view.inputBonusNumber());
    }

    private void calculate() {
        view.outputResult(
                service.calculateDrawScore(),
                service.calculateBonusScore()
        );
        view.outputEarningRate(
                service.calculateEarningsRate());
    }
}

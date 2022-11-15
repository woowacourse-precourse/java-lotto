package lotto;

public class Application {
    public static void main(String[] args) {
        LotterySeller lotterySeller = new LotterySeller();
        lotterySeller.sellLotto();

        DrawMachine drawMachine = new DrawMachine();
        drawMachine.drawNumbers();
        drawMachine.drawBonusNumber();

        Calculator calculator = new Calculator();
        calculator.calculate(lotterySeller.soldLotto, drawMachine.winningNumbers, drawMachine.bonusNumber);
    }
}

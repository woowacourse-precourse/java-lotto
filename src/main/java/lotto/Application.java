package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LotterySeller lotterySeller = new LotterySeller();
        lotterySeller.sellLotto();

        DrawMachine drawMachine = new DrawMachine();
        List<Integer> numbers = drawMachine.drawNumbers();
        int bonusNumber = drawMachine.drawBonusNumber();
    }
}

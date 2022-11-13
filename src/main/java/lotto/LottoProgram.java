package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoProgram {

    private LottoController lottoController;

    public LottoProgram(LottoController lottoController) {
        this.lottoController = lottoController;
    }
    public void run() {
        int orderPrice = this.getOrderPrice();
        int orderQuantity = lottoController.getOrderQuantity(orderPrice);

        lottoController.createLottos(orderQuantity);
    }

    public int getOrderPrice() {
        return Integer.parseInt(Console.readLine());
    }

}

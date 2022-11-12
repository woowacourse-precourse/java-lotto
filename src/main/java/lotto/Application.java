package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.Controller;
import lotto.reposiotory.Repository;
import lotto.service.Service;
import lotto.view.View;


public class Application {

    private static final Controller controller = new Controller(new Service(Repository.createRepository()));

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        View purchaseAmountInputView = controller.createPurchaseAmountInputView();
        purchaseAmountInputView.print();
        View lottoNumber = controller.buyLottos(Console.readLine());
        lottoNumber.print();
    }
}

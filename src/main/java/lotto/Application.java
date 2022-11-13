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
        printView(controller.createPurchaseAmountInputView());
        printView(controller.buyLottos(Console.readLine()));
    }

    private static void printView(View view) {
        view.print();
    }
}

package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.Controller;
import lotto.controller.ErrorController;
import lotto.reposiotory.Repository;
import lotto.service.Service;
import lotto.view.ErrorView;
import lotto.view.View;


public class Application {

    private static final Controller controller = new Controller(new Service(Repository.createRepository()));
    private static final ErrorController errorController=new ErrorController();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            printView(controller.createPurchaseAmountInputView());
            printView(controller.buyLottos(Console.readLine()));
        }catch (IllegalArgumentException e){
            printView(errorController.createErrorView(e.getMessage()));
        }

    }

    private static void printView(View view) {
        view.print();
    }
}

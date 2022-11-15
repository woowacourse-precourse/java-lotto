package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.Controller;
import lotto.controller.ErrorController;
import lotto.reposiotory.LottoRepository;
import lotto.reposiotory.PrizeRepository;
import lotto.service.PrizeSerivce;
import lotto.service.UserLottoService;
import lotto.view.View;


public class Application {

    private static final Controller controller = new Controller(new UserLottoService(LottoRepository.createRepository())
            , new PrizeSerivce(PrizeRepository.createRepository()));
    private static final ErrorController errorController = new ErrorController();

    public static void main(String[] args) {
        try {
            printView(controller.createPurchaseAmountInputView());
            printView(controller.buyLottos(Console.readLine()));
            printView(controller.createPrizeNumberInputView());
            controller.savePrizeLottoNumber(Console.readLine());
            printView(controller.createBonusNumberInputView());
            printView(controller.createPrizeStatisticsView(Console.readLine()));
        } catch (IllegalArgumentException e) {
            printView(errorController.createErrorView(e.getMessage()));
        }
    }

    private static void printView(View view) {
        view.print();
    }
}

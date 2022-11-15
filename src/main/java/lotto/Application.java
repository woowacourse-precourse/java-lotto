package lotto;

import lotto.layer.view.InputView;
import lotto.layer.controller.LottoController;
import lotto.layer.service.LottoService;
import lotto.layer.view.OutputView;
import lotto.layer.db.Table;

public class Application {

    private static final String ERROR = "[ERROR]";
    private static LottoController lottoController;


    public static void main(String[] args) {
        dependencyInjection();
        try {
            lottoController.generateLotto();
            lottoController.getStatistics();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR + " " + e.getMessage());
        } catch (Exception e) {
            System.out.println(ERROR + " " + "예외 발생");
            e.printStackTrace();
        }
    }

    private static void dependencyInjection() {
        Table table = new Table();
        LottoService lottoService = new LottoService(table);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        lottoController = new LottoController(lottoService, inputView, outputView);
    }
}

package lotto;

import lotto.layer.InputView;
import lotto.layer.LottoController;
import lotto.layer.LottoService;
import lotto.layer.OutputView;
import lotto.layer.Table;

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
            System.out.println(ERROR + " " + "알 수 없는 이유로 예외 발생");
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

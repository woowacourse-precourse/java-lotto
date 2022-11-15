package lotto;

import controller.LottoController;
import domain.lotto.LottoRepository;
import service.LottoService;
import controller.UserController;

public class Application {
    public static void main(String[] args) {

        try {
            UserController userController = new UserController();
            userController.saveAmount();

            LottoRepository lottoRepository = new LottoRepository();
            LottoController lottoController = new LottoController(lottoRepository);
            lottoController.createIssuanceLottoNumbers();

            userController.saveNumber();

            LottoService lottoService = new LottoService(lottoController);
            lottoService.game();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

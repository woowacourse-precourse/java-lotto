package lotto;

import static lotto.ui.LottoConsole.printErrorMessage;

import lotto.controller.LottoController;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new LottoService());
        try{
            lottoController.executeGame();
        }
        catch(IllegalArgumentException e){
            printErrorMessage(e.getMessage());
            e.printStackTrace();
        }
    }
}

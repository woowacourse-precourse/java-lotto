package lotto;

import lotto.Controller.LottoGameController;

public class Application {
    public static String errorContent = "";
    public static final String ERROR_MESSAGE = "[ERROR]";
    public static final String separator = ",";


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGameController lottoGameController = new LottoGameController();
        lottoGameController.run();
    }
}

package lotto;

import java.lang.management.MonitorInfo;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR] ";


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoFactory lottoFactory = new LottoFactory();

        LottoController lottoController = new LottoController(inputView, outputView, lottoFactory);
        lottoController.lottery();
    }






    public static void printErrorMessage(String s){
        System.out.println(ERROR_MESSAGE+s);
    }

}

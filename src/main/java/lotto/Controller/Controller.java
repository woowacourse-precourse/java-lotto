package lotto.Controller;

import lotto.View.OutputView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Controller {

    public String inputLottoNumber() {
        OutputView outputView = new OutputView();
        outputView.printInputLottoNumber();
        return readLine();
    }
}
package lotto.ui;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.ui.ConsoleMessage.INPUT_PRICE;

import java.util.List;

public class LottoConsole {

    public LottoConsole(){ }

    public String inputLottoPrice() {
        printMessage(INPUT_PRICE.toString());
        return readLine();
    }

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printLottoResult(List<Integer> lottoNumbers){
        System.out.println(lottoNumbers);
    }

}

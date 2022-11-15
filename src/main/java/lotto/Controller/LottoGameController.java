package lotto.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Console.InputMessages;
import lotto.Console.OutputMessages;
import lotto.Domain.Lotto;
import lotto.Service.LottoGameService;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class LottoGameController {

    Lotto lotto;
    LottoGameService lottoGameService = new LottoGameService();
    public List<List<Integer>> lottoList=new ArrayList<>();
    public List<Integer> countEqualNumberList = new ArrayList<>();
    public String inputCash;

    public void LottoSystem(InputMessages inputMessages, OutputMessages outputMessages) {

    }

    public String getInputNumber(InputMessages inputMessages, OutputMessages outputMessages) {
        outputMessages.inputMoneyMsg();
        String cash = inputMessages.readLine();
        lottoGameService.isCashInt(cash);

        return cash;
    }

    public int calculateCount(String input) {
        lottoGameService.isValidCash(Integer.parseInt(input));
        return Math.floorDiv(Integer.parseInt(input), 1000);
    }

    public int CountEnter(InputMessages inputMessages, OutputMessages outputMessages) {
        inputCash = getInputNumber(inputMessages, outputMessages);
        outputMessages.countEnterMsg(calculateCount(inputCash));

        return calculateCount(inputCash);
    }

    public List<Integer> getRandomNumList() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }


}

enum rankType {
    FIFTH,
    FOURTH,
    THIRD,
    SECOND,
    FIRST;
}

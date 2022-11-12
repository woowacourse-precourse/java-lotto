package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.console.Output;
import lotto.console.Input;
import lotto.domain.Lotto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static lotto.service.Validation.*;
import static lotto.service.Calculator.*;
import static lotto.console.Output.*;

public class BuyLottoController {

    public int costInput() throws IOException{

        getOutput().printWhenInputCost();
        final int cost = Input.inputCostNumber();

        if (isUp(0, cost) && isMultiplesOf1000(cost)) {
            final int tmp = lottoNumbersPerCost(cost);

            getBufferedRecorder().writeNewLine();
            getBufferedRecorder().writeBuyLotto(tmp);

            return tmp;
        }

        throw new IllegalArgumentException("[Error] 잘못된 비용을 지불했습니다.");
    }

    public List<Lotto> createLottoNumber(int lottoNumber) throws IOException {
        final List<Lotto> lottoList = new ArrayList<>(6);

        for(int i=0; i < lottoNumber; i++) {
            Lotto tmp = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoList.add(tmp);

            getBufferedRecorder().writeLotto(tmp.getLotto());
        }

        return lottoList;
    }

    public void printLottoNumber() throws IOException {
        getOutput().printBufferedStream();
    }

    public List<Lotto> runBuyLottoController() throws IOException{
        final List<Lotto> answer = createLottoNumber(costInput());
        printLottoNumber();
        return answer;
    }
}

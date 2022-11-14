package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.service.Validation.*;
import static lotto.service.Calculator.*;
import static lotto.console.Output.*;
import static lotto.console.Input.*;
import static lotto.console.Output.BufferedRecorder.*;


public class BuyLottoController {

    private int inputCost() throws IOException{
        printInputCost();
        int cost = inputNumber();

        if (isUp(0, cost) && isMultiplesOf1000(cost)) {
            int tmp = lottoNumbersPerCost(cost);

            writeNewLine();
            writeBuyLotto(tmp);

            return tmp;
        }

        throw new IllegalArgumentException("[Error] 잘못된 비용을 지불했습니다.");
    }

    private List<Lotto> createLottoNumber(int lottoNumber) throws IOException {
        List<Lotto> lottoList = new ArrayList<>();
        List<Integer> tmp;

        for(int i=0; i < lottoNumber; i++) {
            tmp = Randoms.pickUniqueNumbersInRange(1, 45, 6).stream()
                    .sorted().collect(Collectors.toList());
            lottoList.add(new Lotto(tmp));
            writeLotto(lottoList.get(i).getNumbers());
        }

        return lottoList;
    }

    private void printLottoNumber() throws IOException {
        writeNewLine();
        printBufferedStream();
    }

    public List<Lotto> runBuyLottoController() throws IOException {
        List<Lotto> answer = createLottoNumber(inputCost());
        printLottoNumber();

        return answer;
    }
}
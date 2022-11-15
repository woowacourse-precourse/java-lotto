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

    private int inputCost() {
        printInputCost();
        int cost = inputNumber();
        int tmp = lottoNumbersPerCost(cost);

        if(!(isUp(0, cost) && isMultiplesOf1000(cost))) {
            throw new IllegalArgumentException("[ERROR] 잘못된 비용을 입력했습니다.");
        }

        writeBuyLotto(tmp);

        return tmp;
    }

    private List<Lotto> createLottoNumber(int lottoNumber) {
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


    public List<Lotto> runBuyLottoController() {
        List<Lotto> answer = createLottoNumber(inputCost());
        return answer;
    }
}
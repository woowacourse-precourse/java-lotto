package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.service.Validation.*;
import static lotto.service.Calculator.*;
import static lotto.console.Output.*;
import static lotto.console.Input.*;


public class BuyLottoController {

    private int inputCost() {

        printInputCost();
        int cost = inputNumber();
        int tmp = lottoNumbersPerCost(cost);

        System.out.println();

        isUp(1, cost);
        isMultiplesOf1000(cost);
        printBuyLotto(tmp);

        return tmp;
    }

    private List<Lotto> createLottoNumber(int lottoNumber) {
        List<Lotto> lottoList = new ArrayList<>();
        List<Integer> tmp;

        for(int i=0; i < lottoNumber; i++) {
            tmp = Randoms.pickUniqueNumbersInRange(1, 45, 6).stream()
                    .sorted().collect(Collectors.toList());
            lottoList.add(new Lotto(tmp));
            printLotto(lottoList.get(i).getNumbers());
        }

        return lottoList;
    }


    public List<Lotto> runBuyLottoController() {
        List<Lotto> answer = createLottoNumber(inputCost());
        return answer;
    }
}
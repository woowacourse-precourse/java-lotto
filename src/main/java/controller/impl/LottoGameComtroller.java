package controller.impl;

import controller.GameController;
import domain.Lotto;
import util.*;

import java.util.ArrayList;
import java.util.List;

public class LottoGameComtroller implements GameController {

    private final int LOTTO_PRICE = 1000;
    private List<Lotto> lottoList;
    private List<Integer> lotto;
    private Inputer inputer;
    private Comparator comparator;
    private List<Integer> resultList;
    private ResultPrinter resultPrinter;
    private int money;

    public LottoGameComtroller(Inputer inputer, Comparator comparator, ResultPrinter resultPrinter) {
        this.inputer = inputer;
        this.comparator = comparator;
        this.resultPrinter = resultPrinter;
    }

    @Override
    public void doGame() {
        getLotto();
        compare();
        resultPrinter.printResult();
    }

    private void compare() {
        int index;
        resultList = new ArrayList<>(6);
        for(Lotto lotto : lottoList) {
            index = comparator.doIntCompare(this.lotto, lotto.getNumbers());
            resultList.set(index, resultList.get(index)+1);
        }
    }

    private void getLotto() {
        int count;
        lottoList = new ArrayList<>();
        money = inputer.money();
        count = calCount();
        for(int i = 0 ; i < count ; i++) {
            lottoList = LottoMachine.getLotto(count);
        }
        resultPrinter.printallLottos(lottoList);
        inputer.inputlotto();
        inputer.inputbonus();
        lotto = inputer.getInputlottoNumbers();
    }

    private int calCount() {
        int result = money/LOTTO_PRICE;
        System.out.println(result+"개를 구매했습니다.");
        return result;
    }
}

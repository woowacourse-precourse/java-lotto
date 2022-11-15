package controller.impl;

import controller.GameController;
import domain.Lotto;
import util.*;

import java.util.ArrayList;
import java.util.List;

public class LottoGameController implements GameController {

    private final int LOTTO_PRICE = 1000;
    private List<Lotto> lottoList;
    private List<Integer> lotto;
    private Inputer inputer;
    private Comparator comparator;
    private List<Integer> resultList;
    private Printer printer;
    private int money;

    public LottoGameController(Inputer inputer, Comparator comparator, Printer printer) {
        this.inputer = inputer;
        this.comparator = comparator;
        this.printer = printer;
    }

    @Override
    public void doGame() {
        try {
            getLotto();
            compare();
            doPrint();
        } catch(IllegalArgumentException e) {
            System.out.println("[ERROR] : Invalid argument!");
        }
    }

    private void doPrint() {
        printer.setMoney(money);
        printer.setResultList(resultList);
        printer.result();
    }

    private void compare() throws IllegalArgumentException {
        int index;
        resultList = new ArrayList<Integer>(List.of(0,0,0,0,0,0));
        for(Lotto lotto : lottoList) {
            index = comparator.doIntCompare(this.lotto, lotto.getNumbers());
            resultList.set(index, resultList.get(index)+1);
        }
    }

    private void getLotto() throws IllegalArgumentException {
        int count;
        lottoList = new ArrayList<>();
        money = inputer.money();
        count = calCount();

        lottoList = LottoMachine.getLotto(count);

        printer.allLottos(lottoList);
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

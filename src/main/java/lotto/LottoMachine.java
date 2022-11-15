package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final int buyLineMoney = 1000;
    private final int minLottoNumber = 1;
    private final int maxLottoNumber = 45;
    private final int oneLineLottoNumber = 6;

    public int buyLottoLineNumber(String inputMoney) {

        int money = Integer.parseInt(inputMoney);

        return money / buyLineMoney;
    }

    public List<Integer> makeBuyLottoLine() {
        List<Integer> LottoLine = new ArrayList<>();

        LottoLine = Randoms.pickUniqueNumbersInRange(minLottoNumber, maxLottoNumber, oneLineLottoNumber);

        return LottoLine;
    }

    public List<List<Integer>> makeBuyLottoPaper(String inputMoney) {
        List<List<Integer>> LottoPaper = new ArrayList<>();

        for (int i = 0; i < buyLottoLineNumber(inputMoney); i++) {
            LottoPaper.add(makeBuyLottoLine());
        }

        return LottoPaper;
    }

    public List<Integer> winSixNumber(String winSixNumber) {
        List<Integer> winSixNumberSeparate = new ArrayList<>();


        for (String i : winSixNumber.split(",")) {
            winSixNumberSeparate.add(Integer.parseInt(i));
        }

        return winSixNumberSeparate;
    }

}

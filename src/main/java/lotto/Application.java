package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private final static int LOTTO_START_NUMBER = 1;
    private final static int LOTTO_END_NUMBER = 45;
    private final static int MAX_LOTTO_NUMBER_COUNT = 6;


    public static void lottoLogicProgress() {
        // TODO: 프로그램 구현
        int lottoCount;
        List<Lotto> allLottoInfo = new ArrayList<Lotto>();
        List<Integer> winNumbers = new ArrayList<>();
        int inputBonusNumber;
        String money = readLine();
        NumberException numberException = new NumberException();
        numberException.validateNumeric(money);
        LottoShop lottoShop = new LottoShop(Integer.parseInt(money));
        lottoCount = lottoShop.LottoCountCalculate();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, MAX_LOTTO_NUMBER_COUNT);
            List mutableNumber = new ArrayList(numbers);
            Collections.sort(mutableNumber);
            allLottoInfo.add(new Lotto(mutableNumber));
            allLottoInfo.get(i).printLottoNumber();
        }

        for (String inputWinNumber : readLine().split(",")) {
            winNumbers.add(Integer.parseInt(inputWinNumber));
        }
        inputBonusNumber = Integer.parseInt(readLine());
        WinNumber winNumber = new WinNumber(winNumbers, inputBonusNumber);

        LottoJudge lottoJudge = new LottoJudge();

        for (int i = 0; i < lottoCount; i++) {
            lottoJudge.judgeWin(allLottoInfo.get(i), winNumber);
        }
        lottoJudge.lottoJudgeResult();
        lottoJudge.calculateRateOfReturn(lottoShop);
    }

    public static void main(String[] args) {
        try {
            lottoLogicProgress();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
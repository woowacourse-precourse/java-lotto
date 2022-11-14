package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Controller {
    private static final int  V = 5000;
    private static final int  VI = 50000;
    private static final int  III = 1500000;
    private static final int  II = 30000000;
    private static final int  I = 2000000000;

    Controller() {

    }

    View view = new View();

    public void start() {
        Controller controller = new Controller();

        //로또 저장 어레이리스트, 결과저장 해시맵
        List<Lotto> alllotto = new ArrayList<>();
        HashMap<Integer, Integer> resultchart = new HashMap<>();

        //해시맵 초기화
        controller.initResultChart(resultchart);

        //로또 돈 입력받고 랜덤값 저장, 출력
        LottoCost lottocost = new LottoCost(view.inputMoneyAmount());
        int lottocount = lottocost.getCost()/1000;
        controller.randomSetLotto(lottocount, alllotto);

        view.printPurchasedLottoCount(lottocount);
        controller.printToViewLotto(alllotto);

        //당첨 번호, 보너스 번호 입력받기
        Lotto winniglotto = new Lotto(view.inputWinningNum());
        int bonusnum = view.inputBonusNum();

        //결과 정리해서 출력
        controller.judegeWin(winniglotto, alllotto, bonusnum, controller, resultchart);
        String profit = controller.calculateProfit(resultchart, lottocost.getCost());

        view.printResult(resultchart.get(3),resultchart.get(4),resultchart.get(5),
                resultchart.get(7),resultchart.get(6), profit);
    }

    void randomSetLotto(int lottocount, List<Lotto> alllotto) {
        for(int count =0; count < lottocount; count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);

            alllotto.add(lotto);
        }
    }

    void printToViewLotto(List<Lotto> lottogather) {
        for(Lotto lotto : lottogather) {
            view.printPurchasedLotto(lotto.getNumbers());
        }
    }

    void judegeWin(Lotto winninglotto, List<Lotto> randomlotto, int bonusnum,
                   Controller controller, HashMap<Integer, Integer> resultchart) {
        for(int index = 0; index < randomlotto.size(); index++) {
            int duplicatenum = controller.countWin(winninglotto, randomlotto.get(index));

            if (duplicatenum == 5) {
                controller.judgeBonusNum(winninglotto, bonusnum, resultchart);
            }

            if (duplicatenum != 5) {
                resultchart.replace(duplicatenum, resultchart.get(duplicatenum) + 1);
            }
        }
    }

    int countWin(Lotto winninglotto, Lotto randomlotto) {
        List<Integer> winningcopy = new ArrayList<>(winninglotto.getNumbers());
        winningcopy.retainAll(randomlotto.getNumbers());

        int result = winningcopy.size();
        return result;
    }

    void judgeBonusNum(Lotto winninglotto, int bonusnum, HashMap<Integer, Integer> resultchart) {
        if (winninglotto.getNumbers().contains(bonusnum)) {
            resultchart.replace(7, resultchart.get(7) + 1);
        }

        if (winninglotto.getNumbers().contains(bonusnum) == false) {
            resultchart.replace(5, resultchart.get(5) + 1);
        }
    }

    void initResultChart(HashMap<Integer, Integer> resultchart) {
        for(int index = 0; index < 8; index++) {
            resultchart.put(index, 0);
        }
    }

    String calculateProfit(HashMap<Integer, Integer> chart, int lottocost) {
        int sum = (V * chart.get(3)) + (VI * chart.get(4))
                + (III * chart.get(5)) + (II * chart.get(7)) + (I * chart.get(6));
        double calnum = (double)sum / (double)lottocost * 100;
        String result = String.format("%.1f", calnum);

        return result;
    }
}

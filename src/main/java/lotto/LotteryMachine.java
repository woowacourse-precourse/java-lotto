package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryMachine {

    private final int[] proceeds = {5000, 50000, 1500000, 30000000, 2000000000};
    private Lotto winningLotto;
    private int bonusNum;


    public List<Integer> makeLottoNum() {

        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void makeWinningLottoNum() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinningNum = Console.readLine();
        String[] spiltWinningNum = inputWinningNum.split(",");
        List<Integer> winningNum = new ArrayList<>();

        for (String num : spiltWinningNum) {
            Error.validateInputIsNotNum(num);
            winningNum.add(Integer.parseInt(num));
        }

        Collections.sort(winningNum);
        this.winningLotto = new Lotto(winningNum);
    }


    public void makeBonusNum(List<Integer> lottoNum) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNum = Console.readLine();

        Error.validateInputIsNotNum(inputBonusNum);

        int bonusNum = Integer.parseInt(inputBonusNum);

        Error.validateNumIsInBoundary(bonusNum);
        if (lottoNum.contains(bonusNum)) {
            throw new IllegalArgumentException(Error.BONUS_DUPLICATE_LOTTO.getErrorMsg());
        }

        this.bonusNum =  bonusNum;
    }

    public int compareLotto(Lotto lotto) {
        int same = 0;
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        List<Integer> lottoNumbers = lotto.getNumbers();

        for (int index = 0; index < lottoNumbers.size(); index++) {
            if (winningLottoNumbers.contains(lottoNumbers.get(index))) {
                same++;
            }
        }

        return same;
    }

    public int compareBonusNum(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        if (lottoNumbers.contains(bonusNum)) {
            return 1;
        }
        return 0;
    }

    public int[] calculateLottoResult(Buyer buyer) {
        int[] sameNumCount = new int[5];

        for (Lotto lotto : buyer.getLottos()) {
            int same = compareLotto(lotto);

            if (same == 5) {
                int bonusResult = compareBonusNum(lotto);
                sameNumCount[same - bonusResult - 3]++;
            }
            if (same >= 3 && same != 5)
                sameNumCount[same - 3]++;
        }
        return sameNumCount;
    }

    public void printResult(int[] sameNumCount) {

        System.out.println("3개 일치 (5,000원) - " + sameNumCount[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + sameNumCount[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + sameNumCount[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + sameNumCount[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + sameNumCount[4] + "개");
    }

    public void printRateOfReturn(int[] lottoResult, int buyMoney) {
        double money = 0;

        for (int index = 0; index < lottoResult.length; index++) {
            money += (long) lottoResult[index] * proceeds[index];
        }
        System.out.println(money);
        double rateOfReturn = (money / buyMoney) * 100.0;
        System.out.println("총 수익률은 "+ rateOfReturn +"%입니다.");
    }

    public Lotto getLotto() {
        return winningLotto;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}

package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryMachine {

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
            if (same != 5)
                sameNumCount[same - 3]++;
        }
        return sameNumCount;
    }

    public Lotto getLotto() {
        return winningLotto;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}

package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LotteryMachine {

    private Lotto lotto;
    public List<Integer> makeLottoNum() {

        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void makeWinningLottoNum() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요");
        String inputWinningNum = Console.readLine();
        String[] spiltWinningNum = inputWinningNum.split(",");
        List<Integer> winningNum = new ArrayList<>();

        for (String num : spiltWinningNum) {
            Error.validateInputIsNotNum(num);

            winningNum.add(Integer.parseInt(num));
        }
        this.lotto = new Lotto(winningNum);
    }


    public int makeBonusNum(List<Integer> lottoNum) {

        List<Integer> bonusNum = Randoms.pickUniqueNumbersInRange(1, 45, 1);
        if (lottoNum.contains(bonusNum.get(0))) {
            throw new IllegalArgumentException(Error.BONUS_DUPLICATE_LOTTO.getErrorMsg());
        }

        return bonusNum.get(0);
    }

    public Lotto getLotto() {
        return lotto;
    }



}

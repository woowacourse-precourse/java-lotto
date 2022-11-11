package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LotteryMachine {

    private Lotto lotto;
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
        this.lotto = new Lotto(winningNum);
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

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}

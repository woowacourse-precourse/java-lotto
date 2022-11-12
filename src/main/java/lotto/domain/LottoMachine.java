package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Input;

public class LottoMachine {
    private static Lotto winningNumber;
    private static Integer bonusNumber;
    public static LottoMachine init() {
        return new LottoMachine();
    }

    public List<Lotto> makeLottoes(int lottoCnt) {
        if(lottoCnt < 1) {
            throw new IllegalArgumentException("1 이상의 숫자를 입력해주세요");
        }
        List<Lotto> lottoes = new ArrayList<>();

        for (int i = 0; i < lottoCnt; i++) {
            lottoes.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottoes;
    }

    public void makeWinningNumber(List<Integer> inputWinningNumber) {
        winningNumber = new Lotto(inputWinningNumber);
    }

    public void makeBonusNumber(Integer bonusNumber) {
        if(bonusNumber < 0 || bonusNumber > 45) {
            throw new IllegalArgumentException("1~45까지의 숫자만 가능합니다");
        }
        if (winningNumber == null) { //이게 맞나?
            throw new IllegalArgumentException("당첨번호가 등록되지 않았습니다");
        }
        if (winningNumber.has(bonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자는 당첨번호의 숫자들과 중복될 수 없습니다");
        }
        this.bonusNumber = bonusNumber;
    }
}

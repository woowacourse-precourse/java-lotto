package lotto.domain;

import static lotto.Constant.BALL_MAX_RANGE;
import static lotto.Constant.BALL_MIN_RANGE;
import static lotto.Constant.LOTTO_DIGIT_CNT;
import static lotto.Constant.MIN_LOTTO_CNT_PURCHASED;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static Lotto winningNumber;
    private static Integer bonusNumber;
    public static LottoMachine init() {
        return new LottoMachine();
    }

    public List<Lotto> makeLottoes(int lottoCnt) {
        if(lottoCnt < MIN_LOTTO_CNT_PURCHASED) {
            throw new IllegalArgumentException("1 이상의 숫자를 입력해주세요");
        }
        List<Lotto> lottoes = new ArrayList<>();

        for (int i = 0; i < lottoCnt; i++) {
            lottoes.add(new Lotto(Randoms.pickUniqueNumbersInRange(BALL_MIN_RANGE, BALL_MAX_RANGE, LOTTO_DIGIT_CNT)));
        }
        return lottoes;
    }

    public void makeWinningNumber(List<Integer> inputWinningNumber) {
        winningNumber = new Lotto(inputWinningNumber);
    }

    public void makeBonusNumber(Integer bonusNumber) {
        if(bonusNumber < BALL_MIN_RANGE || bonusNumber > BALL_MAX_RANGE) {
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

    public Result returnResult(List<Lotto> lottoes) {
        Result result = new Result();
        //로또번호를 한개씩 돌면서 결과를 반환한다
        for(int i=0;i<lottoes.size();i++ ){
            Integer duplicatedCnt = lottoes.get(i).countOverlappingBalls(winningNumber);
            boolean hasBonusNumber = lottoes.get(i).has(bonusNumber);
            result.record(duplicatedCnt, hasBonusNumber);
        }
        return result;
    }
}

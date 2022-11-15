package lotto.domain;

import java.util.List;

public class LottoPaper {
    public List<Integer> lottoNumber;

    public void setLottoNumber(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public int getResult(List<Integer> winningNumber, int bonusNumber) {
        if (this.lottoNumber.contains(bonusNumber)) {
            this.lottoNumber.retainAll(winningNumber);
            if (this.lottoNumber.size() == 5) {
                return 7; //보너스 예외 처리
            }
        }
        this.lottoNumber.retainAll(winningNumber);
        return this.lottoNumber.size();
    }
}

package lotto;

import static lotto.Constant.*;

import java.util.List;
import java.util.stream.Collectors;

public class Rank {
    // bonusNumber 1~45인지 확인하는 함수 추가
    private int bonusNumber;
    private Lotto lottoNumbers;

    public Rank() {
        this.bonusNumber = UI.getBonusNumber();
        this.lottoNumbers = UI.getLottoNumbers();
        validateBonusNumber();
    }

    private void validateBonusNumber() {
        List<Integer> lottoNum = lottoNumbers.getNumbers();
        lottoNum.add(bonusNumber);
        lottoNum = lottoNum.stream().distinct().collect(Collectors.toList());
        if (lottoNum.size() != (LOTTO_NUMBER_SIZE + 1)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호와 중복되지 않는 보너스 번호를 입력해주세요.");
        }
    }
}

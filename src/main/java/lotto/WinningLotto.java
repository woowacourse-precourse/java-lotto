package lotto;

import java.util.List;

public class WinningLotto extends Lotto{

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    @Override
    public void validateLottoSize(List<Integer> numbers){
        final int winningLottoSize = 7;
        if(numbers.size() != winningLottoSize){
            throw new IllegalArgumentException("[ERROR] 당첨 로또는 당첨 번호 6개와 보너스 번호 1개로 이루어져야 합니다.");
        }
    }
}

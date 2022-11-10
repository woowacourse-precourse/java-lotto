package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Manager {

    private List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;

    public int changeLottoCount(int money) {
        // TODO: money가 1천원 단위인지 확인
        return (money / 1000);
    }

    public int getCorrectCount(List<Integer> userLotto) {
        int correctCount = 0;

        Collections.sort(winningNumbers);
        Collections.sort(userLotto);

        for(int i = 0; i < Constant.LOTTO_SIZE; i++) {
            if(winningNumbers.get(i) == userLotto.get(i)) {
                correctCount++;
            }
        }

        return correctCount;
    }
}

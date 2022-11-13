package lotto.model;

import java.util.List;

public class LottoMachine {

    private List<Integer> answer;
    private int bonus;

    public void setLuckyNumber(List<Integer> answer, int bonus) {
        this.answer = answer;
        this.bonus = bonus;
    }

    public List<Lotto> publish(long price) {
        List<Integer> lottoNumber = List.of(1, 2, 3, 4, 5, 6);
        return List.of(new Lotto(lottoNumber));
    }

    public WinningRecord drawAll() {
        return new WinningRecord();
    }
}

package lotto.domain;

import java.util.Collections;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers;
    private final int bonus;

    public WinningNumbers(){
        numbers = initializeNumbers();
        bonus = initializeBonus();
    }

    private List<Integer> initializeNumbers(){
        return Collections.EMPTY_LIST;
    }

    private int initializeBonus(){
        return 0;
    }

    private void validateNumbers(){

    }

    private void validateBonus(){

    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonus() {
        return bonus;
    }
}

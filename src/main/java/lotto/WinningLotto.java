package lotto;

import java.util.List;

public class WinningLotto extends Lotto{
    private int bonnusNumber;

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    public static WinningLotto of(List<Integer> numbers) {
        return new WinningLotto(numbers);
    }

    public void setBonnusNumber(int bonnusNumber) {
        this.bonnusNumber = bonnusNumber;
    }

    public int getBonnusNumber() {
        return bonnusNumber;
    }
}

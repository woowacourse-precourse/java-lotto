package lotto;

import java.util.ArrayList;
import java.util.List;

public class BoughtLotto extends Lotto{
    public BoughtLotto() {
        super(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
    }

    private List<Integer> createLottoNumber() {
        return new ArrayList<>();
    }

    public void printLottoNumber() {

    }
}

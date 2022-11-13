package lotto;

import lotto.randomNumber.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class BoughtLotto extends Lotto{
    public BoughtLotto() {
        super(RandomNumber.createNumber());
    }

    public void printLottoNumber() {

    }
}

package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static constants.Constant.*;

public class TicketMachine {
    public int numberOfLotto;
    List<List<Integer>> myLotto = new ArrayList<>();


    TicketMachine(int numberOfLotto) {
        this.numberOfLotto = numberOfLotto;
    }

    public List<Integer>  generateNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);

        return numbers;
    }
    public List<List<Integer>> generateTickets() {
        for (int i = 0; i < this.numberOfLotto; i++) {
            List<Integer> lottoNumber = generateNumbers();
            Lotto lotto = new Lotto(lottoNumber);
            this.myLotto.add(lotto.getNumbers());
        }
        return myLotto;
    }
}
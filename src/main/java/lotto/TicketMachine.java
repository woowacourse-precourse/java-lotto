package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static constants.Constant.*;

public class TicketMachine {
    public int numberOfLotto;
    List<List<Integer>> myLotto = new ArrayList<>();

    TicketMachine(int numberOfLotto) {
        this.numberOfLotto = numberOfLotto;
        generateTickets();
        sortNumbers();
    }

    public List<List<Integer>> generateTickets() {
        for (int i = 0; i < this.numberOfLotto; i++) {
            List<Integer> tempNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
            List<Integer> numbers = new ArrayList<>();
            numbers.addAll(tempNumbers);
            this.myLotto.add(numbers);
        }
        return myLotto;
    }

    public void sortNumbers() {
        for (int i = 0; i < this.myLotto.size(); i++) {
            Collections.sort(this.myLotto.get(i));
        }
    }

    public List<List<Integer>> getTickets() {
        return this.myLotto;
    }

}
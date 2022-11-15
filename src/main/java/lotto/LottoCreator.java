package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

import constant.Message;

public class LottoCreator {

    public List<Integer> createNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(Message.SMALLESTNUMBER, Message.LARGESTNUMBER, Message.LOTTOLENGTH));
        Collections.sort(numbers);
        return numbers;
    }
}

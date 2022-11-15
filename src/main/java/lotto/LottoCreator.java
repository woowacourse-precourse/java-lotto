package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

import constant.Message;

public class LottoCreator {

    public List<Integer> createNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(Message.SMALLESTNUMBER, Message.LARGESTNUMBER, Message.LOTTOLENGTH));
        /*
            pickUniqueNumbersInRange(int a, int b, int c) : 한 리스트에 a ~ b 까지 숫자를 삽입한 후,
            그 리스트를 c 크기로 자른 후 Collections.Shuffle() 함수를 사용하여 무작위 구성의 형태로 반환하므로, 중복 없는 무작위 배열이 반환됨.
        */
        Collections.sort(numbers);
        return numbers;
    }
}

package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyLottoNumbers {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int SIZE = 6;

    private List<Integer> mine;
    List<Integer> myLottoNumbers;

    public List<Integer> getMyLottoNumbers() {
        mine = Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, SIZE);
        myLottoNumbers = new ArrayList<>(mine);
        Lotto lotto = new Lotto(myLottoNumbers);
        System.out.println(myLottoNumbers);
        Collections.sort(myLottoNumbers);
        return myLottoNumbers;
    }
    /**
     * Collections.sort를 사용하니 java.lang.UnsupportedOperationException 발생
     * new로 객체가 완전히 구현되지 않은 상태에서 사용했기 때문에 발생한다고 한다.
     * ArrayList 객체로 생성을 한 후 진행해도 똑같다.
     * 애초에 Randoms.pick... 여기서 ArrayList로 반환이 되는 것 같은데...
     * Test에서만 문제가 발생하니 Test를 더 확인해보도록 해야겠다.
     *
     * 테스트에서 List.of 를 사용하고 있기 때문에 예외가 발생하는 것이 아닌지 생각이 든다
     * 어떻게 해결할까...
     *
     * List.of로 생성한 것들을 ArrayList<>()에 넣어주면 해결할 수 있다고 한다.
     * 어떻게 넣어줄 것인가.
     * pickUniqueNumbersInRange 로 생성할 것들에
     * List.of 의 것들이 차례대로 들어간다는 것을 생각하자.
     * 해결!!!
     */
}

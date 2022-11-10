package lotto;

import java.util.List;

public class LottoPublisher {

    public List<Lotto> publishLottos(int payment) {
        // 구입 금액에 따른 로또 개수 계산
        // 개수 만큼 로또 발행
        return null;
    }

    private int numberOfLottos(int payment) {
        return payment % 1000;
    }

    private Lotto publishLotto() {
        // 서로 다른 6개의 숫자 리스트 생성
        // Lotto 생성
        return null;
    }

    private List<Integer> publishLottoNumbers() {
        // 서로 다른 6개의 숫자 set 생성
        return null;
    }
}

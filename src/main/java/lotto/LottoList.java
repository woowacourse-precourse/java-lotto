package lotto;

import util.ExceptionPharse;
import util.LottoStatus;
import util.MoneyStatus;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoList {
    private long lottoCount;
    private List<Lotto> lottos;
    private Lotto winningLotto;
    private int bonnusNumber;

    private long[] winningCount = new long[5];

    public LottoList(long amount) {
        this.lottoCount = amount / MoneyStatus.MONEY_DIVIDE.getStatus();
        this.lottos = new ArrayList<>();

        setLottoList();
    }

    public static void notDivThousand(long amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionPharse.IS_NOT_DIVIDED.getExceptionMsg());
        }
    }

    /**
     * 전체 로또 발행 함수
     */
    public void setLottoList() {
        for (int lottoIndex =0; lottoIndex < lottoCount; lottoIndex++ ) {
            List<Integer> numbers = getLottoNumbers();
            lottos.add(new Lotto(numbers));
        }
    }

    /**
     * 로또 6자리 값 자동 생성 함수
     * @return
     */
    public List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoStatus.MIN_NUMBER.getCode()
                , LottoStatus.MAX_NUMBER.getCode()
                , LottoStatus.LOTTO_SIZE.getCode());
    }

    public long getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}


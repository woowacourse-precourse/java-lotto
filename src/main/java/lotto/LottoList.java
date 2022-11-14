package lotto;

import Info.PrintGameInfo;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class LottoList {
    public static final int AMOUNT_UNIT = 1000;


    private BigInteger lottoAmount;
    private BigInteger lottoCount;
    private List<Lotto> lottos = new ArrayList<>();

    LottoList(BigInteger amount) {
        LottoList.notDivThousand(amount);

        this.lottoAmount = amount;
        this.lottoCount = lottoAmount.divide(BigInteger.valueOf(AMOUNT_UNIT));
        setAllLottoList();
    }

    public static void notDivThousand(BigInteger amount) {
        String remain = getRemainder(amount);

        if (!"0".equals(remain)) {
            throw new IllegalArgumentException(PrintGameInfo.getNotDivThousand());
        }
    }

    /**
     * 로또 결제 금액의 나머지 구하는 함수
     * @param amount
     * @return
     */
    public static String getRemainder(BigInteger amount) {
        return amount.remainder(BigInteger.valueOf(AMOUNT_UNIT)).toString();
    }


    public BigInteger getLottoAmount() {
        return lottoAmount;
    }
    public BigInteger getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
    /**
     * 전체 로또 발행 함수
     */
    public void setAllLottoList() {
        for(BigInteger lottoIndex = lottoCount; lottoIndex.compareTo(BigInteger.ZERO) > 0 ; lottoIndex.subtract(BigInteger.ONE)) {
            List<Integer> numbers = getLottoNumbers();
            lottos.add(new Lotto(numbers));
        }
    }

    /**
     * 로또 6자리 값 자동 생성 함수
     * @return
     */
    public List<Integer> getLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        while (lottoNumbers.size() < Lotto.LOTTO_NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(Lotto.LOTTO_MIN_NUMBER,Lotto.LOTTO_MAX_NUMBER);
            if (!lottoNumbers.contains(randomNumber)) {
                lottoNumbers.add(randomNumber);
            }
        }
        return lottoNumbers;
    }
}


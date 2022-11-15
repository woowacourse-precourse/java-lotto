package lotto;

import Info.LottoPoint;
import Info.PrintGameInfo;
import Info.WinningStatus;
import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.util.Sets;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoList {
    public static final int AMOUNT_UNIT = 1000;
    public static final int WIN_COUNT = 5;
    private BigInteger lottoAmount;
    private BigInteger lottoCount;
    private List<Lotto> lottos = new ArrayList<>();
    private Lotto winningLotto;
    private int bonnusNumber;
    private long totalMoney;
    private long[] winningCount = new long[WIN_COUNT];

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

    public Long getTotalMoney() {
        return totalMoney;
    }

    /**
     * WinningCount의 값 하나를 가져오는 함수
     * @param index 인덱스
     * @return
     */
    public long getWinningCountValue(int index) {
        return winningCount[index];
    }

    public void setWinningLotto(Lotto lotto) {
        checkNoDuplicateWinnningLotto(lotto);
        winningLotto = lotto;
    }

    public void setBonnusNumber(int bonnusNumber) {
        if (isContainNumber(winningLotto.getNumbers(), bonnusNumber)) {
            throw new IllegalArgumentException(PrintGameInfo.BONNUS_NUMBER_EXIST);
        }
        this.bonnusNumber = bonnusNumber;
    }

    /**
     * 전체 로또 발행 함수
     */
    public void setAllLottoList() {
        for(BigInteger lottoIndex = lottoCount; lottoIndex.compareTo(BigInteger.ZERO) > 0 ; lottoIndex = lottoIndex.subtract(BigInteger.ONE)) {
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
            if (!isContainNumber(lottoNumbers, randomNumber)) {
                lottoNumbers.add(randomNumber);
            }
        }
        return lottoNumbers;
    }

    /**
     * 로또 당첨 번호 자체 중복 여부 확인
     * @param lotto
     */
    private void checkNoDuplicateWinnningLotto(Lotto lotto) {
        Set<Integer> checkList = new HashSet<>(lotto.getNumbers());
        if (checkList.size() != lotto.getNumbers().size()) {
            throw new IllegalArgumentException(PrintGameInfo.DUPLICATE);
        }
    }

    private boolean isContainNumber(List<Integer> originList, int compare) {
        if (originList.contains(compare)) {
            return true;
        }
        return false;
    }

    /**
     * 구매한 로또 로또 담청번호와 비교하는 함수
     */
    public void checkAllLotto() {
        for (Lotto lotto : lottos) {
            int point = getEachLottoPoint(lotto);

            if (point < WinningStatus.THREE.getCorrectPoint()) {
                continue;
            }

            WinningStatus status = WinningStatus.getWinningStatusWithPoint(point);
            winningCount[status.getPointIndex()] += 1;
            totalMoney += status.getWinningMoney();
        }
    }

    /**
     * 로또 당첨 포인트 계산,
     * 5개가 일치하지 않을 때 보너스 포인트 맞으면, 보너스 볼 취소
     * @param lotto
     * @return
     */
    private int getEachLottoPoint(Lotto lotto) {
        Set<Integer> lottoNumbers = Sets.newHashSet(lotto.getNumbers());
        Set<Integer> winningNumbers = Sets.newHashSet(winningLotto.getNumbers());
        int point = 0;

        for (Integer number: lottoNumbers) {
            point += getPoint(winningNumbers, number);
        }

        if (!isFiveBonnus(point)) {
            point %= LottoPoint.BONNUS_POINT.getPoint();
        }
        return point;
    }

    /**
     * 값이 포함되어 있으면 포인트를 반납
     * @return
     */
    private int getPoint(Set<Integer> winningNumber, int lottoNumber) {
        if (winningNumber.contains(lottoNumber)) {
            return LottoPoint.CORRECT_POINT.getPoint();
        }

        if (lottoNumber == bonnusNumber) {
            return LottoPoint.BONNUS_POINT.getPoint();
        }

        return LottoPoint.WRONG_POINT.getPoint();
    }

    private boolean isFiveBonnus(int point) {
        int fivePoint = WinningStatus.FIVE.getCorrectPoint();
        if ((point % fivePoint) == fivePoint) {
            return true;
        }

        return false;
    }


}


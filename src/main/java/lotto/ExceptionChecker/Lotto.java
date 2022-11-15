package lotto.ExceptionChecker;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import lotto.EnumCreate.RangeNumber;

public class Lotto {
    private static final int AMOUNT_LOTTO_NUMBER = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        validateOverlap(lottoNumbers);
        validateRange(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    public List<Integer> getLotto() {

        return numbers;

    }

    private void validateSize(List<Integer> lottoNumbers) {

        try {
            if (lottoNumbers.size() != AMOUNT_LOTTO_NUMBER) {
                throw new IllegalArgumentException();
            }
        } catch (Exception IllegalArgumentException) {
            System.out.println("[ERROR] 6개의 숫자를 입력해주세요. ");//에러시 수행
            IllegalArgumentException.printStackTrace();
            throw new NoSuchElementException(); //최상위 클래스가 아니라면 무조건 던져주자
        }
    }

    private void validateOverlap(List<Integer> lottoNumbers) {
        HashSet<Integer> overlapChecker = new HashSet<>(lottoNumbers);
        try {
            if (overlapChecker.size() != 6) {
                throw new IllegalArgumentException();
            }

        } catch (Exception IllegalArgumentException) {
            System.out.println("[ERROR] 중복된 숫자를 입력하지 말아주세요. ");
            IllegalArgumentException.printStackTrace();
            throw new NoSuchElementException();
        }


    }


    private void validateRange(List<Integer> lottoNumbers) {

        try {
            if (!suitableRangeTrue(lottoNumbers)) {
                throw new IllegalArgumentException();
            }

        } catch (Exception IllegalArgumentException) {
            System.out.println("[ERROR] 당첨 번호의 범위를 1~45사이에서 입력해주세요. ");
            IllegalArgumentException.printStackTrace();
            throw new NoSuchElementException();
        }

    }

    private boolean suitableRangeTrue(List<Integer> lottoNumbers) {
        for (int i = 0; i < lottoNumbers.size(); i++) {
            if (lottoNumbers.get(i) > RangeNumber.RANGE_END.getRangeNumber()
                    || lottoNumbers.get(i) < RangeNumber.RANGE_START.getRangeNumber()) {
                return false;
            }
        }
        return true;

    }

    // TODO: 추가 기능 구현
}

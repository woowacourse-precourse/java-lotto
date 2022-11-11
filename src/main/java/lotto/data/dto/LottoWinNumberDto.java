package lotto.data.dto;

import java.util.Set;

public class LottoWinNumberDto {

    private final Set<Integer> winNumbers;
    private final int bonusNumber;

    LottoWinNumberDto(Set<Integer> winNumbers, int bonusNumber){
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Set<Integer> getWinNumbers() {
        return this.winNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    /**
     * 입력 단계의 순서가 바뀌거나, 앞뒤로 단계를 건너뛰어도 영향을 받지 않도록
     * 빌더 패턴을 사용했습니다.
     */

    public static LottoWinNumberDtoBuilder builder() {
        return new LottoWinNumberDtoBuilder();
    }

    public static class LottoWinNumberDtoBuilder {

        private Set<Integer> winNumbers;
        private int bonusNumber;

        LottoWinNumberDtoBuilder() {}

        public LottoWinNumberDtoBuilder winNumbers(Set<Integer> winNumbers) {
            this.winNumbers = winNumbers;
            return this;
        }

        public LottoWinNumberDtoBuilder bonusNumber(int bonusNumber) {
            this.bonusNumber = bonusNumber;
            return this;
        }

        public LottoWinNumberDto build() {
            return new LottoWinNumberDto(winNumbers, bonusNumber);
        }
    }
}

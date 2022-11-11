package lotto;

import lotto.domain.LottoResult;

import java.util.Map;

public class GameResultResponseDto {

    private final double earningRate;
    private final Map<String, LottoResultResponseDto> lottoResultResponseDtos;

    public static class LottoResultResponseDto {

        private final int sameNumberCount;
        private final int winnerPrice;
        private final boolean isBonus;
        private final int totalCount;

        public LottoResultResponseDto(int sameNumberCount, int winnerPrice, boolean isBonus, int totalCount) {
            this.sameNumberCount = sameNumberCount;
            this.winnerPrice = winnerPrice;
            this.isBonus = isBonus;
            this.totalCount = totalCount;
        }

        public int getSameNumberCount() {
            return sameNumberCount;
        }

        public int getWinnerPrice() {
            return winnerPrice;
        }

        public boolean isBonus() {
            return isBonus;
        }

        public int getTotalCount() {
            return totalCount;
        }
    }

    public GameResultResponseDto(double earningRate, Map<String, LottoResultResponseDto> lottoResultResponseDtos) {
        this.earningRate = earningRate;
        this.lottoResultResponseDtos = lottoResultResponseDtos;
    }

    public double getEarningRate() {
        return earningRate;
    }

    public LottoResultResponseDto getFirstDto() {
        return lottoResultResponseDtos.get(LottoResult.FIRST.name());
    }

    public LottoResultResponseDto getSecondDto() {
        return lottoResultResponseDtos.get(LottoResult.SECOND.name());
    }

    public LottoResultResponseDto getThirdDto() {
        return lottoResultResponseDtos.get(LottoResult.THIRD.name());
    }

    public LottoResultResponseDto getFourthDto() {
        return lottoResultResponseDtos.get(LottoResult.FOURTH.name());
    }

    public LottoResultResponseDto getFifthDto() {
        return lottoResultResponseDtos.get(LottoResult.FIFTH.name());
    }
}

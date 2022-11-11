package lotto.dto;

import lotto.domain.LottoResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameResultResponseDtos {

    private final double earningRate;
    private final Map<String, GameResultResponseDto> gameResultResponseDtos;

    public static class GameResultResponseDto {

        private final int sameNumberCount;
        private final int winnerPrice;
        private final boolean isBonus;
        private final int totalCount;

        public GameResultResponseDto(int sameNumberCount, int winnerPrice, boolean isBonus, int totalCount) {
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

    public GameResultResponseDtos(double earningRate, Map<String, GameResultResponseDto> gameResultResponseDtos) {
        this.earningRate = earningRate;
        this.gameResultResponseDtos = gameResultResponseDtos;
    }

    public double getEarningRate() {
        return earningRate;
    }

    public List<GameResultResponseDto> getGameResultResponseDtos() {
        List<GameResultResponseDto> dtos = new ArrayList<>();
        dtos.add(getFifthDto());
        dtos.add(getFourthDto());
        dtos.add(getThirdDto());
        dtos.add(getSecondDto());
        dtos.add(getFirstDto());
        return dtos;
    }

    private GameResultResponseDto getFirstDto() {
        return gameResultResponseDtos.get(LottoResult.FIRST.name());
    }

    private GameResultResponseDto getSecondDto() {
        return gameResultResponseDtos.get(LottoResult.SECOND.name());
    }

    private GameResultResponseDto getThirdDto() {
        return gameResultResponseDtos.get(LottoResult.THIRD.name());
    }

    private GameResultResponseDto getFourthDto() {
        return gameResultResponseDtos.get(LottoResult.FOURTH.name());
    }

    private GameResultResponseDto getFifthDto() {
        return gameResultResponseDtos.get(LottoResult.FIFTH.name());
    }
}

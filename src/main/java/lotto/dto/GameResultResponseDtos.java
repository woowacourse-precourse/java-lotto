package lotto.dto;

import java.util.List;

public class GameResultResponseDtos {

    private final double earningRate;
    private final List<GameResultResponseDto> gameResultResponseDtos;

    public static class GameResultResponseDto {

        private final int sameNumberCount;
        private final int winnerPrice;
        private final boolean hasBonus;
        private final int totalCount;

        public GameResultResponseDto(int sameNumberCount, int winnerPrice, boolean hasBonus, int totalCount) {
            this.sameNumberCount = sameNumberCount;
            this.winnerPrice = winnerPrice;
            this.hasBonus = hasBonus;
            this.totalCount = totalCount;
        }

        public int getSameNumberCount() {
            return sameNumberCount;
        }

        public int getWinnerPrice() {
            return winnerPrice;
        }

        public boolean hasBonus() {
            return hasBonus;
        }

        public int getTotalCount() {
            return totalCount;
        }
    }

    public GameResultResponseDtos(double earningRate, List<GameResultResponseDto> gameResultResponseDtos) {
        this.earningRate = earningRate;
        this.gameResultResponseDtos = gameResultResponseDtos;
    }

    public double getEarningRate() {
        return earningRate;
    }

    public List<GameResultResponseDto> getGameResultResponseDtos() {
        return gameResultResponseDtos;
    }
}

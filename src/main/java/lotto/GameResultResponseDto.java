package lotto;

public class GameResultResponseDto {

    private final double earningRate;

    public GameResultResponseDto(double earningRate) {
        this.earningRate = earningRate;
    }

    public double getEarningRate() {
        return earningRate;
    }
}

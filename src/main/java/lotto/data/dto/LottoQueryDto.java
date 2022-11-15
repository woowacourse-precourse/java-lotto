package lotto.data.dto;

public class LottoQueryDto {

    private final Long roundId;
    private final Long userId;

    public LottoQueryDto(Long roundId, Long userId) {
        this.roundId = roundId;
        this.userId = userId;
    }

    public Long getRoundId() {
        return roundId;
    }

    public Long getUserId() {
        return userId;
    }
}

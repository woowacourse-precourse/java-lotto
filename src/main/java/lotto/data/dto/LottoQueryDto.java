package lotto.data.dto;

public class LottoQueryDto {

    private final Long roundId;
    private final Long userId;

    private LottoQueryDto(Long roundId, Long userId) {
        this.roundId = roundId;
        this.userId = userId;
    }

    public Long getRoundId() {
        return roundId;
    }

    public Long getUserId() {
        return userId;
    }

    public static LottoQueryDtoBuilder builder() {
        return new LottoQueryDtoBuilder();
    }

    public static class LottoQueryDtoBuilder {

        private Long roundId;
        private Long userId;

        private LottoQueryDtoBuilder() {
        }

        public LottoQueryDtoBuilder roundId(Long roundId) {
            this.roundId = roundId;
            return this;
        }

        public LottoQueryDtoBuilder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public LottoQueryDto build() {
            return new LottoQueryDto(roundId, userId);
        }
    }
}

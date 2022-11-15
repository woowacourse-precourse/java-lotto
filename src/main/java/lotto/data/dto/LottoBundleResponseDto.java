package lotto.data.dto;

import java.util.List;

public class LottoBundleResponseDto {

    private final Long roundId;
    private final List<LottoDto> lottoDtos;

    public LottoBundleResponseDto(Long roundId, List<LottoDto> lottoDtos) {
        this.roundId = roundId;
        this.lottoDtos = lottoDtos;
    }

    public Long getRoundId() {
        return roundId;
    }

    public List<LottoDto> getLottoDtos() {
        return lottoDtos;
    }
}

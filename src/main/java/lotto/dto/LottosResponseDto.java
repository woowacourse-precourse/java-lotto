package lotto.dto;

import java.util.List;

public class LottosResponseDto {

    private final List<LottoResponseDto> lottoResponseDtos;

    public static class LottoResponseDto {

        private final List<Integer> lottoNumber;

        public LottoResponseDto(List<Integer> lottoNumber) {
            this.lottoNumber = lottoNumber;
        }

        public List<Integer> getLottoNumber() {
            return lottoNumber;
        }
    }

    public LottosResponseDto(List<LottoResponseDto> lottoResponseDtos) {
        this.lottoResponseDtos = lottoResponseDtos;
    }

    public List<LottoResponseDto> getLottoResponseDtos() {
        return lottoResponseDtos;
    }
}

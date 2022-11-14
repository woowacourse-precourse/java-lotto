package lotto.dto;

import java.util.List;

public class LottoResponseDtos {

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

    public LottoResponseDtos(List<LottoResponseDto> lottoResponseDtos) {
        this.lottoResponseDtos = lottoResponseDtos;
    }

    public List<LottoResponseDto> getLottoResponseDtos() {
        return lottoResponseDtos;
    }
}

package lotto.data.repository;

import lotto.data.dto.LottoWinNumberDto;

public class LottoWinNumberRepository {

    private static LottoWinNumberDto lottoWinNumberDto;

    public static LottoWinNumberDto getLottoWinNumberDto() {
        return lottoWinNumberDto;
    }

    public static void setLottoWinNumberDto(LottoWinNumberDto lottoWinNumberDto) {
        LottoWinNumberRepository.lottoWinNumberDto = lottoWinNumberDto;
    }
}

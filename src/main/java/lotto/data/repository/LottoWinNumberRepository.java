package lotto.data.repository;

import lotto.data.dto.LottoWinNumberDto;

public class LottoWinNumberRepository {

    private static LottoWinNumberRepository instance;

    private LottoWinNumberRepository() {}

    public static LottoWinNumberRepository getInstance() {
        if (instance == null) {
            assignNewInstance();
        }
        return instance;
    }

    private static void assignNewInstance() {
        synchronized (LottoWinNumberRepository.class) {
            instance = new LottoWinNumberRepository();
        }
    }

    private LottoWinNumberDto lottoWinNumberDto;

    public LottoWinNumberDto getLottoWinNumberDto() {
        return lottoWinNumberDto;
    }

    public void setLottoWinNumberDto(LottoWinNumberDto lottoWinNumberDto) {
        this.lottoWinNumberDto = lottoWinNumberDto;
    }
}

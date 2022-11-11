package lotto.data.type;

import lotto.data.dto.Lotto;
import lotto.data.dto.LottoWinNumberDto;

public enum LottoResultType {
    FIRST(2000000000) {
        @Override
        public boolean isAcquired(Lotto lotto, LottoWinNumberDto lottoWinNumberDto) {
            return getMatches(lotto, lottoWinNumberDto) == 6;
        }
    },
    SECOND(30000000) {
        @Override
        public boolean isAcquired(Lotto lotto, LottoWinNumberDto lottoWinNumberDto) {
            return getMatches(lotto, lottoWinNumberDto) == 5 &&
                    lotto.getNumbers().contains(lottoWinNumberDto.getBonusNumber());
        }
    },
    THIRD(1500000) {
        @Override
        public boolean isAcquired(Lotto lotto, LottoWinNumberDto lottoWinNumberDto) {
            return getMatches(lotto, lottoWinNumberDto) == 5;
        }
    },
    FOURTH(50000) {
        @Override
        public boolean isAcquired(Lotto lotto, LottoWinNumberDto lottoWinNumberDto) {
            return getMatches(lotto, lottoWinNumberDto) == 4;
        }
    },
    FIFTH(5000) {
        @Override
        public boolean isAcquired(Lotto lotto, LottoWinNumberDto lottoWinNumberDto) {
            return getMatches(lotto, lottoWinNumberDto) == 3;
        }
    };

    private static int getMatches(Lotto lotto, LottoWinNumberDto lottoWinNumberDto) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(number -> lottoWinNumberDto.getWinNumbers().contains(number))
                .count();
    }

    private final int amount;

    LottoResultType(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public abstract boolean isAcquired(Lotto lotto, LottoWinNumberDto lottoWinNumberDto);
}

package lotto.data.type;

import lotto.data.dto.Lotto;
import lotto.data.dto.LottoAnswerDto;

public enum LottoResultType {
    FIRST(2000000000) {
        @Override
        public boolean isAcquired(Lotto lotto, LottoAnswerDto lottoAnswerDto) {
            return getMatches(lotto, lottoAnswerDto) == 6;
        }
    },
    SECOND(30000000) {
        @Override
        public boolean isAcquired(Lotto lotto, LottoAnswerDto lottoAnswerDto) {
            return getMatches(lotto, lottoAnswerDto) == 5 &&
                    lotto.getNumbers().contains(lottoAnswerDto.getBonusNumber());
        }
    },
    THIRD(1500000) {
        @Override
        public boolean isAcquired(Lotto lotto, LottoAnswerDto lottoAnswerDto) {
            return getMatches(lotto, lottoAnswerDto) == 5;
        }
    },
    FOURTH(50000) {
        @Override
        public boolean isAcquired(Lotto lotto, LottoAnswerDto lottoAnswerDto) {
            return getMatches(lotto, lottoAnswerDto) == 4;
        }
    },
    FIFTH(5000) {
        @Override
        public boolean isAcquired(Lotto lotto, LottoAnswerDto lottoAnswerDto) {
            return getMatches(lotto, lottoAnswerDto) == 3;
        }
    };

    private static int getMatches(Lotto lotto, LottoAnswerDto lottoAnswerDto) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(number -> lottoAnswerDto.getNumbers().contains(number))
                .count();
    }

    private final int amount;

    LottoResultType(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public abstract boolean isAcquired(Lotto lotto, LottoAnswerDto lottoAnswerDto);
}

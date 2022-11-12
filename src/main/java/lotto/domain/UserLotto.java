package lotto.domain;

import lotto.domain.Guide;

public class UserLotto {
    private final int lottoAmount;

    public UserLotto(String lottoAmount) {
        validateIsNumeric(lottoAmount);
        int tmpLottoAmount = Guide.convertStringToInt(lottoAmount);
        validateCanDivideThousand(tmpLottoAmount);
        this.lottoAmount = tmpLottoAmount;
    }

    public int getLottoCount() {
        return (this.lottoAmount / 1000);
    }

    private void validateIsNumeric(String lottoAmount) {
        for(char c : lottoAmount.toCharArray()) {
            if (!(0 <= c - '0' && c - '0' <= 9)) {
                System.out.println("[ERROR} 복권 구입 금액은 양의 정수 형태이어야 합니다.");
                throw new IllegalArgumentException("[ERROR] 잘못된 형식의 복권 구입 금액");
            }
        }
    }

    private void validateCanDivideThousand(int lottoAmount) {
        if (lottoAmount % 1000 != 0) {
            System.out.println("[ERROR} 복권 구입 금액은 1000 으로 나누어 떨어져야 합니다.");
            throw new IllegalArgumentException("[ERROR] 잘못된 복권 구입 금액");
        }
    }
}

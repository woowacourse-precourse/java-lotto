package lotto.domain;

public enum NoticeMessage {
    PURCHASING_AMOUNT{
        @Override
        public String toString() {
            return "구입금액을 입력해 주세요.";
        }
    },
    LOTTO_COUNT{
        @Override
        public String toString() {
            return "개를 구매했습니다.";
        }
    },
    LUCKY_NUMBER{
        @Override
        public String toString() {
            return "당첨 번호를 입력해 주세요.";
        }
    },
    BONUS_NUMBER{
        @Override
        public String toString() {
            return "보너스 번호를 입력해 주세요.";
        }
    },
    ADDITIONAL_SECOND{
        @Override
        public String toString() {
            return ", 보너스 볼 일치";
        }
    }
}

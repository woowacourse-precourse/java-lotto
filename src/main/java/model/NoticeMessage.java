package model;

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
    }
}

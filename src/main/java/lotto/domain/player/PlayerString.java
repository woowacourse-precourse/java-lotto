package lotto.domain.player;

public enum PlayerString {
    NO_DIVIDE_MONEY("[ERROR] 구입 금액은 %d 단위만 가능합니다.");

    private final String content;

    PlayerString(String content){
        this.content = content;
    }

    public String print(int lottoPrice){
        return String.format(content, lottoPrice);
    }
}

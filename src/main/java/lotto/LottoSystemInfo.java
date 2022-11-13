package lotto;

public enum LottoSystemInfo {
    LAST(45),
    START(1),
    COUNT(6);

    int num;

    LottoSystemInfo(int number) {
        this.num = number;
    }
}

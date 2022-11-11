package lotto.domain;

public class User {

    private int lottoCount;

    public User(int purchase){
        this.lottoCount = purchase / 1000;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}

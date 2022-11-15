package lotto.io;

public interface Output {

    void print(Message message);

    void print(Message yieldMsg, float yield);

    void print(Message message, Long number);

    void print(String string);

    void print(String string, Long number);

    void print(Message lottoResult, Integer matchCount, float rankMoney, Long aLong);
}

package lotto.io;

public interface Output {

    void print(Message message);

    void print(Message message, Long number);

    void print(String string);

    void print(String yield, String format);
}

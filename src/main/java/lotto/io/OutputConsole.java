package lotto.io;

public class OutputConsole implements Output {

    @Override
    public void print(Message message) {
        System.out.print(message.getMessage());
    }

    @Override
    public void print(Message message, Long number) {
        System.out.printf((message.getMessage()) + "%n", number);
    }

    @Override
    public void print(String string) {
        System.out.println(string);
    }

    @Override
    public void print(String yield, String format) {
        System.out.printf(yield + "%n", format);
    }

}

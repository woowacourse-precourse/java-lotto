package lotto.io;

public class OutputConsole implements Output {

    @Override
    public void print(Message message) {
        System.out.print(message.getMessage());
    }

    @Override
    public void print(Message yieldMsg, float yield) {
        System.out.printf((yieldMsg.getMessage()) + "%n", yield);
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
    public void print(String string, Long number) {
        System.out.printf(string + "%n", number); // %n -> 지워도 되나???
    }

    @Override
    public void print(Message lottoResult, Integer matchCount, float rankMoney, Long aLong) {

    }

}

package lotto;

public class Application {
    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.play();

        LottoMachine machine = new LottoMachine();
        machine.run();

        Statistics stat = new Statistics();
        stat.print();
    }
}
package lotto;

import lotto.machine.Machine;

public class Application {
    public static void main(String[] args) {
        Machine machine = new Machine();
        try{
            machine.run();
        } catch (IllegalArgumentException err) {
            machine.Print_ERROR(err.getMessage());
        }
    }
}

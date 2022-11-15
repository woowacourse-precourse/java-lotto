package lotto;

import lotto.system.Program;

public class Application {

    public static void main(String[] args) {
        try {
            Program program = new Program();
            program.startProgram();
            program.winningProgram();
            program.statisticsProgram();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}

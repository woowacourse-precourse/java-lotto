package lotto;


import lotto.controller.AutomaticDispenser;
import lotto.controller.Matcher;
import lotto.controller.Printer;
import lotto.domain.History;
import lotto.shell.Shell;

public class Application {
    Shell shell;
    AutomaticDispenser automaticDispenser;
    History history;
    Matcher matcher;
    Printer printer;

    public Application() {
        this.shell = new Shell();
        this.automaticDispenser = new AutomaticDispenser();
        this.history = new History();
        this.matcher = new Matcher();
        this.printer = new Printer();
    }

    public static void main(String[] args) {

        Application application = new Application();

        application.shell.injectInOrder();
        application.automaticDispenser.dispenseAutomatically();
        application.matcher.buildMatchCount();
        application.history.getMatchResult();
        application.history.getYieldResult();
        application.printer.printMatchResult();
        application.printer.printYieldResult();


    }

}

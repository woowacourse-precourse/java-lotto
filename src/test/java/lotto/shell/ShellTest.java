package lotto.shell;


import org.junit.jupiter.api.BeforeEach;

class ShellTest {

    Shell shell;
    Amount amount;
    WinningNumber winningNumber;
    BonusNumber bonusNumber;
    ShellException shellException;

    @BeforeEach
    public void setUp() {

        shell = new Shell();
        amount = new Amount();
        winningNumber = new WinningNumber();
        bonusNumber = new BonusNumber();
        shellException = new ShellException();

    }
}
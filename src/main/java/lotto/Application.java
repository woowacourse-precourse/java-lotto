package lotto;

public class Application {

    public static void main(String[] args)  {
        I_O_System IO = new I_O_System();
        // TODO: 프로그램 구현
            if(!IO.Enter_Price())
                return;
        IO.Enter_WinningNumber();
    }

}

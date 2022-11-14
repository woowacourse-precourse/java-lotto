package lotto.input;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputManager implements InputManager{

    private volatile static ConsoleInputManager consoleInputManager;

    private ConsoleInputManager(){}

    @Override
    public String readLine() {
        return Console.readLine();
    }

    public static ConsoleInputManager getInstance()
    {
        if(consoleInputManager == null)
        {
            synchronized (ConsoleInputManager.class)
            {
                if(consoleInputManager == null)
                {
                    consoleInputManager = new ConsoleInputManager();
                }
            }
        }
        return consoleInputManager;
    }
}

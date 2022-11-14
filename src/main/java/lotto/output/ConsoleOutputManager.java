package lotto.output;

public class ConsoleOutputManager implements OutputManager{
    private volatile static ConsoleOutputManager consoleOutputManager;

    private ConsoleOutputManager(){}

    @Override
    public void write(String message) {
        System.out.print(message);
    }

    public static ConsoleOutputManager getInstance()
    {
        if(consoleOutputManager == null)
        {
            synchronized (ConsoleOutputManager.class)
            {
                if(consoleOutputManager == null)
                {
                    consoleOutputManager = new ConsoleOutputManager();
                }
            }
        }
        return consoleOutputManager;
    }

}

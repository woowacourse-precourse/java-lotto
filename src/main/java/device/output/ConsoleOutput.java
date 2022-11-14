package device.output;

import device.message.Message;

public class ConsoleOutput implements Output{

    public void print(String string) {
        System.out.println(string);
    }

    public void print(Message message) {
        System.out.println(message.toString());
    }
}

package device.output;

import device.message.Message;

public interface Output {

    void print(String string);
    void print(Message message);
}

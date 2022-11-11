package lotto;

import io.Input;
import io.InputKeyboard;
import io.Output;
import io.OutputScreen;
import io.Sentence;

public class Application {
    public static void main(String[] args) {

        Input input = new InputKeyboard();
        Output output = new OutputScreen();

        //output.printOutput(Sentence.INPUTMONEY);
        Game game = new Game(input, output);
        game.run();

        // TODO: 프로그램 구현
    }
}

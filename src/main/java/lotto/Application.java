package lotto;

import device.input.ConsoleInput;
import device.output.ConsoleOutput;
import lotto.setting.LottoApplicationSetting;

public class Application {
    public static void main(String[] args) {
        new LottoApplication(new ConsoleInput(), new ConsoleOutput(), LottoApplicationSetting.NORMAL).run();
    }
}

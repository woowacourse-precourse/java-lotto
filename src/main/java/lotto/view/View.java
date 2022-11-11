package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public abstract class View {

    public abstract void show();

    public String getResponse() {
        return "";
    }

    public void setPrintElement(List<String> elements) {
        return;
    }

}

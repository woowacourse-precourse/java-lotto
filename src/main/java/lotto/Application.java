package lotto;

import lotto.domain.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        try {
            Run run = new Run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

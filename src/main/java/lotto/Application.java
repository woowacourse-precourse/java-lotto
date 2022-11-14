package lotto;

import lotto.domain.Checker;
import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.Store;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        try {
            Lotto.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

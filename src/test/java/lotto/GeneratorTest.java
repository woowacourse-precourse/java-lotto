package lotto;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {

    @Test
    void createLotto() {
        Generator generator = new Generator();
        Lotto lotto = generator.createLotto();
        System.out.println(lotto);

    }

}
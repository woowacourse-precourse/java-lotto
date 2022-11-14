package lotto.Function;

import lotto.Controller;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {

    @Test
    void makeNumbers() {
        Generator generator = new Generator();
        List<List<Integer>> list = generator.makeNumbers(3);
        System.out.println(list);
    }
}
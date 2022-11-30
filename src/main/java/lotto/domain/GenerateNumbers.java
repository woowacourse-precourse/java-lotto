package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface GenerateNumbers {

    List<Integer> generate();
}
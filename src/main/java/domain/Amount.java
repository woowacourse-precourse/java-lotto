package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Amount {
    enum grade {first, second, third, fourth, fifth}

    private final List<grade> winning_amount = Arrays.asList(grade.first, grade.second, grade.third, grade.fourth, grade.fifth);

}

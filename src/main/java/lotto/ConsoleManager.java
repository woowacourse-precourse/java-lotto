package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleManager {
    public List<Integer> readNextIntegers(String delimiter){
        return Stream.of(readLine().split(delimiter))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Integer readNextInteger(){
        return Integer.parseInt(readLine());
    }
}

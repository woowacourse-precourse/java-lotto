package io;

public class OutputScreen implements Output{

    @Override
    public String printOutput(Sentence sentence) {

        System.out.println(sentence.getValue());
        return null;
    }
}

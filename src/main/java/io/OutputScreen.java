package io;

public class OutputScreen implements Output{

    @Override
    public String printOutput(String sentence) {

        System.out.println(sentence);
        return null;
    }
}

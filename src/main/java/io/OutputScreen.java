package io;

public class OutputScreen implements Output{

    @Override
    public void printOutput(String sentence) {
        System.out.println(sentence);
    }
}

package de.atgo.brainfuck;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.IOException;

public class Interpreter {

    private final static String programm = "+>++[[--]<-]";


    public static void main(String[] args) throws IOException {
        final var input = CharStreams.fromString(programm);

        final var lexer = new BrainfuckLexer(input);
        final var tokens = new CommonTokenStream(lexer);

        final var parser = new BrainfuckParser(tokens);

        final var abs = parser.prog();
        final var interpreter = new TreeInterpreter(MemoryFactory.createMemory());

        interpreter.visit(abs);
    }

}

package de.atgo.brainfuck;

import de.atgo.brainfuck.internal.MemoryImpl;

public class MemoryFactory {

    public static Memory createMemory() {
        return new MemoryImpl();
    }

}

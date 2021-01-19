package de.atgo.brainfuck.internal;

import de.atgo.brainfuck.Memory;

import java.util.LinkedList;
import java.util.List;

public final class MemoryImpl implements Memory {

    private int pointer;
    private final List<Integer> memory;

    public MemoryImpl() {
        this.memory = new LinkedList<>();
        this.pointer = 0;
        this.memory.add(0);
    }

    @Override
    public void movel() {
        --pointer;
        if (pointer < 0) {
            memory.add(0, 0);
            ++pointer;
        }
    }

    @Override
    public void mover() {
        ++pointer;
        if (pointer >= memory.size()) {
            memory.add(pointer, 0);
        }
    }

    @Override
    public void incPtr() {
        memory.set(pointer, memory.get(pointer) +1);
    }

    @Override
    public void decPtr() {
        memory.set(pointer, memory.get(pointer) -1);
    }

    @Override
    public int getPtr() {
        return memory.get(pointer);
    }

    @Override
    public void setPtr(int value) {
        memory.set(pointer, value);
    }
}

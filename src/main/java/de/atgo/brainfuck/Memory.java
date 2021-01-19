package de.atgo.brainfuck;

public interface Memory {

    void movel();

    void mover();

    void incPtr();

    void decPtr();

    int getPtr();

    void setPtr(int value);

}

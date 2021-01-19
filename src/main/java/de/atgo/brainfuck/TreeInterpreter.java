package de.atgo.brainfuck;

import java.io.IOException;

public class TreeInterpreter extends BrainfuckBaseVisitor<Void> {

    private final Memory memory;

    public TreeInterpreter(Memory memory) {
        this.memory = memory;
    }

    @Override
    public Void visitMovr(BrainfuckParser.MovrContext ctx) {
        this.memory.mover();
        return null;
    }

    @Override
    public Void visitMovl(BrainfuckParser.MovlContext ctx) {
        this.memory.movel();
        return null;
    }

    @Override
    public Void visitInc(BrainfuckParser.IncContext ctx) {
        this.memory.incPtr();
        return null;
    }

    @Override
    public Void visitDec(BrainfuckParser.DecContext ctx) {
        this.memory.decPtr();
        return null;
    }

    @Override
    public Void visitOut(BrainfuckParser.OutContext ctx) {
        System.out.print((char)this.memory.getPtr());
        return null;
    }

    @Override
    public Void visitIn(BrainfuckParser.InContext ctx) {
        try {
            final var input = System.in.read();
            this.memory.setPtr(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Void visitLoop(BrainfuckParser.LoopContext ctx) {
        while (this.memory.getPtr() != 0) {
            ctx.stat().forEach(this::visit);
        }
        return null;
    }

    @Override
    public Void visitProg(BrainfuckParser.ProgContext ctx) {
        return super.visitProg(ctx);
    }
}

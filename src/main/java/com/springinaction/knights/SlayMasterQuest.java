package com.springinaction.knights;

import java.io.PrintStream;

public class SlayMasterQuest implements Quest{

    private PrintStream printStream;

    public SlayMasterQuest(PrintStream printStream){
        this.printStream = printStream;
    }

    @Override
    public void embark() {
        printStream.println("Embarking on quest to slay the master");
    }
}

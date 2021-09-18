package com.springinaction.knights;

public class DamselRescuingKnight {
    private RescueDamselQuest quest;

    public DamselRescuingKnight() { //与RescueDamselQuest紧耦合
        quest = new RescueDamselQuest();
    }

    public void embarkOnQuest() {
        quest.embark();
    }
}

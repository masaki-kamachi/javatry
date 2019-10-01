package org.docksidestage.bizfw.basic.objanimal;

public class BarkProcess {

    public BarkedSound bark(Animal animal) {
        animal.breatheIn();
        animal.prepareAbdominalMuscle();
        BarkedSound barkedSound = doBark(animal);
        return barkedSound;
    }

    protected BarkedSound doBark(Animal animal) {
        animal.downHitPoint();
        return new BarkedSound(animal.getBarkWord());
    }
}

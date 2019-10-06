package org.docksidestage.bizfw.basic.objanimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author masaki.kamachi
 */
public class BarkProcess {

    private static final Logger logger = LoggerFactory.getLogger(Animal.class);

    public BarkedSound bark(Animal animal) {
        breatheIn(animal);
        prepareAbdominalMuscle(animal);
        BarkedSound barkedSound = doBark(animal);
        return barkedSound;
    }

    protected void breatheIn(Animal animal) {
        logger.debug("...Breathing in"); // dummy implementation
        animal.downHitPoint();
    }

    protected void prepareAbdominalMuscle(Animal animal) {
        logger.debug("...Using my abdominal muscle"); // dummy implementation
        animal.downHitPoint();
    }

    protected BarkedSound doBark(Animal animal) {
        animal.downHitPoint();
        return new BarkedSound(animal.getBarkWord());
    }

}

package org.docksidestage.bizfw.basic.objanimal;

/**
 * @author masaki.kamachi
 */
public class ZombieBarkedProcess extends BarkProcess {

    @Override
    protected void breatheIn(Animal animal) {
        super.breatheIn(animal);
        Zombie zombie = (Zombie) animal;
        zombie.zombieDiary.countBreatheIn();
    }
}

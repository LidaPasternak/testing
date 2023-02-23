package org.example;

public class Cat extends Animal implements SoundProducing{
    @Override
    public void produceSound() {
        System.out.println("Meow");
    }
}

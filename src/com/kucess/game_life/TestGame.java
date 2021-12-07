package com.kucess.game_life;

import org.junit.Assert;
import org.junit.Test;

public class TestGame {

    @Test
    public void testCloningGame(){

        boolean[][] arr = {
                {false, true, false},
                {false, true, false},
                {false, true, false}
        };

        GameLife gameLife = new GameLife(3);
        gameLife.setIndex(arr);

        GameLife copied = (GameLife) gameLife.clone();

        print("Before copy:");
        print(gameLife);
        print(copied);

        // Change array index in gameoflife, index of copied should not change!
        gameLife.getIndex()[0][0] = true;
        gameLife.getIndex()[1][1] = false;

        print(gameLife.getIndex()[0][0]);
        print(copied.getIndex()[0][0]);

        Assert.assertFalse(gameLife.getIndex()[1][1]);
        Assert.assertTrue(copied.getIndex()[1][1]);

        print("After copy:");
        print(gameLife);
        print(copied);
    }

    @Test
    public void testExecute() throws InterruptedException {

        GameLife game = new GameLife(15);
        game.setRandomPosition(.3);

        Thread thread = new Thread(game);

        thread.start();

        thread.join();
    }

    private void print(Object object){
        System.out.println(object);
    }

}
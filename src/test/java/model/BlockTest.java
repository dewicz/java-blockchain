package model;

import org.junit.Assert;
import org.junit.Test;


public class BlockTest {


    @Test
    public void calculateHash() {
        Block b = new Block("First block", "0");
        String hash = b.calculateHash();
        Assert.assertEquals(64, hash.length());
    }
}
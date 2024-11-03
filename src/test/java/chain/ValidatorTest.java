package chain;

import model.Block;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ValidatorTest {

    List<Block> blockchain = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        blockchain.add(new Block("First block", "0"));
        blockchain.add(new Block("Second block", blockchain.get(blockchain.size()-1).getHash()));
        blockchain.add(new Block("Third block", blockchain.get(blockchain.size()-1).getHash()));
    }

    @Test
    public void isChainValidTrue() {
        Assert.assertTrue(Validator.isChainValid(blockchain));
    }

    @Test
    public void isChainValidFalse() {
        blockchain.add(new Block("Fourth block", "3"));
        Assert.assertFalse(Validator.isChainValid(blockchain));
        blockchain.remove(3);
    }
}
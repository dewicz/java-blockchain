package chain;

import model.Block;
import org.tinylog.Logger;

import java.util.List;

public class Validator {
    public static boolean isChainValid(List<Block> chain) {
        Block current;
        Block previous;

        for(int i=1; i<chain.size(); i++) {
            current = chain.get(i);
            previous = chain.get(i-1);

            if(!current.getHash().equals(current.calculateHash())) {
                Logger.info("Current hashes not equal");
                return false;
            }

            if(!previous.getHash().equals(current.getPreviousHash())) {
                Logger.info("Previous hashes not equal");
                return false;
            }
        }
        return true;
    }
}

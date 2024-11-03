import chain.Validator;
import com.google.gson.GsonBuilder;
import model.Block;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Block> blockchain = new ArrayList<>();

    public static void main(String[] args) {

        blockchain.add(new Block("First block", "0"));
        blockchain.add(new Block("Second block", blockchain.get(blockchain.size()-1).getHash()));
        blockchain.add(new Block("Third block", blockchain.get(blockchain.size()-1).getHash()));

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);

    }
}

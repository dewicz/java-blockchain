package model;

import lombok.Getter;
import util.StringUtil;

import java.util.Date;

@Getter
public class Block {
    public String hash;
    public String previousHash;
    private String data;
    private long timeStamp;

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();

    }

    public String calculateHash() {
        return StringUtil.applySha256(previousHash + Long.toString(timeStamp) + data);
    }
}
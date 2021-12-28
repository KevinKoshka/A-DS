package cypher;

public class CaesarCypher {
    protected int charLength = 26;
    protected int initChar = (int)('A');
    protected int[] charMap = new int[this.charLength];
    protected int[] encodedCharMap = new int[this.charLength];
    protected int rotation;

    public CaesarCypher(int rotation) {
        this.rotation = rotation;
        for (int i = 0; i < this.charLength; i++) {
            charMap[i] = this.initChar + (i + rotation) % 26;
            encodedCharMap[i] = this.initChar + (this.charLength + i - rotation) % 26;
        }
    }

    protected String transform(String msg, int[] decoder) {
        char[] msgArray = msg.toUpperCase().toCharArray();
        char[] encodedArr = new char[msgArray.length];
        for (int index = 0; index < msgArray.length; index++) {
            int currentCharBit = (int)(msgArray[index]);
            if (currentCharBit >= this.initChar && currentCharBit < (this.initChar + this.charLength)) {
                encodedArr[index] = (char)(decoder[currentCharBit - this.initChar]);
            } else {
                encodedArr[index] = msgArray[index];
            }
        }
        return new String(encodedArr);
    }

    public String encode(String msg) {
        return this.transform(msg, this.encodedCharMap);
    }

    public String decode(String msg) {
        return this.transform(msg, this.charMap);
    }

}
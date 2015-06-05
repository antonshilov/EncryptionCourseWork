package encrypt.encrypter;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;


public class Morse implements IEncyptor {
    BiMap<Character, String> mapEncode = HashBiMap.create();

    public Morse() {
        mapEncode.put('a', ".-");
        mapEncode.put('b', "-...");
        mapEncode.put('c', "-.-.");
        mapEncode.put('d', "-..");
        mapEncode.put('e', ".");
        mapEncode.put('f', "..-.");
        mapEncode.put('g', "--.");
        mapEncode.put('h', "....");
        mapEncode.put('i', "..");
        mapEncode.put('j', ".---");
        mapEncode.put('k', "-.-");
        mapEncode.put('l', ".-..");
        mapEncode.put('m', "--");
        mapEncode.put('n', "-.");
        mapEncode.put('o', "---");
        mapEncode.put('p', ".--.");
        mapEncode.put('q', "--.-");
        mapEncode.put('r', ".-.");
        mapEncode.put('s', "...");
        mapEncode.put('t', "-");
        mapEncode.put('u', "..-");
        mapEncode.put('v', "...-");
        mapEncode.put('w', ".--");
        mapEncode.put('x', "-..-");
        mapEncode.put('y', "-.--");
        mapEncode.put('z', "--..");
        mapEncode.put('1', ".----");
        mapEncode.put('2', "..---");
        mapEncode.put('3', "...--");
        mapEncode.put('4', "....-");
        mapEncode.put('5', ".....");
        mapEncode.put('6', "-....");
        mapEncode.put('7', "--...");
        mapEncode.put('8', "---..");
        mapEncode.put('9', "----.");
        mapEncode.put('0', "-----");
    }

    public String encrypt(String text) {
        String result = "";
        String buff;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                result += "|";
            } else {
                buff = mapEncode.get(c);
                if (buff == null) {
                    System.out.println("Unaccepted symbol");
                    return null;
                } else result += buff;
                result += " ";
            }
        }
        System.out.println(result);
        return text;
    }

    public String decrypt(String text) {
        String result = "";
        String buff;
        BiMap<String, Character> mapDecode = mapEncode.inverse();
        for (int i = 0; i < text.length(); i++) {
            buff = "";
            while ((text.charAt(i) != ' ') || (i < text.length())) { //|| text.charAt(i) != '|' || i <text.length()){
                buff += text.charAt(i);
                i++;
            }
            if (text.charAt(i) == ' ') {
                buff = String.valueOf(mapDecode.get(buff));
            } else if (text.charAt(i) == '|') {
                buff = String.valueOf(mapDecode.get(buff));
                buff += ' ';
            }
            result += buff;
        }
        return result;
    }
}

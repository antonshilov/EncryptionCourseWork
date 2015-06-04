package encrypt.encrypter;

import java.util.HashMap;
import java.util.Map;

public class Morse {
    Map<Character, String> mapEncode = new HashMap<>();
    public Morse(){
        mapEncode.put('a', ".-");
        mapEncode.put('b', "-...");
        mapEncode.put('c',  "-.-");
        mapEncode.put('d',  "-..");
        mapEncode.put('e',    ".");
        mapEncode.put('f', "..-.");
        mapEncode.put('g',  "--.");
        mapEncode.put('h', "....");
        mapEncode.put('i',   "..");
        mapEncode.put('j', ".---");
        mapEncode.put('k',   "-.");
        mapEncode.put('l', ".-..");
        mapEncode.put('m',   "--");
        mapEncode.put('n',   "-.");
        mapEncode.put('o',  "---");
        mapEncode.put('p', ".--.");
        mapEncode.put('q', "--.-");
        mapEncode.put('r', ".-.");
        mapEncode.put('s',  "...");
        mapEncode.put('t',   "-");
        mapEncode.put('u',  "..-");
        mapEncode.put('v', "...-");
        mapEncode.put('w',  ".--");
        mapEncode.put('x', "-..-");
        mapEncode.put('y', "-.--");
        mapEncode.put('z', "--..");
        mapEncode.put('1', ".----");
        mapEncode.put('2',"..---");
        mapEncode.put('3', "...--");
        mapEncode.put('4', "....-");
        mapEncode.put('5', ".....");
        mapEncode.put('6', "-....");
        mapEncode.put('7', "--...");
        mapEncode.put('8', "---..");
        mapEncode.put('9', "----.");
        mapEncode.put('0', "-----");
    }
    public String encode(String text){
        String result ="";
        for(char c : text.toCharArray()) {
            result+=mapEncode.get(c);
            result+=" ";
        }
        System.out.println(result);
        return text;
    }
}

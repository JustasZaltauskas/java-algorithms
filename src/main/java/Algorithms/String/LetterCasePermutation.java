package Algorithms.String;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public static List<String> find(String S) {
        List<String> res = new ArrayList();
        res.add(S);

        for (int i = 0; i < S.length() - 1 ; i++) {
            if (Character.isDigit(S.charAt(i))) {
                continue;
            }

            int resLen = res.size();

            for (int j = 0; j < resLen; j++) {
                String s = res.get(j);
                char c = s.charAt(i);
                char newChar = Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c);
                res.add(s.substring(0, i) + newChar + s.substring(i + 1));
            }
        }

        return res;
    }
}

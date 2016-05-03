package three;

/**
 * Created by zhenhui on 2016/5/3.
 */
public class Contains_String_3_1 {

    public static boolean isContains(String A, String B) {
        char[] As = A.toCharArray();
        int len = As.length;
        for (int i = 0; i < len; i++) {
            char t = As[0];
            for (int j = 0; j < len-1; j++) {
                As[j] = As[j+1];
            }
            As[len-1] = t;
            if (String.valueOf(As).contains(B)) return true;
        }
        return false;
    }

    /**
     * 以空间换时间
     * 观察到规律，对A做循环移位的字符串都是AA的子串
     * */
    public static boolean isContains2(String A, String B) {
        String AA = A + A;
        return AA.contains(B);
    }

    /**
     * 不用真实移位，等同于对下标取余
     * */
    public static boolean isContains3(String A, String B) {
        char[] As = A.toCharArray();
        char[] Bs = B.toCharArray();
        int lenA = As.length;
        int lenB = Bs.length;
        for (int i = 0; i < lenA; i++) {
            int j = i;
            int k = 0;
            while (As[j] == Bs[k]) {
                j = (j+1) % lenA;
                k++;
                if (k == lenB) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = isContains3("ABBCD", "CDAB");
        System.out.println(b);
    }
}

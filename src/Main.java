public class Main {
    public static void main(String[] args) {
        /*
        * На вход подаются только маленькие латинские буквы
        * ограничения по ключу (вы говорили 10) по идее нет
        * */


        char[] array = {'h', 'o', 'b', 'b', 'i', 't'};
        char[] encodedArr = {'k', 'r', 'e', 'e', 'l', 'w'};
        int key = 3;

        char[] res = encodeToCaesar(array, key);

        char[] decodedArr = decodeFromCaesar(encodedArr, key);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

        for (int i = 0; i < decodedArr.length; i++) {
            System.out.println(decodedArr[i]);
        }


        System.out.println(encodeToCaesar("hobbit", key));
        System.out.println(decodeFromCaesar("kreelw", key));

    }

    public static char[] encodeToCaesar(char[] letters, int key) {
        final int FIRSTNUM = 97;
        final int LASTNUM = 122;
        key %= 26;

        char[] res = new char[letters.length];

        for (int i = 0; i < letters.length; i++) {
            int letterCode = (int)letters[i] + key;

            if (letterCode > LASTNUM) {
                letterCode = FIRSTNUM + (letterCode % LASTNUM) - 1;
            } else if (letterCode < FIRSTNUM) {
                letterCode = LASTNUM - (FIRSTNUM % letterCode) + 1;
            }

            res[i] = (char)(letterCode);
        }
        return res;
    }

    public static String encodeToCaesar(String string, int key) {
        final int FIRSTNUM = 97;
        final int LASTNUM = 122;
        key %= 26;

        char[] letters = string.toCharArray();

        char[] res = new char[letters.length];

        for (int i = 0; i < res.length; i++) {
            int letterCode = (int)letters[i] + key;

            if (letterCode > LASTNUM) {
                letterCode = FIRSTNUM + (letterCode % LASTNUM) - 1;
            } else if (letterCode < FIRSTNUM) {
                letterCode = LASTNUM - (FIRSTNUM % letterCode) + 1;
            }

            res[i] = (char)(letterCode);
        }
        return new String(res);
    }

    public static char[] decodeFromCaesar(char[] letters, int key) {
        final int FIRSTNUM = 97;
        final int LASTNUM = 122;

        key %= 26;

        char[] res = new char[letters.length];

        for (int i = 0; i < letters.length; i++) {
            int letterCode = (int)letters[i] - key;

            if (letterCode > LASTNUM) {
                letterCode = LASTNUM - (FIRSTNUM % letterCode) + 1;
            } else if (letterCode < FIRSTNUM) {
                letterCode = FIRSTNUM + (letterCode % LASTNUM) - 1;
            }

            res[i] = (char)(letterCode);
        }
        return res;
    }

    public static String decodeFromCaesar(String string, int key) {
        final int FIRSTNUM = 97;
        final int LASTNUM = 122;
        key %= 26;

        char[] letters = string.toCharArray();

        char[] res = new char[letters.length];

        for (int i = 0; i < res.length; i++) {
            int letterCode = (int)letters[i] - key;

            if (letterCode > LASTNUM) {
                letterCode = LASTNUM - (FIRSTNUM % letterCode) + 1;
            } else if (letterCode < FIRSTNUM) {
                letterCode = FIRSTNUM + (letterCode % LASTNUM) - 1;
            }

            res[i] = (char)(letterCode);
        }
        return new String(res);
    }
}
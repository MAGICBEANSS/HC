package prc.hc.sessiontests.secondtest;

public class Pineapple {

    public static void main(String[] args) {
        int n = new Pineapple().solve("PMP",3);
        System.out.println(n);
    }

    public int solve(String s, int n) {
        int mangoes = 0, pineapples = 0;
        for (char c : s.toCharArray()) {
            if (c == 'M') {
                mangoes++;
            } else {
                pineapples++;
            }
        }

        int prefixMangoes = 0, prefixPineapples = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'M') {
                prefixMangoes++;
            } else {
                prefixPineapples++;
            }

            int remainingMangoes = mangoes - prefixMangoes;
            int remainingPineapples = pineapples - prefixPineapples;

            if (prefixMangoes > 0 && remainingMangoes > 0 && prefixMangoes != remainingMangoes &&
                    prefixPineapples != remainingPineapples) {
                return i + 1;
            }
        }

        return -1;
    }
        public static int solveold(String s, int n) {
            int mangoes = 0, pineapples = 0;
            for (char c : s.toCharArray()) {
                if (c == 'M') {
                    mangoes++;
                } else {
                    pineapples++;
                }
            }

            if (mangoes == 0 || pineapples == 0) {
                return -1;
            }

            int prefixMangoes = 0, prefixPineapples = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == 'M') {
                    prefixMangoes++;
                } else {
                    prefixPineapples++;
                }

                int friendMangoes = mangoes - prefixMangoes;
                int friendPineapples = pineapples - prefixPineapples;

                if (prefixMangoes > 0 && friendMangoes > 0 && prefixMangoes != friendMangoes &&
                        prefixPineapples != friendPineapples) {
                    return i + 1;
                }
            }

            return -1;
        }
    }

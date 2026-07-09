class Solution {
    public boolean isPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('b');
        set.add('c');
        set.add('d');
        set.add('e');
        set.add('f');
        set.add('g');
        set.add('h');
        set.add('i');
        set.add('j');
        set.add('k');
        set.add('l');
        set.add('m');
        set.add('n');
        set.add('o');
        set.add('p');
        set.add('q');
        set.add('r');
        set.add('s');
        set.add('t');
        set.add('u');
        set.add('v');
        set.add('w');
        set.add('x');
        set.add('y');
        set.add('z');
        set.add('0');
        set.add('1');
        set.add('2');
        set.add('3');
        set.add('4');
        set.add('5');
        set.add('6');
        set.add('7');
        set.add('8');
        set.add('9');

        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        String st = s.toLowerCase();
        for (int i = 0; i < st.length(); i++) {
            if (set.contains(st.charAt(i))) {
                sb.insert(0, st.charAt(i));
                sb1.append(st.charAt(i));
            }
        }
        return sb.toString().equals(sb1.toString());
    }
}

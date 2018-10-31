import java.util.ArrayList;
import java.util.HashSet;

public class Permutation {
    private final String in; //input
    private static ArrayList<String> a = new ArrayList<String>(); //all the permutations


    Permutation(final String str){
        in = str;
        permute();
    }

    private static void swap(char[] ch, int i, int j)
    {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    // Recursive function to generate all permutations of a String
    // ch will store the permutation in the form of a character array
    private static void permutations(char[] ch, int index)
    {
        if (index == ch.length - 1) { //when all characters are in ch
            a.add(String.valueOf(ch)); //print out permutation
        }

        for (int i = index; i < ch.length; i++) //put all characters in ch
        {
            swap(ch, index, i);
            permutations(ch, index + 1);
            swap(ch, index, i);
        }
    }
    public void permute() {
        // produce the permuted sequence of 'in' and store in 'a', recursively
        permutations(in.toCharArray(),0);
    }

    HashSet<String> aSet = new HashSet<String>();
    public ArrayList<String> getA(){
        for (String permutation: a){
            aSet.add(permutation);
        }
        a = new ArrayList<String>(aSet);
        return a;
    }

    public static void main(String[] args) {
        ArrayList<String> v;

        Permutation p = new Permutation("hat");
        p.permute();
        v = p.getA();
        System.out.println(v);
    }
}
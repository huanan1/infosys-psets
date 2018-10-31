import java.util.ArrayList;
import java.util.*;

public class Octagon implements Comparable<Octagon>{
    private double side;

    public Octagon(double side){
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public int compareTo(Octagon o) {
        //get values of sides of Octagons, compare values and output corresponding Octagons
        if(side == o.side) return 0;
        else if(side>o.side) return 1;
        else return -1;
    }

    public static void main(String[] args){
        ArrayList<Octagon> l = new ArrayList<Octagon>();
        l.add(new Octagon(2));
        l.add(new Octagon(3));
        l.add(new Octagon(1));
        Collections.sort(l);
        for (Octagon o:l)
            System.out.println(o.getSide());
    }
}


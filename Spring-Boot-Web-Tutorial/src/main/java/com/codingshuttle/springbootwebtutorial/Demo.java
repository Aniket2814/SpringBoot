import java.util.*;
class Practice
{
    public static void main(String ar[])
    {
        ArrayList <Number> al=new ArrayList<>();
        al.add(10);
        al.add(20);
        al.add(30);
        al.add(40);
        al.add(50);
        System.out.println(al);


        ArrayList al2=new ArrayList();
        al2.add(100);
        al2.add(200);
        al2.add(300);
        al2.add("ab");
        al.addAll(al2);
// System.out.println(al.remove(2));
        System.out.println(al);
        System.out.println(al2);

    }
}
// interview questiom of java(1-hour)

// hibernate (todo)notetracker 19 8-7

// springboot cousre (2-hour)

// dsa tree graph greedy dynamic (3-4 hour)

// side skills git node js dbms sqlmysql cn operating system  compiler

// aptitude (2-hour)



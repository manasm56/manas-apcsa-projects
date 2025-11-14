package cards;

public class Card {
private int suite;
private int value;
public static String[] val= {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };  
public static String[] suit= { "♦", "♣", "♥", "♠" }; 

public Card(int suite, int value){
this.suite=suite;
this.value=value;
}

public int getValue(){
    return value;
}
public String toString(){
return suit[suite]+val[value];
}

}

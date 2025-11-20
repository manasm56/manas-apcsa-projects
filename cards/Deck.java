package cards;

public class Deck {

    private Card[] card= new Card[52];
    private int top=0;
    public Deck(){
        int index=0;
        for(int i=0; i<4; i++){
            for(int s=0; s<13; s++){
              card[index]= new Card(i,s);
              index++;
            }
        }

    }
    public void shuffle(){
        for(int i=0; i<card.length; i++){
            int r = (int)(Math.random()*52);
            Card temp=card[i];
            card[i]=card[r];
            card[r]=temp;

        }
        top=0;
    }
    public void cut(int num){
        if(num<0){
            num=0;
        }
        if(num>52){
            num=52;
        }

        if(top!=0){
            return;
        }
        Card[] newDeck = new Card[5]; 
        int newIndex=0;
        for(int i=num; i<52; i++){
            newDeck[newIndex]= card[i];
            newIndex++;

        }
        for(int i=0; i<num; i++){
            newDeck[newIndex]= card[i];
            newIndex++;
        }
        card=newDeck;
    }

    public Card draw(){
         if(top>=52){
            return null;
         }
         Card c = card[top];
         top++;
        return c;

    }

    public String Print(int num){
        if(num<0){
            num=0;
        }
        if(num>52){
            num=52;
        }
        String result="";
        for(int i=0; i<num; i++){
            result+=card[i] + " ";
        }
        return result;

    }

}

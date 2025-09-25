import java.util.Objects;

public class Card {
    //data variables
    //suit, name, value, image name
    private String cardSuit;
    private String cardName;
    private int cardValue;
    private String cardImage;

    //constructors, setters and getters, toString, and .equals
    
    //constuctor
    public Card(String suit, String name, int value, String image) {
        this.cardSuit = suit;
        this.cardName = name;
        this.cardValue = value;
        this.cardImage = image;
    }

    //setters
    public void setCardSuit (String suit) {
        this.cardSuit = suit;
    }
    public void setCardName (String name) {
        this.cardName = name;
    }
    public void setCardValue (int value) {
        this.cardValue = value;
    }
    public void setCardImage (String image) {
        this.cardImage = image;
    }

    //getters
    public String getCardSuit () {
        return cardSuit;
    }
    public String getCardName () {
        return cardName;
    }
    public int getCardValue () {
        return cardValue;
    }
    public String getCardImage () {
        return cardImage;
    }

    //Basic toString method with an explicit override.
    //Note: While game functionality is probably better to focus on,
    //I kind of want to improve this with a better print statement.
    //It would likely take a good deal of String manipulation, though.
    //For example, printing "Two of Hearts" would be... not... easy?
    //But it would be a "nicer" print statement. -XQ
    @Override 
    public String toString() {
        return cardSuit + ", " + cardName + ", " + cardValue + "," + cardImage;
    }

    //This equals method specifically compares card names to identify pairs.
    public boolean equals(Card card) {
        //The this card is what comes before the .equals,
        //while card is the method argument.
        return this.cardName.equals(card.cardName);
    }

     /*
        Note by XQ on Sep 23, 3:30 PM:
    After some testing and research on what exactly a two-of-a-kind is,
    this equals method is definitely not working as intended. A pair has the same rank,
    ie two sevens, two kings, etc. – so we would need to check the cardName
    specifically. Comparing the entire object won't work because two of the 
    same exact card object will not exist, as every card in the deck is unique.

    I also repeatedly ran the code to test if this really isn't working,
    and a case of a two of hearts and two of diamonds being pulled showed
    it isn't – the false pair statement was still printed, even though
    two twos makes a pair.
    */

    //Edit by XQ on Sep 25, 7:55 AM: Commenting out the below method to rewrite it
    /*
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card other = (Card) obj;
        return cardValue == other.cardValue &&
               cardSuit.equals(other.cardSuit) &&
                cardName.equals(other.cardName);
        
    }
    */
}
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

    @Override 
    public String toString() {
        return cardSuit + ", " + cardName + ", " + cardValue + "," + cardImage;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card other = (Card) obj;
        return cardValue == other.cardValue &&
               cardSuit.equals(other.cardSuit) &&
                cardName.equals(other.cardName);
        
    }
}
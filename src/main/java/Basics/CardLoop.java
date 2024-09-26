package Basics;

import Lambda.Card;
import Lambda.Rank;
import Lambda.Suit;

import java.util.*;

public class CardLoop {
    static Collection<Suit> suits = List.of(Suit.values());
    static Collection<Suit> suitSet = EnumSet.allOf(Suit.class);
    static List<Rank> ranks = List.of(Rank.values());
    List<Card> deck = new ArrayList<>();

    public void makeADeck() {
   /*     for (Iterator<Suit> i = suits.iterator(); i.hasNext(); ) {
            Suit suit = i.next();
            for (Iterator<Rank> j = ranks.iterator(); j.hasNext(); )
                deck.add(new Card(suit, j.next()));*/

        //Prefer for-each loop
        for (Suit suit : suits)
            for (Rank rank : ranks)
                deck.add(new Card(suit, rank));
        }

      /*  It is a bit tricky to implement Iterable if you have to write your own
        Iterator implementation from scratch, but if you are writing a type that
        represents a group of elements, you should strongly consider having it
        implement Iterable, even if you choose not to have it implement
        Collection. This will allow your users to iterate over your type using the foreach loop,
        and they will be forever grateful.
                In summary, the for-each loop provides compelling advantages over the
        traditional for loop in clarity, flexibility, and bug prevention, with no
        performance penalty. Use for-each loops in preference to for loops wherever
        you can.*/
    }


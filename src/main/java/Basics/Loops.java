package Basics;

import Lambda.Card;
import Lambda.Rank;
import Lambda.Suit;


import java.util.*;

public class Loops {
 /*   Prefer for loop to while loop       */
   /* for (int i = 0, n = expensiveComputation(); i < n; i++) {
            ... // Do something with i;
    }

    for (Iterator<Element> i = c.iterator(); i.hasNext(); ) {
        Element e = i.next();
... // Do something with e and i
    }.
            ..


    Iterator<Element> i = c.iterator();
while (i.hasNext()) {
        doSomething(i.next());
    }.
            ..
    Iterator<Element> i2 = c2.iterator();
while (i.hasNext()) { // BUG!
        doSomethingElse(i2.next());
    }*/

    // Fixed, but ugly - you can do better!
    static List<Suit> suits = List.of(Suit.values());
    static List<Rank> ranks = List.of(Rank.values());
    List<Card> deck = new ArrayList<>();
  /*  for (Iterator<Suit> i = suits.iterator(); i.hasNext(); ) {
        Suit suit = i.next();
        for (Iterator<Rank> j = ranks.iterator(); j.hasNext(); )
            deck.add(new Card(suit, j.next()));
    }*/
// Preferred idiom for nested iteration on collections and arrays


}


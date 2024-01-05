package se.lexicon.interfaces;

import se.lexicon.Product;

public interface Condition {
    boolean test(Product p);
}

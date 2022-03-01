import java.util.Arrays;
public class Autocomplete {
    private final int length;
    private Term[] terms;
    /**
     * Initializes a data structure from the given array of terms.
     * This method throws a NullPointerException if terms is null.
     */
    public Autocomplete(Term[] terms) {
        if (terms == null) {
            throw new NullPointerException();
        }
        this.length = terms.length;
        this.terms = new Term[length];
        System.arraycopy(terms, 0, this.terms, 0, length);
        Arrays.sort(this.terms);
    }
    /**
     * Returns all terms that start with the given prefix, in descending order of weight.
     * This method throws a NullPointerException if prefix is null.
     */
    public Term[] allMatches(String prefix) {
        if (prefix == null) {
            throw new NullPointerException();
        }
        int first = BinarySearch.<Term>firstIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
        int last = BinarySearch.<Term>lastIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
        int quantity = numberofmatches(prefix);
        Term[] temp = new Term[quantity];
        if (first != -1 && last != -1) {
            for (int k = 0; k < quantity; k++) {
                temp[k] = terms[first + k];
            }
        }
        Arrays.sort(temp, Term.byDescendingWeightOrder());
        return temp;
    }
    public int numberofmatches(String prefix) {
        Term searchTerm = new Term(prefix, 0);
        int first = BinarySearch.<Term>firstIndexOf(terms, searchTerm,Term.byPrefixOrder(prefix.length()));
        int last = BinarySearch.<Term>lastIndexOf(terms, searchTerm,Term.byPrefixOrder(prefix.length()));
        return last - first + 1;
    }
}
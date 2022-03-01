import java.util.Comparator;
public class Term implements Comparable<Term> {
public String queryIn;
public long weightIn;
    /**
     * Initialize a term with the given query and weight.
     * This method throws a NullPointerException if query is null,
     * and an IllegalArgumentException if weight is negative.
     */
    public Term(String query, long weight) {
        if (query == null) throw new NullPointerException();
        if (weight < 0) throw new IllegalArgumentException();
        queryIn = query;
        weightIn = weight;
    }

    /**
     * Compares the two terms in descending order of weight.
     */
    public static Comparator<Term> byDescendingWeightOrder() {
        return new descendingWeightOrder();
    }
    public static class descendingWeightOrder implements Comparator<Term> {
        @Override
        public int compare(Term t1, Term t2) {
            if (t1.weightIn < t2.weightIn) {
                return 1;
            }
            else if (t1.weightIn > t2.weightIn) {
              return -1;
            }
            else {
                return 0;
            }
        }
    }

    /**
     * Compares the two terms in ascending lexicographic order of query,
     * but using only the first length characters of query. This method
     * throws an IllegalArgumentException if length is less than or equal
     * to zero.
     */
    public static Comparator<Term> byPrefixOrder(int length) {
        if (length <= 0) throw new IllegalArgumentException();
        return new prefixOrder(length);
    }
    public static class prefixOrder implements Comparator<Term> {
        private int length;

        public prefixOrder(int length) {
            this.length = length;
        }

        @Override
        public int compare(Term t1, Term t2) {
            int r1 = t1.queryIn.length() < length ? t1.queryIn.length() : length;
            int r2 = t2.queryIn.length() < length ? t2.queryIn.length() : length;
            return t1.queryIn.substring(0, r1).compareTo(t2.queryIn.substring(0, r2));
        }
    }

    /**
     * Compares this term with the other term in ascending lexicographic order
     * of query.
     */
    @Override
    public int compareTo(Term other) {
        int cmp = this.queryIn.compareTo(other.queryIn);
        return cmp;
    }

    /**
     * Returns a string representation of this term in the following format:
     * query followed by a tab followed by weight
     */
    @Override
    public String toString(){
        String t = this.queryIn + "\t" + this.weightIn;
        return t;
    }

}
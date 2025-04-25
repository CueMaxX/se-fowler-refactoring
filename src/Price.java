// Price.java
abstract class Price {
    /** Legacy hook—the Movie still exposes its price code. */
    abstract int getPriceCode();

    /** New API: compute the rental charge for this price. */
    abstract double getCharge(int daysRented);

    /** New API: compute frequent‐renter points for this price. */
    abstract int getFrequentRenterPoints(int daysRented);
}

class RegularPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2) {
            result += (daysRented - 2) * 1.5;
        }
        return result;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        return 1; // no bonus
    }
}

class NewReleasePrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        // bonus point for a two-day (or longer) new-release rental
        return (daysRented > 1) ? 2 : 1;
    }
}

class ChildrensPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }

    @Override
    double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        return 1;  // children’s rentals never get bonus points
    }
}

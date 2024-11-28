public abstract class Price {
    public abstract int getPriceCode();

    // Extracted and moved method: calculates charge based on days rented
    public abstract double getCharge(int daysRented);

    // Generic method for frequent renter points
    public int getFrequentRenterPoints(int daysRented) {
        return 1; // Default frequent renter points
    }
}
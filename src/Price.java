public abstract class Price {
    public abstract int getPriceCode();

// Extracted and moved method: calculates charge based on days rented
public abstract double getCharge(int daysRented);
}
public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int _priceCode;

    public Movie(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int arg) {
        _priceCode = arg;
    }

    public String getTitle() {
        return _title;
    }

    // Extracted and moved method: calculates charge based on days rented
    public double getCharge(int daysRented) {
        double thisAmount = 0;
        switch (_priceCode) {
            case REGULAR:
                thisAmount += 2;
                if (daysRented > 2)
                    thisAmount += (daysRented - 2) * 1.5;
                break;
            case NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;
            case CHILDRENS:
                thisAmount += 1.5;
                if (daysRented > 3)
                    thisAmount += (daysRented - 3) * 1.5;
                break;
        }
        return thisAmount;
    }
    // Extracted and moved method: calculates frequent renter points based on movie type and rental duration
    public int getFrequentRenterPoints(int daysRented) {
        // Check if the movie is a new release and rented for more than 1 day
        if (_priceCode == NEW_RELEASE && daysRented > 1) {
            return 2; // Bonus points for new releases rented for more than 1 day
        }
        return 1; // Regular points
    }
}
public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private Price _price;  // Use Price strategy to handle pricing

    public Movie(String title, int priceCode) {
        _title = title;
        setPriceCode(priceCode);  // Set price strategy based on price code
    }

    public String getTitle() {
        return _title;
    }

    // Get price code from the Price strategy object
    public int getPriceCode() {
        return _price.getPriceCode();
    }

    // Set the price strategy based on the price code
    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDRENS:
                _price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }
    // Delegate charge calculation to Price strategy
    public double getCharge(int daysRented) {
        return _price.getCharge(daysRented);  // Now delegates to the Price class
    }

    // Calculate the frequent renter points based on price strategy
    public int getFrequentRenterPoints(int daysRented) {
        // Check if the movie is a new release and rented for more than 1 day
        if (getPriceCode() == NEW_RELEASE && daysRented > 1) {
            return 2; // Bonus points for new releases rented for more than 1 day
        }
        return 1; // Regular points
    }
}
public class Rental {
    private Movie _movie;
    private int _daysRented;
    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }
    public int getDaysRented() {
        return _daysRented;
    }
    public Movie getMovie() {
        return _movie;
    }
    public double getCharge() {
        // Now delegate the charge calculation to Movie class
        return _movie.getCharge(_daysRented);
    }
    // Extracted and moved method
    public int getFrequentRenterPoints() {
        // Check if the movie is a new release and rented for more than 1 day
        if (_movie.getPriceCode() == Movie.NEW_RELEASE && _daysRented > 1) {
            return 2; // Bonus points
        }
        return 1; // Regular points
    }
}
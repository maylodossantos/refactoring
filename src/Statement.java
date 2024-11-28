import java.util.Enumeration;

public abstract class Statement {

    public String value(Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        String result = headerString(aCustomer);
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            // show figures for each rental
            result += rentalString(each);
        }
        // add footer lines
        result += footerString(aCustomer);
        return result;
    }

    protected abstract String headerString(Customer aCustomer);
    protected abstract String rentalString(Rental aRental);
    protected abstract String footerString(Customer aCustomer);

}
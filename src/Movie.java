public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    public Movie(String newtitle, int newpriceCode) {
        this.title = newtitle;
        setPriceCode(newpriceCode);
    }
    public void setPriceCode(int arg) { 
        switch (arg) {
            case REGULAR:
                _price = new RegularPrice(); break;
            case CHILDRENS:
                _price = new ChildrensPrice(); break;
            case NEW_RELEASE:
                _price = new NewReleasePrice(); break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        } 
    }
    private Price _price;
        public String getTitle (){
            return title;
        };

    /** Delegate charge and points to the Price strategy */
    public double getCharge(int daysRented) {
        return _price.getCharge(daysRented);
    }
    public int getFrequentRenterPoints(int daysRented) {
        return _price.getFrequentRenterPoints(daysRented);
    }
}
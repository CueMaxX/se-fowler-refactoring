public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private int priceCode;
    public Movie(String newtitle, int newpriceCode) {
        title = newtitle;
        setPriceCode(priceCode);
    }
    public int getPriceCode() {
        return _price.getPriceCode(); 
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
}
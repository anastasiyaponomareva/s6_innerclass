/**
 * Created by mac on 16.10.14.
 */
public class Popsi extends Drink {
    @Override
    public String getIngredients() {
        return "Sugar, caffeine";
    }
    public Popsi() {

        super(10, "Great carbonated soda");
    }
    @Override
    public String toString() {
        return super.toString()+ " "+getIngredients();
    }
    @Override
    public void finalize() throws Throwable {
        super.finalize();
        System.out.println("This object was finalized!");
    }
}

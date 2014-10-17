/**
 * Created by mac on 16.10.14.
 */
public abstract class Drink {
    private int serialNo;
    private String description;
    private  int sugarContent;
    public Drink (int serialNo, String description)
    {
        this.description=description;
        this.serialNo=serialNo;
        sugarContent=0;

    }

    public int getSerialNo() {
        return serialNo;
    }

    public int getSugarContent() {
        return sugarContent;
    }

    public String getDescription() {
        return description;
    }
    public void ToString() {
        System.out.println(serialNo + description + sugarContent);
    }
    public void increaseSugarContent(int numb) {
       sugarContent+=numb;
    }
    public abstract String getIngredients();

}


/**
 * Enumeration class Items - write a description of the enum class here
 *
 * @author Abu & Zammar 
 * @version 0.1
 */
public enum Items
{
   NONE("none"), PHONE("phone"), CAR("car") , GUN("gun") , KEYS("keys") , 
        BORIS("boris");
    
    private String item;
    
      Items(String item)
    {
        this.item = item;
    }
    
    public String toString()
    {
        return item;
    }
}

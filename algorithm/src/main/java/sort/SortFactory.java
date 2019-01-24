package sort;

/**
 * Created by irskj on 2019/1/21.
 */
public class SortFactory {
    public static Sort create(Class<? extends Sort> cls){
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}

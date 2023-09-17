import java.util.function.Function;


public class RetryableFunction implements Function<String,String>{

    @Override
    public String apply(String t) {
        System.out.println(t);
        throw new RuntimeException("OOPS");
        //return t;
    }
    
}

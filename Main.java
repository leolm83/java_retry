import java.util.function.Function;

class Main {

    public static void main(String[] args) {
        retry((item) -> {
            //throw new RuntimeException("Oops, deu erro!");
             return item;
        }, "hello");

       // retry(new RetryableFunction(), "Hello from a Functional Interface");
    }

    public static void retry(Function<String, ?> function, String param) {
        int tentativa = 0;
        boolean concluido = false;
        while (!concluido && tentativa <= 3){
            try {
                function.apply(param);
                concluido = true;
            } catch (Exception e) {
                System.out.println("Deu erro!!!");

                //se for uma lambda irá printar um nome "estranho" aqui
                System.out.println("Tentativa "+tentativa+" FALHOU!!!"+function.getClass().getSimpleName());
            } finally {
                tentativa++;
            }
        }
    }

}
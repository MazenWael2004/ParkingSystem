
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Parser p=new Parser("input.txt");
        List<carThread>cars =p.readDateAndStoretoCarThread();
    }
    
}

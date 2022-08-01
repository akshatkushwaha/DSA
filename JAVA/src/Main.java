import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LinkedList head = new LinkedList();

        for(int i = 6; i < 10; ++i)
            head.push_back(i);
        for(int i = 4; i > 0; --i)
            head.push_front(i);

        head.push_index(5, 4);

        head.print();
    }
}

package cs244.groupproject1;
import java.util.Random;

// Jake 4/29/23
public class PerformanceMetrics {
    private BSTTree bst = new BSTTree();
    private AVLTree avl = new AVLTree();
    private long startTime;

    public void startTime() {
        startTime = System.nanoTime();
    }

    public float endTime() {
        long endTime = System.nanoTime();
        return (float) (endTime - startTime) / 1000000;
    }

    public float bstInsertTime() {
        PerformanceMetrics timer = new PerformanceMetrics();
        bst = BSTTree.generateTestTree();
        Random random = new Random();
        int test = random.nextInt(50);
        timer.startTime();
        bst.insert(test);
        return timer.endTime();
    }

    public float bstSearchTime() {
        PerformanceMetrics timer = new PerformanceMetrics();
        bst = BSTTree.generateTestTree();
        Random random = new Random();
        int test = random.nextInt(50);
        timer.startTime();
        bst.search(test);
        return timer.endTime();
    }

    public float avlInsertTime() {
        PerformanceMetrics timer = new PerformanceMetrics();
        avl = AVLTree.generateTestTree();
        Random random = new Random();
        int test = random.nextInt(50);
        timer.startTime();
        avl.insert(test);
        return timer.endTime();
    }

    public float avlSearchTime() {
        PerformanceMetrics timer = new PerformanceMetrics();
        avl = AVLTree.generateTestTree();
        Random random = new Random();
        int test = random.nextInt(50);
        timer.startTime();
        avl.search(test);
        return timer.endTime();
    }



    public static void main(String[] args) {
        PerformanceMetrics pm = new PerformanceMetrics();
        System.out.println(pm.bstInsertTime());
        System.out.println(pm.avlInsertTime());
        System.out.println(pm.bstSearchTime());
        System.out.println(pm.avlSearchTime());
    }
}
class Define {
   public synchronized String print(String string) {
        for (int i = 0; i < string.length(); i++) {
            System.out.print(string.charAt(i));
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        return string;
    }
    public synchronized String print1(String string) {
        System.out.print(string);
        for (int i = 0; i < string.length(); i++) {
            try {
                Thread.sleep(10);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        return string;
    }
}

class Reader1 extends Thread {
    private final char[] chars;

    public Reader1(char[] chars) {
        this.chars = chars;
    }

    @Override
    public void run() {
        Define define = new Define();
        define.print("WELCOME TO CSTAD!\n");
        define.print("*".repeat(25)+"\n");
        define.print("Don't give up this opportunity, do your best first.\n");
        define.print("-".repeat(25)+"\n");
        define.print1("Downloading");
        define.print(".........");
        define.print1("completed 100%.");
    }
}

public class File1 {
    public static void main(String[] arg) throws InterruptedException {
        Reader1 reader1 = new Reader1(new char[0]);
        reader1.start();
        reader1.join();
    }
}
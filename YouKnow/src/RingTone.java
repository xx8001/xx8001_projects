import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RingTone extends JFrame {

    public RingTone() {
        setTitle("I Wanna Eat Dinner");
        setSize(1300, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        // four Buttons
        JButton button1 = new JButton("Non-Recursive Algorithm");
        JButton button2 = new JButton("Recursive Algorithm");
        JButton button3 = new JButton("Quick Algorithm");
        JButton button4 = new JButton("Matrix Multiplication Algorithm");

        // Button Actions
        button1.addActionListener(actionEvent -> {
            int n = Integer.parseInt(JOptionPane.showInputDialog("Enter a number:"));
            // Non-recursive algorithm
            Loading(()->{
                long startTime = System.currentTimeMillis();
//                JOptionPane.showMessageDialog(null, "Launching Non-Recursive Algorithm");
                long result = noo.f_02(n);
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;
                showLargeMessage("Result: " + result + "\n Time spent: " + elapsedTime + " ms");
            });
        });

        button2.addActionListener(actionEvent -> {
            // Recursive algorithm
            int n = Integer.parseInt(JOptionPane.showInputDialog("Enter a number:"));
            Loading(()->{
                long startTime = System.currentTimeMillis();

                long result = noo.f_01(n);
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;
                showLargeMessage("Result: " + result + "\n Time spent: " + elapsedTime + " ms");

                //max fib
                showLargeMessage("Find Max Fibonacci in 30s....\n");
                long[] nn = shhh_1();
                showLargeMessage("Max fib in 30s is at: " + (nn[0] - 1) + " , value is " + nn[1]);


            });


        });

        button3.addActionListener(actionEvent -> {
            // Quick algorithm (dynamic programming)
            int n = Integer.parseInt(JOptionPane.showInputDialog("Enter a number:"));
            Loading(()->{
                long startTime = System.currentTimeMillis();
                long result = noo.f_04(n);
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;
                showLargeMessage("Result: " + result + "\n Time spent: " + elapsedTime + " ms");

                showLargeMessage("calculate the place of Errors occur...\n" );
                int nn = findMinErrorN();
                showLargeMessage("Errors occur at : " + nn);
            });
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Matrix multiplication algorithm
                int n = Integer.parseInt(JOptionPane.showInputDialog("Enter a number:"));
                Loading(()->{
                    long startTime = System.currentTimeMillis();
                    long result = noo.f_03(n);
                    long endTime = System.currentTimeMillis();
                    long elapsedTime = endTime - startTime;
                    showLargeMessage("Result: " + result + "\n Time spent: " + elapsedTime + " ms");
                });
            }
        });


        add(button1);
        add(button2);
        add(button3);
        add(button4);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RingTone().setVisible(true);
            }
        });
    }

    // Method to show a larger message dialog
    public void showLargeMessage(String message) {
        JLabel label = new JLabel(message);
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        JOptionPane.showMessageDialog(null, label, "Result", JOptionPane.INFORMATION_MESSAGE);
    }

    // Show loading dialog
    public void Loading(Runnable task) {
        JDialog loadingDialog = new JDialog();
        loadingDialog.setTitle("Loading...");
        loadingDialog.setSize(300, 100);
        loadingDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        loadingDialog.setLocationRelativeTo(null);
        loadingDialog.add(new JLabel("Calculating, please wait..."), BorderLayout.CENTER);
        loadingDialog.setModal(true);

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                task.run();
                return null;
            }

            @Override
            protected void done() {
                loadingDialog.dispose();
            }
        };

        worker.execute();
        loadingDialog.setVisible(true);

    }

    public long[] shhh_1() {
        int n = 1;
        long timelimit = 30000;  //30s
        long starttime = System.currentTimeMillis();
        long f = 0;

        while (true) {
            if (System.currentTimeMillis() - starttime > timelimit) {
//                System.out.println("Max fib in 30s is : Fibonacci(" + (n - 1) + ")");
                return new long[]{n - 1, f};
            }

            f = noo.f_01(n);  // 调用斐波那契数计算函数
            n++;
        }
    }

    public static double phi = (1 + Math.sqrt(5)) / 2;

    public static long ff_04(int n) {
        return Math.round(Math.pow(phi, n) / Math.sqrt(5));
    }

    public static int findMinErrorN() {
        int n = 1;
        while (true) {
            long formulaFibonacci = ff_04(n);//quick ssss
            long iterativeFibonacci = noo.f_04(n);
            if (Math.abs(formulaFibonacci - iterativeFibonacci) > 0) {
//                System.out.println("出现误差时的最小 n 值为：" + n);
                return n;
            }
            n++;
        }
    }








}

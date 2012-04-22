import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * User: Ty
 * Date: 4/22/12
 * Time: 12:45 AM
 */
public class MainFrame extends JFrame {
    private JTextArea codeBox     = new JTextArea();
    private JTextArea compiledBox = new JTextArea();

    public MainFrame(){
        this.setMinimumSize(new Dimension(500,500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        this.setVisible(true);
        this.setupComponents();
    }

    private void setupComponents(){
        Container cp = this.getContentPane();

        this.codeBox.setText("code");
        this.compiledBox.setText("compiled");

        this.codeBox.setTabSize(1);
        this.compiledBox.setTabSize(1);

        this.compiledBox.setEditable(false);

        cp.add(codeBox);
        System.out.println(cp.getWidth());
        this.codeBox.setSize(cp.getWidth()/2,cp.getHeight());
        this.codeBox.setLocation(0,0);

        cp.add(compiledBox);
        this.compiledBox.setSize(cp.getWidth()/2,cp.getHeight());
        this.compiledBox.setLocation(cp.getWidth()/2,0);


        this.codeBox.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                char pressed = e.getKeyChar();
                if(pressed ==';' || pressed=='}'){
                    Wrapper.clean();
                    compiledBox.setText(Wrapper.compile(codeBox.getText()));
                }
            }
        });
    }


    public static void main(String... args){
        new MainFrame().setVisible(true);
    }
}

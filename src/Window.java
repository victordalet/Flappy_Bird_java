import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Window {

    /*--------------------------WINDOW SETTINGS------------------------------*/
    public JFrame window = new JFrame();;

    public Window() {
        this.window.setSize(400,400);
        this.window.setLayout(null);
        this.window.setVisible(true);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*--------------------------GETTER------------------------------*/

    public JFrame get_window() {
        return this.window;
    }

    /*--------------------------MAKE BUTTON------------------------------*/
    public JButton add_button(String text, int x, int y) {
        JButton btn = new JButton(text);
        btn.setBounds(x,y,100,40);
        this.window.add(btn);
        return btn;
    }


    /*--------------------------MAKE LABEL------------------------------*/
    public JLabel add_text(String text, int x, int y) {
        JLabel name = new JLabel(text);
        name.setBounds(x,y,100,20);
        this.window.add(name);
        return name;
    }

    /*--------------------------DISPLAY PICTURE------------------------------*/
    public JPanel draw_picture(String path, int x, int y, int w, int h) throws IOException {
        JPanel panel = new JPanel();
        panel.setBounds(x, y, w, h);
        BufferedImage img = ImageIO.read(new File(path));
        JLabel pic = new JLabel(new ImageIcon(img));
        panel.add(pic);
        this.window.add(panel);
        return panel;
    }



}

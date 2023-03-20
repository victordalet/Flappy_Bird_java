import javax.swing.*;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        Player victor = new Player("victor",3);
        System.out.println("Welcome "+victor.get_name());


        /*--------------------------WINDOW SETTINGS------------------------------*/
        Window window  = new Window();
        JButton start_btn = window.add_button("start",150,150);
        JLabel score = window.add_text("Score : "+victor.get_point(),10,10);
        JPanel player_rect = window.draw_picture("src/player.png",victor.get_x(),victor.get_y(),50,50);

        /*--------------------------WHILE RUN------------------------------*/
        Timer timer = new Timer(100, new Game(victor,score,start_btn,player_rect));
        timer.start();

        window.get_window().addKeyListener(new Keyboard(victor,player_rect));

    }
}



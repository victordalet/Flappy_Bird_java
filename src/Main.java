import javax.swing.*;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        /*--------------------------OBJECT------------------------------*/

        Player player = new Player("victor",5);
        System.out.println("Welcome "+player.get_name());
        Obstacle tube = new Obstacle(3,200,300);
        Obstacle tube2 = new Obstacle(3,0,500);

        /*--------------------------WINDOW SETTINGS------------------------------*/
        Window window  = new Window();
        JButton start_btn = window.add_button("start",150,150);
        JLabel score = window.add_text("Score : "+player.get_point(),10,10);
        JPanel player_rect = window.draw_picture("src/player.png",player.get_x(),player.get_y(),50,50);
        JPanel tube_rect = window.draw_picture("src/tube.png",tube.get_x(),tube.get_y()+tube.get_y_pos(),30,170);
        JPanel tube_rect2 = window.draw_picture("src/tube2.png",tube2.get_x(),tube2.get_y()+tube2.get_y_pos(),30,170);

        /*--------------------------WHILE RUN------------------------------*/
        Timer timer = new Timer(50, new Game(player,score,start_btn,player_rect,tube,tube_rect,tube2,tube_rect2));
        timer.start();

        window.get_window().addKeyListener(new Keyboard(player,player_rect));

    }
}


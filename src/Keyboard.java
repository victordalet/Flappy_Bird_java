import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Keyboard implements KeyListener {

    public Player player;

    public JPanel player_rect;

    public Keyboard(Player player, JPanel player_rect) {
        this.player = player;
        this.player_rect = player_rect;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.player.set_coordinate(this.player.get_x(),this.player.get_y() - (this.player.get_speed() *this.player.get_jump()));
            this.player_rect.setBounds(this.player.get_x(),this.player.get_y(),this.player.get_w(),this.player.get_h());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
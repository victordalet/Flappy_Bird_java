import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game implements ActionListener {

    /*--------------------------INIT------------------------------*/
    public Player player;
    public JLabel score;

    public JButton start_btn;

    public JPanel player_rect;

    public boolean run = false;

    /*--------------------------CONSTRUCTOR------------------------------*/
    public Game(Player player, JLabel score,JButton start_btn,JPanel player_rect) {
        this.player = player;
        this.score = score;
        this.start_btn = start_btn;
        this.player_rect = player_rect;

        this.start_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start_btn.setVisible(false);
                run = true;
            }
        });

    }

    /*--------------------------GAME------------------------------*/

    @Override
    public void actionPerformed(ActionEvent e ) {
        if (this.run){
            this.player.set_point(this.player.get_point() + 1);
            this.score.setText("score : " + this.player.get_point());
            if (this.player.get_y() < 300) {
                this.player.set_coordinate(this.player.get_x(), this.player.get_y() + this.player.get_speed());
                this.player_rect.setBounds(this.player.get_x(), this.player.get_y(), this.player.get_w(), this.player.get_h());
            }
            else {
                this.player.display_history_score();
                this.player.add_score(this.player.get_point());
                this.player.set_point(0);
                this.run = false;
                this.start_btn.setVisible(true);
                this.player.set_coordinate(50,50);
            }
        }
    }



}



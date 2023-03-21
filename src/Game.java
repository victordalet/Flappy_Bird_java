import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game implements ActionListener {

    /*--------------------------INIT------------------------------*/
    public Player player;
    public JLabel score;

    public JButton start_btn;

    public JPanel player_rect;

    public Obstacle tube;

    public JPanel tube_rect;

    public Obstacle tube2;

    public JPanel tube_rect2;

    public boolean run = false;


    /*--------------------------CONSTRUCTOR------------------------------*/
    public Game(Player player, JLabel score,JButton start_btn,JPanel player_rect,Obstacle tube,JPanel tube_rect,Obstacle tube2,JPanel tube_rect2) {
        this.player = player;
        this.score = score;
        this.start_btn = start_btn;
        this.player_rect = player_rect;
        this.tube = tube;
        this.tube_rect = tube_rect;
        this.tube2 = tube2;
        this.tube_rect2 = tube_rect2;

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
                /*--------------------------MOVEMENT------------------------------*/
                this.player.set_coordinate(this.player.get_x(), this.player.get_y() + this.player.get_speed());
                this.player_rect.setBounds(this.player.get_x(), this.player.get_y(), this.player.get_w(), this.player.get_h());
                this.tube.run();
                this.tube2.run();
                this.tube_rect.setBounds(this.tube.get_x(),this.tube.get_y()+this.tube.get_y_pos(),30,170);
                this.tube_rect2.setBounds(this.tube2.get_x(),this.tube2.get_y()+this.tube2.get_y_pos(),30,170);
                /*--------------------------DEAD------------------------------*/
                if ( (this.player.get_y() >= this.tube.get_y()+this.tube.get_y_pos()-50 && this.player.get_y() <= this.tube.get_y()+this.tube.get_y_pos()-50 +170 ) && (this.player.get_x() >= this.tube.get_x()-30 && this.player.get_x() <= this.tube.get_x() )  ) {
                    this.player.set_coordinate(this.player.get_x(),300);
                    this.player_rect.setBounds(this.player.get_x(), this.player.get_y(), this.player.get_w(), this.player.get_h());
                }
                if ( (this.player.get_y() >= this.tube2.get_y()+this.tube2.get_y_pos()-50 && this.player.get_y() <= this.tube2.get_y()+this.tube2.get_y_pos()-50 +170 ) && (this.player.get_x() >= this.tube2.get_x()-30 && this.player.get_x() <= this.tube2.get_x() )  ) {
                    this.player.set_coordinate(this.player.get_x(),300);
                    this.player_rect.setBounds(this.player.get_x(), this.player.get_y(), this.player.get_w(), this.player.get_h());
                }
            }
            else {
                /*--------------------------RESET GAME------------------------------*/
                this.player.display_history_score();
                this.player.add_score(this.player.get_point());
                this.player.set_point(0);
                this.run = false;
                this.start_btn.setVisible(true);
                this.player.set_coordinate(50,50);
                this.tube.set_speed(this.tube.get_SPEED());
                this.tube2.set_speed(this.tube2.get_SPEED());
                this.tube.set_x(this.tube.get_x_pos());
                this.tube2.set_x(this.tube2.get_x_pos());
                this.tube_rect.setBounds(this.tube.get_x(),this.tube.get_y()+this.tube.get_y_pos(),30,170);
                this.tube_rect2.setBounds(this.tube2.get_x(),this.tube2.get_y()+this.tube2.get_y_pos(),30,170);
            }
        }
    }

}



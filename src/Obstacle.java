public class Obstacle {

    /*--------------------------INIT------------------------------*/
    private int x;
    private int y;
    private int SPEED = 5;
    private int hard;
    private int speed = this.SPEED;

    private int y_pos;


    /*--------------------------CONSTRUCTOR------------------------------*/
    public Obstacle(int hard,int y_pos) {
        this.x  = 300;
        this.y = (int)(Math.random()*(100 +1));
        this.hard = hard;
        this.y_pos = y_pos;
    }

    /*--------------------------GETTER------------------------------*/

    public int get_x() {
        return this.x;
    }

    public int get_y() {
        return this.y;
    }

    public int get_hard() {
        return this.hard;
    }

    public int get_SPEED() {
        return this.SPEED;
    }

    public int get_y_pos() {
        return this.y_pos;
    }

    /*--------------------------SETTERS------------------------------*/

    public void set_speed(int new_speed) {
        this.speed = new_speed;
    }

    public void set_x(int new_x) {
        this.x = new_x;
    }

    /*--------------------------RUN------------------------------*/

    public void run() {
        this.x -= speed;
        if (this.x <= 0) {
            this.x = 350;
            this.y = (int)(Math.random()*(100 +1));
            this.speed += this.hard;
        }
    }

}

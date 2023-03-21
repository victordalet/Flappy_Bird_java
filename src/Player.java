import java.util.ArrayList;

public class Player{

    /*--------------------------INIT------------------------------*/
    private final String name;
    private int x = 50;
    private int y = 50;
    private int speed = 10;

    private int point = 0;

    private int w = 50;

    private int h = 50;
    ArrayList<Integer> score = new ArrayList<>();


    /*--------------------------CONSTRUCTOR------------------------------*/
    public Player(String name) {
        this.name = name;
    }


    /*--------------------------GETTER------------------------------*/
    public String get_name() {
        return this.name;
    }


    public int get_x() {
        return this.x;
    }

    public int get_y() {
        return this.y;
    }

    public int get_point() {
        return this.point;
    }

    public int get_w() {
        return this.w;
    }

    public int get_h() {
        return this.h;
    }

    public int get_speed() {
        return speed;
    }

    /*--------------------------SETTER------------------------------*/
    public void set_coordinate(int new_x, int new_y) {
        this.x = new_x;
        this.y = new_y;
    }

    public void set_point(int new_point) {
        this.point = new_point;
    }

    /*--------------------------STATE------------------------------*/

    public void add_score(int score) {
        this.score.add(score);
    }

    public ArrayList<Integer> get_score() {
        return this.score;
    }

    public void display_history_score() {
        System.out.println("------------------------------------");
        for (int i = 0 ; i < this.score.size() ; i++) {
            System.out.println("Game "+(i+1)+" : "+ this.score.get(i) +"points");
        }
    }


}

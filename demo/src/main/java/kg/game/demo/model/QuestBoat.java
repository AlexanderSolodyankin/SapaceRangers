package kg.game.demo.model;

import javax.persistence.Entity;
import java.util.List;

public class QuestBoat {
    private List<String> right1;
    private List<String> right2;
    private List<String> left;
    private List<String> checkList;
    private int time;
    private String check;
    private String action;
    private String discript;

    public static QuestBoat run(
            List<String> right1,
            List<String> right2,
            List<String> left,
            List<String> checkList,
            int time,
            String check,
            String action,
            String discript) {
        QuestBoat questBoat = new QuestBoat();
        questBoat.right1 = right1;
        questBoat.right2 = right2;
        questBoat.left = left;
        questBoat.checkList = checkList;
        questBoat.time = time;
        questBoat.check = check;
        questBoat.action = action;
        questBoat.discript = discript;
        return questBoat;
    }

    public List<String> getRight1() {
        return right1;
    }

    public void setRight1(List<String> right1) {
        this.right1 = right1;
    }

    public List<String> getRight2() {
        return right2;
    }

    public void setRight2(List<String> right2) {
        this.right2 = right2;
    }

    public List<String> getLeft() {
        return left;
    }

    public void setLeft(List<String> left) {
        this.left = left;
    }

    public List<String> getCheckList() {
        return checkList;
    }

    public void setCheckList(List<String> checkList) {
        this.checkList = checkList;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDiscript() {
        return discript;
    }

    public void setDiscript(String discript) {
        this.discript = discript;
    }

    @Override
    public String toString() {
        return "QuestBoat{" +
                "right1=" + right1 +
                ", right2=" + right2 +
                ", left=" + left +
                ", checkList=" + checkList +
                ", time=" + time +
                ", check='" + check + '\'' +
                ", action='" + action + '\'' +
                ", discript='" + discript + '\'' +
                '}';
    }
}

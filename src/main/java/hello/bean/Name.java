package hello.bean;

public class Name {
    private String first;
    private String last;
    private int born;


    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public int getBorn() {
        return born;
    }

    public void setBorn(int born) {
        this.born = born;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Name(String first, String last, int born) {
        this.first = first;
        this.last = last;
        this.born = born;
    }

    public Name() {
    }
}

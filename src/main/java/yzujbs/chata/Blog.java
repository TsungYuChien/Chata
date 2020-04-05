package yzujbs.chata;

public class Blog {

    private String title,local,talent,tolearn;

    public Blog(){

    }

    public Blog(String title, String local, String talent, String tolearn) {
        this.title = title;
        this.local = local;
        this.talent = talent;
        this.tolearn = tolearn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTalent() {
        return talent;
    }

    public void setTalent(String talent) {
        this.talent = talent;
    }

    public String getTolearn() {
        return tolearn;
    }

    public void setTolearn(String tolearn) {
        this.tolearn = tolearn;
    }
}

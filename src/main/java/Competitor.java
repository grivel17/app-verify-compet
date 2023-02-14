public class Competitor {
    private String name;
    private String surName;
    private int age;
    private String club;
    private String category;

    public Competitor(String name, String surName, int age, String club, String category) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.club = club;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Competitor{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", club='" + club + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

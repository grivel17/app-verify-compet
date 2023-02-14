public record CompetitorRecord(String name, String surName, int age, String club, String category) {
    @Override
    public String toString() {
        return "CompetitorRecord{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", club='" + club + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

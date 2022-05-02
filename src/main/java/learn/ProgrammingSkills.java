package learn;

import java.util.Objects;

public class ProgrammingSkills {

    private String language;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgrammingSkills that = (ProgrammingSkills) o;
        return Objects.equals(language, that.language) && Objects.equals(expertise, that.expertise) && Objects.equals(interest, that.interest) && Objects.equals(comments, that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(language, expertise, interest, comments);
    }

    private String expertise;
    private String interest;

    public ProgrammingSkills(String language, String expertise, String interest, String comments) {
        this.language = language;
        this.expertise = expertise;
        this.interest = interest;
        this.comments = comments;
    }

    private String comments;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}

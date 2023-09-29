package br.edu.ifsp.dsw3.nutriplate.model.domain;

public enum Occupation {
    ADMIN("employee", "Administrator"),
    NUTRITIONIST("employee", "Nutritionist"),
    ASSISTANT("employee", "Assistant"),
    AVI("student", "AVI"),
    TII("student", "TII");

    private String position;
    private String role;

    Occupation(String position, String role) {
        this.position = position;
        this.role = role;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

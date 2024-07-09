package org.example.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Motivation {
    private int id;
    private String regDate;
    private String content;
    private String author;

    @Override
    public String toString() {
        return "Motivation{" +
                "id=" + id +
                ", regDate='" + regDate + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

package de.ait;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString


public class CommentDto {



    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;
}

package cat.tcm.skadoosh.userservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private long userId;
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private String content;
}

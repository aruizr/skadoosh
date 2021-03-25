package cat.tcm.skadoosh.postservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Getter
    @Setter
    @Column
    private long userId;
    @Getter
    @Setter
    @Column
    private String title;
    @Getter
    @Setter
    @Column
    private String content;
}

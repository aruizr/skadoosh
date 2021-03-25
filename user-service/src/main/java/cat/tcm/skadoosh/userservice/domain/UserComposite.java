package cat.tcm.skadoosh.userservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class UserComposite {
    @Getter
    @Setter
    private User user;
    @Getter
    @Setter
    private List<Post> posts;
}

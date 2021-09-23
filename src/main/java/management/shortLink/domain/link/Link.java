package management.shortLink.domain.link;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import management.shortLink.domain.base.BaseTimeEntity;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Link extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 5, nullable = false)
    private String shortId;

    @Column(length = 500, nullable = false)
    private String url;

    @Column(length = 500)
    private String aliasName;

    @Builder
    public Link(String url, String shortId, String aliasName) {
        this.url = url;
        this.shortId = shortId;
        this.aliasName = aliasName;
    }

    public void update(String aliasName){
        this.aliasName = aliasName;
    }

}

package management.shortLink.dto.link;

import lombok.Getter;
import management.shortLink.domain.link.Link;

import java.time.LocalDateTime;

@Getter
public class LinkListResponseDto {

    private String shortId;
    private String url;
    private LocalDateTime createdAt;

    public LinkListResponseDto(Link entity){
        this.shortId = entity.getShortId();
        this.url = entity.getUrl();
        this.createdAt = entity.getCreatedAt();
    }
}

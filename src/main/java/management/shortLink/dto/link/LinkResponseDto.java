package management.shortLink.dto.link;

import lombok.Getter;
import management.shortLink.domain.link.Link;

import java.time.LocalDateTime;

@Getter
public class LinkResponseDto {

    private String shortId;
    private String url;
    private String aliasName;
    private LocalDateTime createdAt;

    public LinkResponseDto(Link entity){
        this.shortId = entity.getShortId();
        this.url = entity.getUrl();
        this.createdAt = entity.getCreatedAt();
        this.aliasName =  entity.getAliasName();
    }
}

package management.shortLink.dto.link;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import management.shortLink.domain.link.Link;

@Getter
@NoArgsConstructor
public class LinkSaveRequestDto {
    private String url;
    private String content;
    private String author;

    @Builder
    public LinkSaveRequestDto(String url){
        this.url = url;
    }

    public Link toEntity(){
        return Link.builder()
                .url(url)
                .build();
    }

}

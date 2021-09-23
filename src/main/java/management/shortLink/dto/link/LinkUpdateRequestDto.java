package management.shortLink.dto.link;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LinkUpdateRequestDto {
    private String aliasName;

    @Builder
    public LinkUpdateRequestDto(String aliasName){
        this.aliasName = aliasName;
    }
}

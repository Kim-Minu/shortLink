package management.shortLink.service.link;

import lombok.RequiredArgsConstructor;
import management.shortLink.domain.link.Link;
import management.shortLink.domain.link.LinkRepository;
import management.shortLink.dto.link.LinkListResponseDto;
import management.shortLink.dto.link.LinkResponseDto;
import management.shortLink.dto.link.LinkSaveRequestDto;
import management.shortLink.dto.link.LinkUpdateRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LinkService {
    private final LinkRepository linkRepository;

    @Transactional
    public String save(LinkSaveRequestDto requestDto){

        return linkRepository.save(requestDto.toEntity()).getShortId();
    }


    public LinkResponseDto findById(String shorId) {
        Link entity = linkRepository.findById(shorId).orElseThrow(()->new IllegalArgumentException("해당 url이 없습니다. id = " + shorId));

        return new LinkResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<LinkListResponseDto> findAllDesc(){
        return linkRepository.findAllDesc().stream()
                .map(LinkListResponseDto::new)
                .collect(Collectors.toList());
    }


    @Transactional
    public String update(String short_id, LinkUpdateRequestDto requestDto) {
        Link link = linkRepository.findById(short_id).orElseThrow(()->new IllegalArgumentException("해당 url이 없습니다. id = " + short_id));
        link.update(requestDto.getAliasName());

        return short_id;
    }

    public LinkResponseDto findByAliasName(String alias_name) {
        Link entity = (Link) linkRepository.findAll().stream().filter(el -> el.getAliasName().equals(alias_name)).collect(Collectors.toList()).get(0);;

        //entity.orElseThrow(()->new IllegalArgumentException("해당 url이 없습니다. id = " + shorId));

        return new LinkResponseDto(entity);
    }

    public Page<Link> getList(Pageable pageable) {
        return linkRepository.findAll(pageable);
    }

    @Transactional
    public void delete (String shorId){
        Link entity = linkRepository.findById(shorId)
                .orElseThrow(()->new IllegalArgumentException("해당 url이 없습니다. id = " + shorId));
        linkRepository.delete(entity);
    }
}

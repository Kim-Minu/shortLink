package management.shortLink.controller.link;

import lombok.RequiredArgsConstructor;
import management.shortLink.domain.link.Link;
import management.shortLink.dto.link.LinkListResponseDto;
import management.shortLink.dto.link.LinkResponseDto;
import management.shortLink.dto.link.LinkSaveRequestDto;
import management.shortLink.dto.link.LinkUpdateRequestDto;
import management.shortLink.service.link.LinkService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class LinkApiController {
    private final LinkService linkService;

    // 1) URL을 입력하면 random한 ID를 가지는 Short Link를 생성해주는 API 개발
    // POST /short-links
    // Request Body
    // url : Short Link를 통해서 Landing이 될 URL
    @PostMapping("/short-links")
    public String save(@RequestBody LinkSaveRequestDto requestDto){
        return linkService.save(requestDto);
    }

    // 2) Short Link를 통해 접속했을 때 원래 입력했던 URL로 redirect 해주는 API 개발
    // GET /r/{short_id}
    @GetMapping("/r/{short_id}")
    public LinkResponseDto findUrl(@PathVariable String short_id){
        return linkService.findById(short_id);
    }

    // 3) Short Link 목록 조회 API 개발 (페이징 필요)
    // GET /short-links?size=50&page=2
    @GetMapping("/short-links")
    public Page<Link> findAllDesc(Pageable pageable){
        return linkService.getList(pageable);
    }

    // 4) Short Link 1개를 조회하는 API 개발
    // GET /short-links/{short_id}
    @GetMapping("/short-links/{short_id}")
    public LinkResponseDto findId(@PathVariable String short_id){
        return linkService.findById(short_id);
    }

    // 5) 기존에 생성된 Short Link의 Alias Name을 추가할 수 있는 API 개발
    // PATCH /short-links/{short_id}
    @PatchMapping("/short-links/{short_id}")
    public String update(@PathVariable String short_id, @RequestBody LinkUpdateRequestDto requestDto) {
        return linkService.update(short_id, requestDto);
    }

    // 6) Alias Name이 포함된 Link를 통해 접속했을 때 원래 입력했던 URL로 redirect 해주는 API 개발
    // GET /a/{alias_name}
    @GetMapping("/a/{alias_name}")
    public LinkResponseDto findByAliasName(@PathVariable String alias_name){
        return linkService.findByAliasName(alias_name);
    }

    // 7) 기존에 생성된 Short Link를 삭제할 수 있는 API 개발
    // DELETE /short-links/{short_id}
    @DeleteMapping("/short-links/{short_id}")
    public String delete(@PathVariable String short_id){
        linkService.delete(short_id);
        return "삭제성공 " + short_id;
    }
}

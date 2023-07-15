package br.com.uniapp.smallGroup;

import br.com.uniapp.smallGroup.model.SmallGroupDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/smallgroup")
public class SmallGroupController {

    @Autowired
    SmallGroupService smallGroupService;

    @GetMapping
    public Page<SmallGroupDto> listAll(@ParameterObject @PageableDefault(size = 10) Pageable pageable){
        return smallGroupService.listAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SmallGroupDto> findById(@PathVariable @NotNull Long id){
        SmallGroupDto smallGroup = smallGroupService.listById(id);
        return ResponseEntity.ok(smallGroup);
    }

    @PostMapping
    public ResponseEntity<SmallGroupDto> saveSmallGroup(@RequestBody @Valid SmallGroupDto smallGroupDto, UriComponentsBuilder uri) {
        SmallGroupDto createdSmallGroup = smallGroupService.saveSmallGroup(smallGroupDto);
        URI address = uri.path("smallgroup/{id}").buildAndExpand(createdSmallGroup.getId()).toUri();
        return ResponseEntity.created(address).body(createdSmallGroup);
    }
}

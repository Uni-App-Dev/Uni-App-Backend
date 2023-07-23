package br.com.uniapp.smallGroup;

import br.com.uniapp.exception.bundle.UniException;
import br.com.uniapp.smallGroup.model.SmallGroupDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<SmallGroupDto> createSmallGroup(@RequestBody @Valid SmallGroupDto smallGroupDto, UriComponentsBuilder uri) throws UniException {
        SmallGroupDto createdSmallGroup = smallGroupService.createSmallGroup(smallGroupDto);
        URI address = uri.path("smallgroup/{id}").buildAndExpand(createdSmallGroup.getId()).toUri();
        return ResponseEntity.created(address).body(createdSmallGroup);
    }

    @PutMapping
    public ResponseEntity<SmallGroupDto> updateSmallGroup(@RequestBody @Valid SmallGroupDto smallGroupDto, UriComponentsBuilder uri) throws UniException {
        SmallGroupDto updatedSmallGroup = smallGroupService.updateSmallGroup(smallGroupDto);
        URI address = uri.path("smallgroup/{id}").buildAndExpand(updatedSmallGroup.getId()).toUri();
        return ResponseEntity.created(address).body(updatedSmallGroup);
    }
}

package com.duonghv.cm.crud.controllers;


import com.duonghv.cm.crud.entities.Profile;
import com.duonghv.cm.crud.repos.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.rest.entities.QueryParamWrapper;
import springboot.rest.exceptions.NotFoundException;
import springboot.rest.services.FilterService;
import springboot.rest.utils.QueryParamExtractor;

@RestController
@RequestMapping("api/v1")
public class ProfileController {

    @Autowired
    private FilterService<Profile, Integer> filterService;

    @Autowired
    private ProfileRepository repo;

    @RequestMapping(value = "profiles", method = RequestMethod.POST)
    public Profile create(@RequestBody Profile profile) {
        return repo.save(profile);
    }

    @RequestMapping(value = "profiles/{id}", method = RequestMethod.PUT)
    public Profile update(@RequestBody Profile profile, @PathVariable int id) {
        profile.setId(id);
        return repo.save(profile);
    }

    @RequestMapping(value = "profiles/{id}", method = RequestMethod.GET)
    public Profile getById(@PathVariable int id) {
        return repo.findById(id).orElseThrow(NotFoundException::new);
    }

    @RequestMapping(value = "profiles", method = RequestMethod.GET)
    public Iterable<Profile> filterBy(
            @RequestParam(required = false, name = "filter") String filterStr,
            @RequestParam(required = false, name = "range") String rangeStr,
            @RequestParam(required = false, name="sort") String sortStr) {
        QueryParamWrapper wrapper = QueryParamExtractor.extract(filterStr, rangeStr, sortStr);
        return filterService.filterBy(wrapper, repo);
    }
}

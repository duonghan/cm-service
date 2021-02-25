package com.duonghv.cm.crud.controllers;


import com.duonghv.cm.crud.entities.Issue;
import com.duonghv.cm.crud.repos.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.rest.entities.QueryParamWrapper;
import springboot.rest.exceptions.NotFoundException;
import springboot.rest.services.FilterService;
import springboot.rest.utils.QueryParamExtractor;

@RestController
@RequestMapping("api/v1")
public class IssueController {

    @Autowired
    private FilterService<Issue, Integer> filterService;

    @Autowired
    private IssueRepository repo;

    @RequestMapping(value = "issues", method = RequestMethod.POST)
    public Issue create(@RequestBody Issue issue) {
        return repo.save(issue);
    }

    @RequestMapping(value = "issues/{id}", method = RequestMethod.PUT)
    public Issue update(@RequestBody Issue issue, @PathVariable int id) {
        issue.setId(id);
        return repo.save(issue);
    }

    @RequestMapping(value = "issues/{id}", method = RequestMethod.GET)
    public Issue getById(@PathVariable int id) {
        return repo.findById(id).orElseThrow(NotFoundException::new);
    }

    @RequestMapping(value = "issues", method = RequestMethod.GET)
    public Iterable<Issue> filterBy(
            @RequestParam(required = false, name = "filter") String filterStr,
            @RequestParam(required = false, name = "range") String rangeStr,
            @RequestParam(required = false, name="sort") String sortStr) {
        QueryParamWrapper wrapper = QueryParamExtractor.extract(filterStr, rangeStr, sortStr);
        return filterService.filterBy(wrapper, repo);
    }
}

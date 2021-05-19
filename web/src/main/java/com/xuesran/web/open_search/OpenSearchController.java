package com.xuesran.web.open_search;

import com.xuesran.services.hello.open_search.OpenSearchDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Open search controller.
 *
 * @author xueshun
 */
@RestController
@RequestMapping(value = "/open-search")
public class OpenSearchController {

    private final OpenSearchDemoService openSearchDemoService;

    @Autowired
    public OpenSearchController(OpenSearchDemoService openSearchDemoService) {
        this.openSearchDemoService = openSearchDemoService;
    }

    @GetMapping(value = "/put/{id}")
    public Boolean put(@PathVariable String id) {
        openSearchDemoService.put(Integer.parseInt(id));
        return Boolean.TRUE;
    }
}

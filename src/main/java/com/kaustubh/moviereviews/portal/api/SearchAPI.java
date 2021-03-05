package com.kaustubh.moviereviews.portal.api;

import com.kaustubh.moviereviews.portal.services.SearchService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchAPI {

    @Autowired
    private SearchService searchService;

    @GetMapping("/")
    @ApiOperation(value = "Search for movies or actors", notes = "Returns list of movies and actors")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Results returned"),
                    @ApiResponse(code = 404, message = "No results")
            }
    )
    public ResponseEntity<List<Object>> search(
            @ApiParam(value = "Search query", required = true) @RequestParam String query) {
        List<Object> res = searchService.search(query);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}

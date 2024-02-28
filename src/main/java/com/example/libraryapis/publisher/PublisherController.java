package com.example.libraryapis.publisher;

import com.example.libraryapis.exception.LibraryResourceAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/publishers")
public class PublisherController {

    private PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping(path = "/{publisherId}")
    public Publisher getPublisher(@PathVariable Integer publisherId) {
        return new Publisher(publisherId, "PrentisHall", "prentis@gmal.com", "123-456-789");
    }

    @PostMapping
    public ResponseEntity<?> createPublisher(@RequestBody Publisher publisher) {
        try {
            publisher = publisherService.addPublisher(publisher);
        } catch (LibraryResourceAlreadyExistException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(publisher, HttpStatus.CREATED);
    }

}
